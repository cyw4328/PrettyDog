<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>포인트 충전</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
	
	</style>
</head>
<body>
	<h3>포인트 충전</h3>
	
	<div>
		<div>
			<h4>${loginId} 님의 현재 보유 포인트</h4><h5>point</h5>
		</div>
		<form action="pointInsert" id="pointadd">
			<div>
				<input type="radio" value="5000" name="point">5,000POINT&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="10000" name="point">10,000POINT<br/>
				<input type="radio" value="15000" name="point">15,000POINT&nbsp;&nbsp;<input type="radio" value="20000" name="point">20,000POINT<br/>
				<input type="radio" value="25000" name="point">25,000POINT&nbsp;&nbsp;<input type="radio" value="30000" name="point">30,000POINT<br/>
				<input type="radio" value="35000" name="point">35,000POINT&nbsp;&nbsp;<input type="radio" value="40000" name="point">40,000POINT<br/>
				<input type="radio" value="45000" name="point">45,000POINT&nbsp;&nbsp;<input type="radio" value="50000" name="point">50,000POINT<br/>
				
				<ul>
					<li><input type="radio" value="5000" name="point">&nbsp;5,000POINT<input type="radio" value="10000" name="point">10,000POINT</li>
					<li><input type="radio" value="15000" name="point">15,000POINT<input type="radio" value="20000" name="point">20,000POINT</li>
				</ul>				
			</div>
			<div>
				<input type="button" value="돌아가기" id="backBtn"/><input type="button" value="충전하기" id="addBtn"/>
			</div>
		</form>
		<div>
			<p>
				충전하기 누르신 후<br/>
				카카오뱅크 3333-06-3782406 최영우로 입금부탁드립니다.<br/>
				입금이 확인되면 충전이 완료됩니다.
			</p>
		</div>
	</div>
</body>
<script>
var success = "${success}" ;
if (success > 0) {
	alert("충전이 완료되었습니다.");
}

$('#backBtn').click(function() {
	window.location.href="./pointListPage";
})

$('#addBtn').click(function() {
	var $point = $('input[name="point"]:checked');
	console.log($point);
 
	if ($point.val() == null) {
		alert('충전할 금액을 정하랑개');
	}else{
		let result = confirm('충전을 진행하시겠습니까?');
		$('#pointadd').submit();
	}
	
});


</script>
</html>