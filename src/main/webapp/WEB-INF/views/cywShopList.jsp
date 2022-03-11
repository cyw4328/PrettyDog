<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>이쁘개</title>
     <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
    <script src="resources/js/jquery.twbsPagination.js"></script>
	<style>
		body{
			background-color: #F8ECF2;
		}
		#allpage{
			position: relative;
			width: 1400px;
			height: 1500px;
		}
		select{
			width: 200px;
			padding: .8em .5em;
			font-family: inherit;
			background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 95% 50%;
			border: 1px solid #999; border-radius: 0px;
			-webkit-appearance: none;
			-moz-appearance: none; appearance: none;
		}
		#inputShop{
			width: 250px;
			height: 40px;
			background: no-repeat 95% 50%;
		}
		#serchBtn{
			  width:100px;
			    background-color: #0C0509;
			    border: none;
			    color:#fff;
			    padding: 10px 0;
			    text-align: center;
			    text-decoration: none;
			    display: inline-block;
			    font-size: 15px;
			    margin: 4px;
			    cursor: pointer;
		}
		td{
			padding: 50px;
			width: 420px;
			font-size: 20px;
		}
		#searchForm{
			position: absolute;
			left: 250px;
			top: 140px;
			background-color: white;
			height: 50px;
		}
		.shoplist{
			position: absolute;
			top: 230px;
			left: 110px;
		}
		img:hover{
			cursor: pointer;
		}
		.likebtn{
			border: 0;
			outline: 0;
		}
		#pt{
			position: absolute;
		}
	</style>
</head>
<body>
	<div id="allpage">
	<input type="button" value="포인트내역" id="pt"/>
		<div id="searchForm">
			<form id="searchFormTag" action="shopSerch" method="post">
				<input type="hidden" name="hiddenFilter" id="hiddenFilter" value="">
				<select name="areaScope">
		
					<option <c:if test="${empty params.areaScope}">selected="selected"</c:if> value="">지역선택</option>
					<c:forEach items="${fn:split(selectAreaScope,',')}" var="item">
						<option value="${item}" <c:if test="${item eq params.areaScope}">selected="selected"</c:if>>${item }</option>
					</c:forEach>
					
				</select>
				
				<select name="dogScope">
					<option <c:if test="${empty params.dogScope}">selected="selected"</c:if> value="0">견종선택</option>
					
					<c:forEach items="${fn:split(selectDogScope,',')}" var="item2" varStatus="status">
						<option value="${status.count}" <c:if test="${status.count eq params.dogScope }">selected="selected"</c:if>>${item2 }</option>
					</c:forEach>

				</select>
				<select name="serviceScope" id="addService">
					<option <c:if test="${empty params.serviceScope}">selected="selected"</c:if> value="0">서비스선택</option>
					
					<c:forEach items="${fn:split(selectServiceScope,',')}" var="item3" varStatus="status">
						<option value="${status.count}" <c:if test="${status.count eq params.serviceScope }">selected="selected"</c:if>>${item3 }</option>
					</c:forEach>
				</select>
				
				<input type="text" placeholder="매장명입력" name="nameScope" id="inputShop"/>
				
				<input type="submit" value="검색" id="serchBtn"/> 
			</form>

			<p style="text-align:right;">
				<a href="javascript:test1();">추천순</a>&nbsp;|&nbsp;
				<a href="javascript:test2();">낮은가격순</a>&nbsp;|&nbsp;
				<a href="javascript:test3();">높은가격순</a>
			</p>
			
		</div>
	
		<div class="shoplist">
			<c:set var="i" value="0" /> 
			<c:set var="j" value="3" /> 
			
			<table style="border: none; text-align: center;" id="shopTable"> 

				<c:forEach items="${shopList }" var="list"> 
					<c:if test="${i%j == 0 }"> 
						<tr> 
					</c:if> 
					<td class="shopPaging">
						<input type="hidden" value="${list.busin_num}" id="shopDetail"/> 
						<img src="resources/img/${list.interior_newname}"/ style="width: 200px;height: 250px" class="shopimg"/>

					<br/>
					${list.busin_name} 
					<c:choose>
						<c:when test="${LikeCheck eq '0' or empty LikeCheck }">
							<input type="hidden" value="${list.busin_num}" id="likes1num"/>
							<input type="button" value="♡" class="likebtn"/>&nbsp;${list.busin_likes}
							<%-- <a href="javascript:likes1()">♡<input type="hidden" value="${list.busin_num}" id="likes1num"/>
							</a>&nbsp;${list.busin_likes} --%>
						</c:when>
						<c:otherwise>
							<input type="hidden" value="${list.busin_num}" id="likes1num"/>
							<input type="button" value="♥" class="likebtn"/>&nbsp;${list.busin_likes}
						
	
						</c:otherwise>
					</c:choose>
					<br/>
					<b>${list.price_cost}Point</b>
					</td> 		
					<c:if test="${i%j == j-1 }"> 
					</tr> 
					</c:if> 
					<c:set var="i" value="${i+1 }" /> 
				</c:forEach> 
				
			</table>
	
	
		</div>
	</div>
	
</body>
<script>

function test1(){
	$('#hiddenFilter').val('recomendFilter');
	$('#searchFormTag').submit();
}
function test2(){
	$('#hiddenFilter').val('lowPriceFilter');
	$('#searchFormTag').submit();
}
function test3(){
	$('#hiddenFilter').val('highPriceFilter');
	$('#searchFormTag').submit();
}


$('.likebtn').click(function() {
	
	var $busin_num = $(this).prev().val()
	console.log($busin_num);
	
	$.ajax({
		url: "updateLike",
		type: "GET",
		data: {'busin_num':$busin_num},
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
});

$('.shopimg').click(function() {
	var $busin_num = $(this).prev().val();
	 console.log("매장상세보기",$busin_num);
	 alert("매장상세보기는 준비중입니다.");
});





var success = "${success}" ;
if (success > 0) {
	alert("충전이 완료되었습니다.");
}

$('#pt').click(function() {
	window.location.href="./pointListPage";
})
</script>
</html>