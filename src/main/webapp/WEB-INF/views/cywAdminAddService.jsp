<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>추가서비스 등록/삭제</title>
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
			top: 70px;
			left: 12px;
		}
		#HangmokList{
			position: absolute;
			top: 120px;
			/* left: 10px; */
		}
		.table1{
			width: 40%;
		    max-width: 100%;
		    margin-bottom: 20px;
			table-layout: fixed;
		}
		select{
			height: 50px;
	    	width: 150px;
		}
		input[name="ServiceSub"]{
			height: 50px;
			width: 250px;
		}
		input[name="AddBtn"]{
			height: 47px;
		    width: 100px;
		    font-size: 15px;
		    border: 0;
		    background-color: pink
		}
	</style>
</head>
<body>
	<div id="Allpage">
		<div id="AddForm">
			<form action="ServiceHangmokAdd" id="ServiceHangmokAdd">
				<select name="ServiceDog">
					<option selected="selected" value="">견종선택</option>
					<option value="1">소형견</option>
					<option value="2">중형견</option>
					<option value="3">대형견</option>
				</select>
				<input type="text" placeholder="추가할 항목이름을 적어주세요." name="ServiceSub" id="ServiceSub"/>
				<input type="button" value="추가" name="AddBtn" id="AddBtn"/>
			</form>
		</div>
		<div id="HangmokList">
			<table class="table1">
				<thead>
					<tr>
						<th>서비스명</th>
						<th>견종</th>
						<th>상태</th>
						<th>상태변경</th>
					</tr>
				</thead>
				<tbody id="list">
					
				</tbody>
				<tr>
					<td colspan="4" id="paging">
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

ServiceHangmokList(currPage,10);


function ServiceHangmokList(page,cnt) {
	
	// 페이지 도착하자마자 ajax 실행
	$.ajax({
		type:'POST',
		url:'ServiceHangmokList',
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
						ServiceHangmokList(page,10);
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

    list.forEach(function(item,add_num) {

    	var dog = "";
    	var blind = "";
    	var change = "";
    	
    	if (item.add_dog == 1) {
			dog = "소형견";
		}else if (item.add_dog == 2) {
			dog = "중형견";
		}else if (item.add_dog == 3) {
			dog = "대형견";
		}
    	
    	if (item.add_blind == 1) {
			blind = '<b style="color:red">'+"미사용"+'</b>';
			change = '<a href="UseServiceChange?add_num='+item.add_num+'">'+"사용으로변경"+'</a>';
		}else if (item.add_blind == 0) {
			blind = '<b style="color:blue">'+"사용중"+'</b>';
			change = '<a href="NoUseServiceChange?add_num='+item.add_num+'">'+"사용하지않기"+'</a>';
		}
	
    	content += '<tr>';
    	content += '<td>'+item.add_sub+'</td>';
    	content += '<td>'+dog+'</td>';
    	content += '<td>'+blind+'</td>';
    	content += '<td>'+change+'</td>';
    	content += '</tr>';

    });
    $('#list').empty();
    $('#list').append(content);
}

var msg = "${msg}";

if(msg != ""){
	alert(msg);

}	

$('#AddBtn').click(function() {
	var $ServiceDog = $("select[name=ServiceDog]").val();
	var $ServiceSub = $('input[name=ServiceSub]').val();
	
	console.log($ServiceSub);
	if ($ServiceDog == "") {
		alert("해당하는 견종을 선택해주세요.");
	}else if($ServiceSub==""){
		alert("추가할 항목이름을 입력해주세요.");
	}else {
		$('#ServiceHangmokAdd').submit();
	}
	
})


</script>
</html>