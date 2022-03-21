<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>환전완료 목록</title>
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
		#ChangeOkList{
			position: absolute;
			top: 120px;
			/* left: 10px; */
		}
		.table1{
			width: 60%;
		    max-width: 100%;
		    margin-bottom: 20px;
			table-layout: fixed;
		}
	</style>
</head>
<body>
	<div id="Allpage">
		<div id="AddForm">

		</div>
		<div id="ChangeOkList">
			<table class="table1">
				<thead>
					<tr>
						<th>환급 신청 날짜</th>
						<th>환전 신청 아이디</th>
						<th>환급 신청 포인트</th>
						<th>환급 은행</th>
						<th>환급 계좌번호</th>
						<th>환급 처리 날짜</th>
						<th>환급 처리자</th>
					</tr>
				</thead>
				<tbody id="list">
					
				</tbody>
				<tr>
					<td colspan="7" id="paging">
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

ChangeOkList(currPage,10);


function ChangeOkList(page,cnt) {
	
	// 페이지 도착하자마자 ajax 실행
	$.ajax({
		type:'POST',
		url:'ChangeOkList',
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
						ChangeOkList(page,10);
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

    list.forEach(function(item,pochOk_num) {
    	var date = new Date(item.pochOk_date);
    	var date1 = new Date(item.poch_date);
    	
    	content += '<tr>';
    	content += '<td>'+date1.getFullYear()+"-"
  	      +("0"+(date1.getMonth()+1)).slice(-2)+"-"
  	      +("0" + date1.getDate()).slice(-2)+'</td>';
    	content += '<td>'+item.mem_id+'</td>';
    	content += '<td>'+item.poch_money+'</td>';
    	content += '<td>'+item.poch_bank+'</td>';
    	content += '<td>'+item.poch_banknum+'</td>';
    	content += '<td>'+date.getFullYear()+"-"
	      +("0"+(date.getMonth()+1)).slice(-2)+"-"
	      +("0" + date.getDate()).slice(-2)+'</td>';
    	content += '<td>'+item.pochOk_id+'</td>';
    	content += '</tr>';

    });
    $('#list').empty();
    $('#list').append(content);
}

var msg = "${msg}";

if(msg != ""){
	alert(msg);

}	
</script>
</html>