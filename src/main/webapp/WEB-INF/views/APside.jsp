<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
    <script src="resources/js/jquery.twbsPagination.js"></script>
	
    <style>
        #body{
            width: 100%;
            height: auto;
            background-color: rgb(167, 167, 167);
        } 
      
        .sidebar{
            border-top: 1px solid #d5d5d5;
            height: 70px;
            line-height: 70px;
            cursor: pointer;       
        }

        .sidebar:last-child{
            border-bottom: 1px solid #d5d5d5;
        }
        
        a .sidebar{
            text-align: center;
            color: white;
        }
        
        .sidebar:hover{
            font-weight: bold;
            color: #020202;
            background-color: rgb(167, 167, 167);
        }


 
   </style>

<body id="body">
    <!-- 상단 바 고정 -->
    <section style="width: 100%; height: 70px; display: flex; background-color: rgb(255, 255, 255);">
        <div style="width: 13%; height: 100%; background-color: rgb(0, 0, 0);"></div>
        <div style="width: 87%; height: 100%; background-color: rgb(255, 255, 255);"></div>
    </section>


    <!-- 중간 영역(내용, 사이드 바) -->
    <section style="width: 100%; height: 898px; display: flex;">
        
        <!-- 사이드 바 고정 -->
        <div style="width: 13%; height: 100%; background-color: rgb(0, 0, 0);"> 

            <div style="width: 100%; height: 9%;;"></div>

            
            <div style="width: 100%; height: 79%;">
                <a href="#" style="text-decoration:none;"><div class= "sidebar" >회원조회 및 관리</div></a>
                <a href="#" style="text-decoration:none;"><div class= "sidebar" >매장조회 및 관리</div></a>
                <a href="#" style="text-decoration:none;"><div class= "sidebar" >포인트 내역 조회</div></a>
                <a href="#" style="text-decoration:none;"><div class= "sidebar" >예약 조회</div></a>
                <a href="#" style="text-decoration:none;"><div class= "sidebar" >신고 관리</div></a>
                <a href="#" style="text-decoration:none;"><div class= "sidebar" >신고 항목 관리</div></a>
                <a href="#" style="text-decoration:none;"><div class= "sidebar" >추가서비스 관리</div></a>
                <a href="#" style="text-decoration:none;"><div class= "sidebar" >카테고리 관리</div></a>
            </div>

        </div>
        <!-- 내용 -->
        <div style="width: 87%; height: 100%;">
            <div style="width: 100%; height: 11%;"></div>

            <div style="width: 100%; height: 75%; display: flex;">
                <div style="width: 5%; height: 100%;"></div>
                <!-- 내용 -->
                <div style="width: 90%; height: 100%; background-color:rgb(255, 255, 255); border : 1px solid transparent; border-radius: 20px 20px 20px 20px;">

                </div>
                <div style="width: 5%; height: 100%;"></div>
            </div>

            <div style="width: 100%; height: 14%;"></div>
            
            
        </div>

    </section>



    
				
</body>
<script></script>
</html>