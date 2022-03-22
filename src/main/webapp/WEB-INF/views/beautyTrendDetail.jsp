<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style></style>
</head>
<body>
	<h2>미용 트렌드</h2>
	<h4>제목</h4>
	<p>${beautyTrendDetail.community_sub }</p>
	<h4>내용</h4>
	<p>${beautyTrendDetail.community_cont }</p>
	<%-- <img src="resources/trend/${beautyTrendDetail.bphoto_newname }" width="350px" height="350px" style="padding-left: 70px; display: block;"/> --%>
	<img src="resources/trend/${beautyTrendDetail.bphoto_newname }" width="350px" height="350px" style="padding-left: 70px; display: block;"/>
	<button onclick="location.href='beautyTrendList'">뒤로가기</button>
	<button onclick="location.href='sshShopDetail?idx=${beautyTrendDetail.busin_num}&memId=a1'">매장이동</button>
	<%-- <button onclick="location.href='beautyTrendUpdate?idx=${beautyTrendDetail.community_boardnum}'">수정</button> --%>
</body>
<script></script>
</html>

























































































