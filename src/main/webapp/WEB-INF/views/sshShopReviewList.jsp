<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
    <style>
		#ReviewTitle {
			font-size: 30px;
		}
		#assessment {
			font-size: 20px;
		}
    </style>
</head>
<body>
	<c:if test="${revLength_size > 0 }">
	<form action="reviewWrite" method="post" enctype="multipart/form-data">
	<input name="busin_num" type="hidden" value="${sshShopDetail[0].busin_num }" />
	<input name="mem_id" type="hidden" value="${memId }">
		<p>
			<span id="ReviewTitle"> 리뷰 작성</span>
			(이용완료하신 회원님께서만 작성 가능합니다.)
			<span id="assessment"> 매장 평가</span>
			<select name="apprai_cont">
				<option value="5">5</option>
				<option value="4">4</option>
				<option value="3">3</option>
				<option value="2">2</option>
				<option value="1">1</option>
			</select>
		</p>
		<input type="hidden" name="reser_num" value="${reser_num }"/>
		<textarea cols="70" rows="5" placeholder="내용을 입력해 주세요" id="RevTextWrite" name="shop_boardcont"></textarea>
		<input type="submit" value="등록">
		<input type='file' id='btnAtt' name="photos" multiple='multiple' />
		<p>1장의 사진만 등록 가능</p>
	</form>	
	</c:if>
	<c:if test="${revLength_size == 0 }">
		
	</c:if>
	<c:forEach items="${sshShopRevList }" var="sshShopRevList">
	<input type="hidden" name="shop_boardnum" value="${sshShopRevList.shop_boardnum }"/>
	<%-- <input type="hidden" name="memId" value="${memId }"/> --%>
	<input type="hidden" name="busin_num" value="${sshShopRevList.busin_num }"/>
	<p style="font-weight: bold;">${sshShopRevList.mem_id }</p>
	<p style="margin-top: -10px;">${sshShopRevList.shop_boarddate }<span> 평점 : ${sshShopRevList.apprai_cont }</span></p>
	<img style="width: 50px; height: 50px;" src="resources/rev/${sshShopRevList.sphoto_newname }"/>
	<p>${sshShopRevList.shop_boardcont }</p>
	<!--  
	<c:if test="${memId == sshShopRevList.mem_id }">
		<a href="ReviewDelete?idx=${sshShopRevList.shop_boardnum }&newFilename=${sshShopRevList.sphoto_newname }
		&memId=${memId}&busin_num=${sshShopRevList.busin_num}">삭제</a>
	</c:if>
	-->
	</c:forEach>
</body>
<script>

	var memId = '${memId}'; // 로그인 아이디
	
	
</script>
</html>














































































































































