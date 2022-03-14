<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>카테고리 추가</title>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
	<link rel="stylesheet"  type="text/css" href="resources/css/common.css">
	<script src="resources/js/jquery.twbsPagination.js"></script>
	<style>
	#AllPage{
		position: relative;
		top: 50px;
		left: 50px;
	}
	#CateGoryAdd{
		position: absolute;
		top: 30px;
		left: 20px;
		font-size: 20px;
	}
	 #categoryListDiv{
		position: absolute;
		top: 70px;
		left: 10px;
	}
	table {
			border-collapse: collapse;
			text-align: left;
			line-height: 1.5;
			border: 1px solid #ccc;
			margin: 20px 10px;
			width: 600px;
		}
		table thead {
			border-right: 1px solid #ccc;
			border-left: 1px solid #ccc;
			background: #e7708d;
		}
		table thead th {
			padding: 10px;
			font-weight: bold;
			vertical-align: top;
			color: #fff;
		}
		table tbody th {
			width: 150px;
			padding: 10px;
			font-weight: bold;
			vertical-align: top;
			border-bottom: 1px solid #ccc;
			background: #fcf1f4;
		}
		table td {
			width: 350px;
			padding: 10px; 
			vertical-align: top;
			border-bottom: 1px solid #ccc;
		}
		input[name="categoryName"]{
			width: 300px;
			height: 50px;
		}
		input[name="categoryBtn"]{
			width: 100px;
			height: 50px;
			background-color: pink;
			color: white;
			border: 0;
		}
		input[name="categoryBtn"]:hover {
			background-color: black;
		}
	</style>
</head>
<body>
	<div id="AllPage">
		<div id="CateGoryAdd">
			<form action="cateGoryAdd" id="addForm">
				<input type="text" placeholder="내용을 입력해주세요." name="categoryName"/>&nbsp;
				<input type="radio" value="0" name="categoryClass"/>&nbsp;일반회원용&nbsp;&nbsp;
				<input type="radio" value="1" name="categoryClass"/>&nbsp;관리자용&nbsp;&nbsp;
				<input type="button" value="추가" id="categoryBtn" name="categoryBtn"/>
			</form>
		</div>
		<div id="categoryListDiv">
			<table>
				<thead>
					<tr>
						<th>카테고리명</th>
						<th>구분</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody id="cateGoryList">
					<%-- <c:forEach items="${list }" var="list">
						<tr>
							<td>${list.category_name}<td>
							<c:if test="${list.category_admin eq 0}">
								<td>일반회원용</td>
							</c:if>
							<c:if test="${list.category_admin eq 1}">
								<td>관리자용</td>
							</c:if>
							<td><a href="#">삭제</a></td>
						</tr>
					</c:forEach> --%>
				</tbody>
				<tr>
					<td colspan="3" id="paging">
						<div class="container">                           
	               			<nav aria-label="Page navigation" style="text-align:center">
	                  			<ul class="pagination" id="pagination"></ul>
	              			</nav>               
	            		</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script>
var currPage = 1;
var totalPage = 2;

listCall(currPage,5);


function listCall(page,cnt) {
	
	// 페이지 도착하자마자 ajax 실행
	$.ajax({
		type:'GET',
		url:'categoryListCall',
		data:{'page':page,'cnt':cnt}, // {}안에 아무것도 안넣으면 다보여줘라 라는 뜻
		dataType:'JSON',
		success:function(data) {
			
			totalPage = data.pages;
			listDraw(data.list);
			
			$('#pagination').twbsPagination({
				startPage:currPage, // 현재 페이지
				totalPages:totalPage, // 만들수 있는 총 페이지 수
				visiblePages:5, // [1][2][3]... 이걸 몇개까지 보여줄 것인가? 밑에 페이지클릭숫자
				onPageClick:function(event,page) { // 해당 페이지 번호를 클릭 했을때 일어날 일들
					console.log(event); // 현재 일어나는 클릭 이벤트 관련 정보들
					console.log(page); // 몇 페이지를 클릭 했는지에 대한 정보
					listCall(page,5);
				}
			});
			
		},
		error:function(e) {
			console.log(e);
		}
	});
}

function listDraw(list) {
    var content = '';
    var admin = "";
    
    list.forEach(function(item,category_num) {
    	
    	if (item.category_admin == 0) {
			admin = '<td>'+"일반회원용"+'</td>';
		}else {
			admin = '<td>'+"관리자용"+'</td>';
		}
    	
    	content += '<tr>'
    	content += '<td>'+item.category_name+'</td>';
    	content += admin
    	content += '<td>'+'<a href="./categoryDel?category_num='+item.category_num+'">'+"삭제"+'</a>'+'</td>';
    });
    $('#cateGoryList').empty();
    $('#cateGoryList').append(content);
}

$('#categoryBtn').click(function() {
	
	var $categoryName = $('input[name="categoryName"]');
	var $categoryClass = $('input[name="categoryClass"]:checked');
	
	console.log($categoryName.val());
	console.log($categoryClass.val());
	
	if ($categoryName.val() == '') {
		alert("카테고리 이름을 입력해주세요.");
	}else if ($categoryClass.val() == null) {
		alert("카테고리 구분을 선택해주세요.")
	}else {
		$('#addForm').submit();
	}
	
})

var msg = "${msg}"; 

if (msg != "") {
	alert(msg);
}

var msg1 = "${msg1}"; 

if (msg1 != "") {
	alert(msg1);
}

</script>
</html>