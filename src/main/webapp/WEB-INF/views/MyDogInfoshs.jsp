<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
 
   #con_memberDe{width: 1200px;}
   #sujung_txt{
      position: relative;
      top :100px;
      right:0px;
      float:right;
      width:900px;
      
      
   }
   
   #sujung_txt p{
   display: inline;
   }
   
   
   .formSt{
      padding:5px;
      margin:5px;
      margin-bottom: 5px;
   }
   .pw{
      padding:5px;
      margin:5px;
      margin-bottom: 5px;
   }
	#headTxt{
	  font-size: 28px;
 	 font-style: bold;
	}
		
		

	</style>
</head>
<body>
<%@ include file="cywMyPageMenuBarNomal.jsp"%>	
<div id="con_memberDe">

<div id="sujung_txt">
<p id="headTxt">강아지 등록</p>
<hr>
   <div id="formCs">
   		<p>댕댕이 정보를 입력해 주세요</p>
     	 <form action="DogUp" method="POST">
     	 	<table style ="width:420px;">
     	 		<tr>
	            	<td>이름</td>
	            	<td ><input  type="text" name="dogname" class="formSt" /></td>
	            </tr>
	            <tr>
	            	<td>나이</td>
	            	<td ><input  type="text" name="dogage" class="formSt" /></td>
	            </tr>
	            <tr>
	            	<td>견종</td>
	            	<td >
	            		<input  type="radio" name="dogweight" class="formSt" checked="checked" value="소형견"/>소형견<br>
	            		<input  type="radio" name="dogweight" class="formSt" value="중형견"/>중형견<br>
	            		<input  type="radio" name="dogweight" class="formSt" value="대형견"/>대형견<br>
	            	</td>
	            </tr>
	            <tr>
	            	<td>특징</td>
	            	<td ><textarea name="dogchar" class="formSt"></textarea></td>
	            </tr>
	            <tr>
	            	<td colspan="2"><button>저장</button></td>
	            </tr>
	         </table>
	      </form>
	   </div>
	</div>

</div>
</body>
<script>


$("#btn-join").click(function() {
	
	alert('저장이 완료되었습니다.');
	$("form").submit();
});	





</script>
</html>