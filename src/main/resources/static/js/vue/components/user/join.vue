<template>
<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					
						<div class="form-group">
							<label for="user_name">이름</label>
							<input type="text" id="user_name" v-model="user_name" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="user_id">아이디</label>
							<div class="input-group">
								<input type="text" id="user_id" v-model="user_id" class="form-control" @keydown='resetCheckId'/>
								<div class="input-group-append">
									<button type="button" @click='check_user_id_exist' class="btn btn-primary">중복확인</button>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="user_pw">비밀번호</label>
							<input type="password" id="user_pw" v-model="user_pw" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="user_pw2">비밀번호 확인</label>
							<input type="password" id="user_pw2" v-model="user_pw2" class="form-control"/>
						</div>
						<div class="form-group">
							<div class="text-right">
								<button type="button" @click='check_input' class="btn btn-primary">회원가입</button>
							</div>
						</div>
					
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>
</template>
<script>
	module.exports = {
		data : function(){
			return {
				user_name : '',
				user_id : '',
				user_pw : '',
				user_pw2 : '',
				check_user_id : false
			}
		},
		methods : {
			check_input : function(){
				if(this.user_name.length < 2){
					alert("이름은 두 글자 이상 입니다")
					this.user_name = ''
					$("#user_name").focus()
					return
				}
				if(this.user_id.length < 4){
					alert("아이디는 4글자 이상입니다")
					this.user_id = ''
					$("#user_id").focus()
					return
				}
				if(this.user_pw.length < 4){
					alert("비밀번호는 4글자 이상입니다")
					this.user_pw = ''
					$("#user_pw").focus()
					return
				}
				if(this.user_pw2.length < 4){
					alert("비밀번호는 4글자 이상입니다")
					this.user_pw2 = ''
					$("#user_pw2").focus()
					return false
				}
				if(this.user_pw != this.user_pw2){
					alert("비밀번호가 일치하지 않습니다")
					this.user_pw = ''
					this.user_pw2 = ''
					$("#user_pw").focus()
					return
				}
				if(this.check_user_id == false){
					alert('아이디 중복 확인을 해주세요')
					$("#user_id").focus()
					return
				}
				
				var params = new URLSearchParams()
				params.append('user_name', this.user_name)
				params.append('user_id', this.user_id)
				params.append('user_pw', this.user_pw)
				
				axios.post('server/user/join_user.jsp', params).then((response) => {
					if(response.data.result == true){
						alert('가입이 완료되었습니다')
						this.$router.push('/login')	
					}
				})
				
				
			},
			check_user_id_exist : function(){
				
				var params = new URLSearchParams()
				params.append("user_id", this.user_id)
				
				axios.post('server/user/check_user_id.jsp', params).then((response) => {
					if(response.data.check_result == true){
						alert('사용할 수 없는 아이디 입니다')
						this.user_id = ''
						$("#user_id").focus()
						this.check_user_id = false
					} else {
						alert('사용할 수 있는 아이디 입니다')
						this.check_user_id = true
					}
				})
			},
			resetCheckId : function(){
				this.check_user_id = false
			}
		}
	}
</script>














