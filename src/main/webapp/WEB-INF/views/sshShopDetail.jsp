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
	<input type="text" name="busin_num" value="${sshShopDetail[0].busin_num }"/>
	<div style="position: absolute; left: 20px; top: 100px; margin-left: 300px;">
		<img width="300px" height="300px" src="resources/img/${sshShopDetail[0].interior_newname }"/>
	</div>
	<div style="position: absolute; left: 20px; top: 100px; margin-left: 650px; margin-top: 20px;">
		<p style="font-weight: bold; font-size: x-large;">${sshShopDetail[0].busin_name }</p>
		<p style="font-weight: bold; font-size: large; margin-top: 20px;">${sshShopDetail[0].busin_juso }</p>
		<p style="font-weight: bold; font-size: large; margin-bottom: 60px;">${sshShopDetail[0].mem_tel }</p>
		<c:if test="${sshShopDetail[0].busin_smalldog == 1 }">
			<button style="width: 90px; height: 40px; font-size: large;">소형견</button>
		</c:if>
		<c:if test="${sshShopDetail[0].busin_middledog == 1 }">
			<button style="width: 90px; height: 40px; font-size: large;">중형견</button>
		</c:if>
		<c:if test="${sshShopDetail[0].busin_bigdog == 1 }">
			<button style="width: 90px; height: 40px; font-size: large;">대형견</button>
		</c:if>
		<p id="like" style="font-size: xx-large; font-size: 50px; cursor : pointer;">${sshMyInterestShop_size }</p><span style="font-size: large; position: absolute; left: 60px; top: 255px;">${sshShopDetail[0].busin_likes }</span>
	</div>
		<textarea style="position: absolute; left: 20px; top: 430px; margin-left: 300px;" cols="100" rows="10" readonly>${sshShopDetail[0].busin_info }</textarea>
	<div style='width:800px;margin:0 auto;margin-top:50px;'>
	<ul class="nav nav-tabs" style="position: absolute; left: 20px; top: 700px; margin-left: 300px;">
		<li class='active'><a href="#tabmenu_01" data-toggle="tab">리뷰</a></li>
		<li><a href="#tabmenu_02" data-toggle="tab">QnA</a></li>
	</ul>
	<div class="tab-content" style="position: absolute; left: 20px; top: 750px; margin-left: 300px;">
		<div class="tab-pane fade in active" id="tabmenu_01"><jsp:include page="/WEB-INF/views/sshShopReviewList.jsp"/></div>
		<div class="tab-pane fade" id="tabmenu_02"><jsp:include page="/WEB-INF/views/sshShopQnaList.jsp"/></div>
	</div>
</div>
</body>
<script>
	console.log('${memId}');
	likeChk();
	function likeChk() {
		if('${sshMyInterestShop_size}' > 0){
			$("#like").text("♥");
		}else{
			$("#like").text("♡");
		}
	}
	/*
	$("#like").click(function () {
		console.log("여기까지는 옴?");
		if('${sshMyInterestShop_size}' > 0){
			$("#like").text("♡");
			location.href='myShopLike?likeVal='+${sshMyInterestShop_size}+'&memId='+'${memId}'+'&idx='+'${sshShopDetail[0].busin_num }';
		}else{
			$("#like").text("♥");
			location.href='myShopLike?likeVal='+${sshMyInterestShop_size}+'&memId='+'${memId}'+'&idx='+'${sshShopDetail[0].busin_num }';
		}
	})
	*/
	$("#like").click(function () {
		
	})
	}
</script>
</html>














































































































































