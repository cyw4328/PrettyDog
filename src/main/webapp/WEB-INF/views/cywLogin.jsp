<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>이쁘개 로그인</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		#AllPage{
			position: relative;
			top: 200px;
			left: 650px;
		}
		#LoginSub{
			font-size: 30px;
			position: absolute;
			left: 65px;
			
		}
		#LoginForm{
			position: absolute;
			top: 110px;
		}
		#SearchBtn{
			position: absolute;
			top: 220px;
			left: 40px;
		}
		
		#JoinFormBtn{
			position: absolute;
			top: 250px;
		}
		input[type="text"],input[type="password"]{
			height: 30px;
			width: 250px
		}
		input[type="submit"]{
			width: 250px;
			height: 30px;
			background-color: black;
			color: white;
			font-size: 15px;
		}
		input[type="button"]{
			width: 130px;
			height: 30px;
			background-color: rightgray;
			color: black;
			font-size: 13px;
		}
		 a:link { color: black; text-decoration: none;}
		 a:visited { color: black; text-decoration: none;}
		 a:hover { color: red; text-decoration: none;}

		
	</style>
</head>
<body>
	<div id="AllPage">
		<div id="LoginSub">
			<h2>LOGIN</h2>
		</div>
		<div id="LoginForm">
			<form action="login" method="post">
				<table>
					<tr>
						<td><input type="text" placeholder="ID" name="idInput"/></td>
					</tr>
					<tr>
						<td><input type="password" placeholder="PW" name="pwInput"/></td>
					</tr>
					<tr>
						<td id="loginBtn"><input type="submit" value="Login"/></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="SearchBtn">
			<a href="./idSearchPage">아이디찾기</a>&nbsp;/&nbsp;<a href="./pwSearchPage">비밀번호찾기</a>
		</div>
		<div id="JoinFormBtn">
			<input type="button" value="일반 회원가입" class="joinForm" id="nomalmem"/><input type="button" value="업주 회원가입" class="joinForm"/>
		</div>
	</div>	
</body>
<script>
var msg = "${msg}";

if (msg != "") {
	alert(msg);
}

var msg1 = "${msg1}";

if (msg1 != "") {
	alert(msg1);
}

$('#nomalmem').click(function() {
	window.location.href="./JoinFormshs";
})


</script>
</html>