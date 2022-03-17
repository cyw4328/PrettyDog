<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>신고목록</title>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
	<script src="resources/js/jquery.twbsPagination.js"></script>
	<style>
		table {
			border-collapse: collapse;
			/* text-align: left; */
			line-height: 1.5;
			border: 1px solid #ccc;
			margin: 20px 10px;
			/* width: 600px; */
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
		#Allpage{
			position: relative;
			top: 150px;
			left: 300px;
		}
		#AddForm{
			position: absolute;
			top: 80px;
			left: 1000px;

		}
		#HangmokList{
			position: absolute;
			top: 120px;
			/* left: 10px; */
		}
		input[type="button"]{
			width: 180px;
			height: 40px;
			background-color: black;
			color: white;
		}
		.ChangeSingeBtn{
			width: 110px;
			height: 25px;
			background-color: black;
			color: white;
		}
		.table1{
			width: 64%;
		    max-width: 100%;
		    margin-bottom: 20px;
			table-layout: fixed;
		}
		.ChangeBtn{
			width: 110px;
			height: 30px;
			background-color: lightgray;
			color: black;
			border: 0;
		}
		.ChangeBtn:hover {
			background-color: black;
			color: white;
		}

	</style>
</head>
<body>
	<div id="Allpage">
		<div id="AddForm">
			<input type="button" value="처리된예약목록보기" id="processBtn"/>
		</div>
		<div id="HangmokList">
			<table class="table1">
				<thead>
					<tr>
						<th>신고자아이디</th>
						<th>신고당한아이디</th>
						<th>신고 유형</th>
						<th>신고 해당 위치</th>
						<th>신고 해당 번호</th>
						<th>처리일</th>
						<th>처리상태 변경</th>
					</tr>
				</thead>
				<tbody id="list">
					
				</tbody>
<!-- 				<tbody id="list1" style="display: none;">

				</tbody> -->
				<tr>
					<td colspan="6" id="paging">
						<div class="container">                           
	               			<nav aria-label="Page navigation" style="text-align:center; width: 1100px;">
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

SingoNoCheckList(currPage,10);

function SingoNoCheckList(page,cnt) {
	
	// 페이지 도착하자마자 ajax 실행
	$.ajax({
		type:'POST',
		url:'SingoNoCheckList',
		data:{'page':page,'cnt':cnt}, 
		dataType:'JSON',
		success:function(data) {

			totalPage = data.pages;
			listDraw(data.list);
			console.log(data.list);
			
			if (data.list.length > 0) {
				$('#pagination').twbsPagination({
					startPage:currPage, // 현재 페이지
					totalPages:totalPage, // 만들수 있는 총 페이지 수
					visiblePages:5, // [1][2][3]... 이걸 몇개까지 보여줄 것인가? 밑에 페이지클릭숫자
					onPageClick:function(event,page) { // 해당 페이지 번호를 클릭 했을때 일어날 일들
						console.log(event); // 현재 일어나는 클릭 이벤트 관련 정보들
						console.log(page); // 몇 페이지를 클릭 했는지에 대한 정보
						SingoNoCheckList(page,10);
					}
				});
			}
			
		},
		error:function(e) {
			console.log(e);
		}
	});
}

function listDraw(list) {
    var content = '';

    list.forEach(function(item,decl_num) {
    	var date = new Date(item.dec_date);
    	var target = '';
    	
    	if (item.dec_target = 0) {
    		target = '<td>'+'게시글'+'</td>';
		}else if (item.dec_target = 1) {
			target = '<td>'+'댓글'+'</td>';
		}
    	
    	content += '<tr>';
    	content += '<td>'+item.mem_id+'</td>';
   		content += '<td>'+item.dec_id+'</td>';
   		content += '<td>'+item.decO_cont+'</td>';
   		content += target;
    	content += '<td>'+item.dec_targetNum+'번'+'</td>';
    	content += '<td>'+date.getFullYear()+"-"
	      +("0"+(date.getMonth()+1)).slice(-2)+"-"
	      +("0" + date.getDate()).slice(-2);+'</td>'
    	content += '<td>'+'<button onclick="ChangeSingeBtn('+item.decl_num+')" class="ChangeBtn">'+"처리로변경"+'</button>'+'</td>';
    	content += '</tr>';

    });
 	$('#list').empty();
    $('#list').append(content);
}

function ChangeSingeBtn(a) {
	console.log(a);
	
	window.location.href="./SingoProcess?decl_num="+a;
	
}

var msg = "${msg}";

if(msg != ""){
	alert(msg);

}	

$('#processBtn').click(function() {
	window.location.href="./SingoProcessListPage";
})

	/* 
$('#NoCheckBtn').click(function() {
	console.log('미처리상태');
	$('#list').css({'display':'block'})
	$('#list1').css({'display':'none'})
}) */
/* 
$('#CheckSuccessBtn').click(function() {
	console.log('처리상태');
	$('#list1').css({'display':'block'})
	$('#list').css({'display':'none'})
}) */

</script>
</html>