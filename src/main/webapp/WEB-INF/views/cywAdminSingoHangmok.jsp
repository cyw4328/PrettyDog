<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>신고항목</title>
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
			top: 50px;
			left: 10px;
		}
		#HangmokList{
			position: absolute;
			top: 120px;
			/* left: 10px; */
		}
		input[name="SingoSub"]{
			width: 300px;
			height: 60px;
		}
		input[name="AddBtn"] {
			background-color: pink;
			height: 60px;
			width: 100px;
			text-align: center;
		}
		.table1{
			width: 40%;
		    max-width: 100%;
		    margin-bottom: 20px;
			table-layout: fixed;
		}
	</style>
</head>
<body>
	<div id="Allpage">
		<div id="AddForm">
			<form action="SingoHangmokAdd" id="SingoHangmokAdd">
				<input type="text" placeholder="추가할 항목이름을 적어주세요." name="SingoSub" id="SingoSub"/>
				<input t	ype="button" value="추가" name="AddBtn" id="AddBtn"/>
			</form>
		</div>
		<div id="HangmokList">
			<table class="table1">
				<thead>
					<tr>
						<th>항목이름</th>
						<th>항목상태</th>
						<th>상태변경</th>
					</tr>
				</thead>
				<tbody id="list">
					
				</tbody>
				<tr>
					<td colspan="3" id="paging">
						<div class="container">                           
	               			<nav aria-label="Page navigation" style="text-align:center; width: 600px;">
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

SingoHangmokList(currPage,10);


function SingoHangmokList(page,cnt) {
	
	// 페이지 도착하자마자 ajax 실행
	$.ajax({
		type:'POST',
		url:'SingoHangmokList',
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
						SingoHangmokList(page,10);
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

    list.forEach(function(item,decO_num) {

    	var blind = "";
    	if (item.decO_blind == 1) {
    		blind = '<b  style="color: red;">'+"사용안함"+'</b>';
		}else {
			blind = '<b  style="color: blue;">'+"사용중"+'</b>';;
		}
    	var ChangeBlind = "";
    	if (item.decO_blind == 1) {
    		ChangeBlind = '<a href="HangmokReUse?decO_num='+item.decO_num+'">'+"다시사용하기"+'</a>';
		}else {
			ChangeBlind = '<a href="HangmokDel?decO_num='+item.decO_num+'">'+"미사용처리"+'</a>';
		}
    	
	
    	content += '<tr>';
    	content += '<td>'+item.decO_cont+'</td>';
   		content += '<td>'+blind+'</td>';
    	content += '<td>'+ChangeBlind+'</td>';
    	content += '</tr>';

    });
    $('#list').empty();
    $('#list').append(content);
}

$('#AddBtn').click(function() {
	var $SingoSub = $('input[name="SingoSub"]')
	console.log($SingoSub.val());
	if ($SingoSub.val() == "") {
		alert("항목이름을 적어주세요");
	}else {
		var yn = confirm("등록하시겠습니까?");
		if (yn) {
			$('#SingoHangmokAdd').submit();
		}
	}
})


var msg = "${msg}";

if(msg != ""){
	alert(msg);

}	

</script>
</html>