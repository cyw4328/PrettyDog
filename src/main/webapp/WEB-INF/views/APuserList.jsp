<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자-회원리스트(메인)</title>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
    <script src="resources/js/jquery.twbsPagination.js"></script>
	<style>

	</style>
</head>
<body>
	<%@ include file="APside.jsp"%>
    <h2>회원 목록</h2>
    <table border="1" width="700px">
        <tr>
            <th>이름</th>
            <th>닉네임</th>
            <th>아이디</th>
            <th>가입일</th>
            <th>이메일</th>
            <th>전화번호</th>
            <th>보유 포인트</th>
            <th>회원상태</th>
            <th>회원등급</th>
        </tr>
        <c:forEach var="mem" items="${userlist}">
        <tr>
            <td>${mem.mem_name}</td>
            <td>${mem.mem_nick}</td>
            <td><a href="apuserdetail?id=${mem.mem_id}">${mem.mem_id}</a></td>
            <td>${mem.mem_date}</td>
            <td>${mem.mem_email}</td>
            <td>${mem.mem_tel}</td>
            <td>${mem.mem_point}</td>
            <td>${mem.mem_state}</td>
            <td>${mem.mem_rank}</td>
        </tr>
        </c:forEach>
    </table>
</body>
<script>

</script>
</html>