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
	<h2>�̿� Ʈ����</h2>
	<h4>����</h4>
	<p>${beautyTrendDetail.community_sub }</p>
	<h4>����</h4>
	<p>${beautyTrendDetail.community_cont }</p>
	<%-- <img src="resources/trend/${beautyTrendDetail.bphoto_newname }" width="350px" height="350px" style="padding-left: 70px; display: block;"/> --%>
	<img src="resources/trend/${beautyTrendDetail.bphoto_newname }" width="350px" height="350px" style="padding-left: 70px; display: block;"/>
	<button onclick="location.href='beautyTrendList'">�ڷΰ���</button>
	<button onclick="location.href='sshShopDetail?idx=${beautyTrendDetail.busin_num}&memId=a1'">�����̵�</button>
	<%-- <button onclick="location.href='beautyTrendUpdate?idx=${beautyTrendDetail.community_boardnum}'">����</button> --%>
</body>
<script></script>
</html>

























































































