<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
   
   #memuBar{
   position: absolute;
     top :100px;
     right:950px;
     display:inline;
   	  width:200px;
   }

    #left{
      border: 1px solid #d5d5d5;
		text-align: center;
		line-height: 80px; 
		text-align: left;
		padding-left: 10px;
          }

      
   .tab00{
    border-left: 1px solid #d5d5d5;
    border-top: 1px solid #d5d5d5;
    border-right: 1px solid #d5d5d5;
    height: 40px;
    line-height: 40px;
	cursor: pointer;
	padding-left: 10px;
   }
    .tab00:last-child{
    border-bottom: 1px solid #d5d5d5;
    }
   
   
   .tab00 a{
   text-decoration-line : none;
   }
   
   
   .tab00:hover{
    font-weight: bold;
    color: #ff8a00;
   }

   
  
  #headTxt{
  font-size: 28px;
  font-style: bold;
 	 } 
   
   table {
	width: 500px;
	position: relative;
	right: 0px;
	top:50px;
	float: left;
	}

	table,td{
	border-bottom: 1px solid black;
	border-collapse: collapse;
	padding: 5px 10px;
	}

a{
	text-decoration : none;
	color: black;
}

   
   
   </style>

<body>

<div id="memuBar">
		<div id = "left">
			<p style="text-align: center;">${loginId} 의 마이페이지</p>
		</div>
		
		<a href="#"><div class= "tab00" id="tab1">개인정보수정</div></a>
		<a href="#"><div class= "tab00" id="tab2">포인트내역</div></a>
		<a href="#"><div class= "tab00" id="tab3">매장정보확인</div></a>
		<a href="#"><div class= "tab00" id="tab5">매장 영업시간 확인</div></a>
		<a href="#"><div class= "tab00" id="tab6">매장 예약 관리</div></a>
		<a href="#"><div class= "tab00" id="tab7">알림목록</div></a>
		<a href="#"><div class= "tab00" id="tab8">MY 게시글</div></a>
		<a href="#"><div class= "tab00" id="tab9">MY 댓글</div></a>
		

		
</div>	
				
</body>
<script></script>
</html>