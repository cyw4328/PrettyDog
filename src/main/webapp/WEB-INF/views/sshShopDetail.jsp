<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <style></style>
</head>
<body>
	<h2>여긴 매장 상세페이지</h2>
	<p>${sshShopDetail[0].busin_name }</p>
	
	<div style='width:800px;margin:0 auto;margin-top:50px;'>
	<ul class="nav nav-tabs">
		<li class='active'><a href="#tabmenu_01" data-toggle="tab">탭메뉴1</a></li>
		<li><a href="#tabmenu_02" data-toggle="tab">탭메뉴2</a></li>
		<li><a href="#tabmenu_03" data-toggle="tab">탭메뉴3</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane fade in active" id="tabmenu_01"><jsp:include page="/WEB-INF/views/sshShopQnaList.jsp"/></div>
		<div class="tab-pane fade" id="tabmenu_02"><p>탭메뉴2 내용</p></div>
		<div class="tab-pane fade" id="tabmenu_03"><p>탭메뉴3 내용</p></div>
	</div>
</div>
</body>
<script>

   
</script>
</html>














































































































































