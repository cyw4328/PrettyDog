<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>이쁘개 아이디찾기</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		#AllPage{
			position: relative;
			top: 200px;
			left: 650px;
		}
	
		#idSearchSub{
			font-size: 30px;
			position: absolute;
			left: 65px;
		}
		#idSearchInput{
			position: absolute;
			top: 120px;
			left: 60px;
		}
		input[type="button"]{
			border-radius: 7px / 7px;
			background-color: black;
			color: white;
			width: 250px;
			height: 40px;
		}
		input[name="nameInput"],input[name="emailInput"]{
			width: 250px;
			height: 40px;
		}
		#result{
			position: absolute;
			top: 150px;
			text-align: center;
			left: 60px;
		}
	</style>
</head>
<body>
	<div id="AllPage">
		<div id="idSearchSub">
			<h2>아이디 찾기</h2>
		</div>
		<div id="idSearchInput">
			<table>
				<thead>
					<tr>
						<td><input type="text" placeholder="NAME" name="nameInput"/></td>
					</tr>
					<tr>
						<td><input type="email" placeholder="E-MAIL" name="emailInput"/></td>
					</tr>
					<tr>
						<td><input type="button" value="확인" id="IdSearchBtn"/></td>
					</tr>
				</thead>
				<tbody id="result">
					
				</tbody>
			</table>
		</div>
	</div>
</body>
<script>

 $('#IdSearchBtn').click(function() {
	
	 var $name = $('input[name="nameInput"]').val();
	 var $email = $('input[name="emailInput"]').val();
	 
	 $.ajax({
			type:'post',
			url:'idSearch',
			data:{"name":$name,"email":$email},
			dataType:'json',
			success:function(data) {
				console.log(data);
				drawList(data.list);
			},
			error:function(e) {
				console.log(e);
			}
		});
	
})

function drawList(list) {
	
	var content = '';
	
	content = '<tr>'+'<td>'+'<b>'+"검색 결과입니다."+'<b>'+'</td>'+'<tr>'
	list.forEach(function(item,mem_id) {
		content += '<tr>';
		content += '<td>'+item.mem_id+'</td>';
		content += '</tr>';
	
	})
	
	$('tbody').empty();
	$('tbody').append(content);
 }

</script>
</html>