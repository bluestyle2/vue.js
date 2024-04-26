<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script>
  //onLoad
  $(document).ready(function(){
	  $("#btnLogin").on("click", function(){
		  $.ajax({
				type : "POST",
				url : "/login",
				async : true,
				dataType : "text",
				data : {
					id : $("#id").val(),
					pw : $("#pw").val()
				},
				success : function(data, textStatus, jqXHR){
					console.log(data);
					console.log(textStatus);
					
					let resultData = JSON.parse(data);
					
					if(resultData.resCode == "S"){
						alert("로그인 성공");
						window.location = "http://localhost/dashboard/dashboard.do"	
					}else{
						alert("로그인 실패")
						
					}
					
					
				},
				error : function(jqXHR, testStatus, errorThrown){
					alert("로그인 실패");
				}
			})	  
	  })
	
  })
  </script>
</head>
<body>
	아이디: <input id="id">
	비밀번호: <input id="pw">
	<button id="btnLogin">로그인</button>
</body>
</html>