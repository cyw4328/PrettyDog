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
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
	

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <!-- <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> -->
    <script src="resources/js/jquery.twbsPagination.js"></script>
   <style></style>
</head>
<body>

	<section style="width: 100%; height: 84px; display: flex; background-color: rgb(66, 52, 52);">
        <%@ include file="Header.jsp"%>
	</section>

	<!-- <h2>여긴 매장 상세페이지</h2> -->
	<input type="hidden" name="busin_num" id="busin_mem_chk" value="${sshShopDetail[0].busin_num }"/>
	<input type="hidden" name="mem_id" id="busin_mem_id_chk" value="${sshShopDetail[0].mem_id }"/>
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
		<div style="position: absolute; left: 320px; top: 640px;">
		<jsp:include page="/WEB-INF/views/reserCalendar.jsp"/>
		</div>
	<div style='width:800px;margin:0 auto;margin-top:50px;'>
	<ul class="nav nav-tabs" style="position: absolute; left: 20px; top: 1350px; margin-left: 300px;">
		<li class='active'><a href="#tabmenu_01" data-toggle="tab">리뷰</a></li>
		<li><a href="#tabmenu_02" data-toggle="tab">QnA</a></li>
	</ul>
	<div class="tab-content" style="position: absolute; left: 20px; top: 1400px; margin-left: 300px;">
		<div class="tab-pane fade" id="tabmenu_01"><jsp:include page="/WEB-INF/views/sshShopReviewList.jsp"/></div>
		<div class="tab-pane fade" id="tabmenu_02"><jsp:include page="/WEB-INF/views/sshShopQnaList.jsp"/></div>
	</div>
</div>
</body>
<script>
	//console.log(loginId);
	
	var busin_mem_chk = $("#busin_mem_chk").val();
	
	likeChk();
	function likeChk() {
		if('${sshMyInterestShop_size}' > 0){
			$("#like").text("♥");
		}else{
			$("#like").text("♡");
		}
	}

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
	
	/*
	var busin_num = '${sshShopDetail[0].busin_num }';
	console.log("busin_num busin_num busin_num" + busin_num);
	$.ajax({
		url: "updateLike",
		type: "GET",
		data: {'busin_num':busin_num},
		dataType: "JSON",
		success: function (data) {
				console.log(data.msg);
				if (data.msg != null) {
					alert(data.msg)
				}else if(data.LikeCheck == 1) {
					alert("매장 추천 취소했당개!");
				}else{
					alert("추천 완료했당개");
				}			
		},					
		error : function () {
			alert("추천에 실패했당개");
		}
	});
	*/
</script>
</html>














































































































































