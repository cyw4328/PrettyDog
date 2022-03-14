<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>이쁘개 비밀번호 바꾸기</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		input[type="submit"]{
			border-radius: 7px / 7px;
			background-color: black;
			color: white;
			width: 250px;
			height: 40px;
		}
		input[type="text"]{
			width: 250px;
			height: 40px;
		}
		#AllPage{
			position: relative;
			top: 200px;
			left: 650px;
		}
		#PwChangeSub{
			position: absolute;
		}
		#PwChangeCont{
			position: absolute;
			top: 70px;
			left: 30px;
		}
	</style>
</head>
<body>
	<div id="AllPage">
		<form action="PwChange" method="post" onsubmit="return submitCheck();">
			<div id="PwChangeSub">
				<h2>${loginId} 님 비밀번호 재설정</h2>
			</div>
			<div id="PwChangeCont">
				<table>
					<tr>
						<td><input type="hidden" name="Id" value="${loginId}"></td>
					</tr>
					<tr>
						<td><input type="text" placeholder="비밀번호" name="pwInput"></td>
					</tr>
					<tr>
						<td>
							<input type="text" placeholder="비밀번호 확인" name="pwcheck">
							<div class="alert" id="alert-pws" style="color: red;">비밀번호를 확인해주세요</div>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="확인"/></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
<script>
	$('#alert-pws').hide();
	var check = false;
	var $inputPw = "";
	var $inputCheck = "";
	
	
	$("input[name='pwInput']").keyup(function() {
		console.log("??");
		$inputPw = $('#pwInput').val();
		if ($inputPw != "" && $inputCheck != "") {
			$("#alert-pws").hide();
			check = true;
		}else {
			$("#alert-pws").show();
			check = false;
		}
	})
	
		$("input[name='pwcheck']").keyup(function() {
		$inputCheck = $('#pwcheck').val();
		if ($inputPw != "" && $inputCheck != "") {
			$("#alert-pws").hide();
			check = true;
		}else {
			$("#alert-pws").show();
			check = false;
		}
	})
	
	  function submitCheck() {
    	   if(check != true) {
    		  
    	   		return false;
			}	
    	  		return true
    	}
	
</script>
</html>