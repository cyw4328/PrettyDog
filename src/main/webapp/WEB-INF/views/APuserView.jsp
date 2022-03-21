<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
	
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
    <script src="resources/js/jquery.twbsPagination.js"></script>
    
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
		
		#HangmokList{
			position: absolute;
			top: 120px;
			/* left: 10px; */
		}
 
   </style>

<body id="body">
    <!-- 상단 바 고정 -->
    <section style="width: 100%; height: 54px; display: flex; background-color: white;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <nav class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
                            <ul class="navbar-nav ml-md-auto">
                                <li class="nav-item active">
                                    <button type="button" class="btn btn-outline-primary">Primary</button>
                                </li>
                                <div style="width: 10px; height: 5px;"></div>
                                <li class="nav-item active">
                                    <button type="button" class="btn btn-outline-primary">Primary</button>
                                </li>
                            </ul>
                            <div style="width: 66px; height: 30px;"></div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </section>


    <!-- 중간 영역(내용, 사이드 바) -->
    <section style="width: 100%; height: 914px; display: flex;">
        
        <!-- 사이드 바 고정 -->
        <div style="width: 13%; height: 100%; background-color: rgb(0, 0, 0);"> 

            <div style="width: 100%; height: 9%;;"></div>

            
            <div style="width: 100%; height: 79%;">
                <a href="apuserlist2" style="text-decoration:none;"><div class= "sidebar" style="background-color: rgb(167, 167, 167); color: #020202; font-weight: bold;">회원조회 및 관리</div></a>
                <a href="apshoplist2" style="text-decoration:none;"><div class= "sidebar" >매장조회 및 관리</div></a>
                <a href="appointlist2" style="text-decoration:none;"><div class= "sidebar" >포인트 내역 조회</div></a>
                <a href="apreservelist2" style="text-decoration:none;"><div class= "sidebar" >예약 조회</div></a>
                <a href="SingoListPage" style="text-decoration:none;"><div class= "sidebar" >신고 관리</div></a>
                <a href="SingoHangmokPage" style="text-decoration:none;"><div class= "sidebar" >신고 항목 관리</div></a>
                <a href="AdminServicePage" style="text-decoration:none;"><div class= "sidebar" >추가서비스 관리</div></a>
                <a href="categoryPage" style="text-decoration:none;"><div class= "sidebar" >카테고리 관리</div></a>
            </div>

        </div>
        <!-- 내용 -->
        <div style="width: 87%; height: 100%;">
            <!-- 검색 바 -->
            <div style="width: 100%; height: 5%;">
                
            </div>

            <div style="width: 100%; height: 85%; display: flex;">
                <div style="width: 5%; height: 100%;"></div>
                <!-- 내용 -->
                <div style="width: 90%; height: 100%; background-color:rgb(255, 255, 255); border : 1px solid transparent; border-radius: 20px 20px 20px 20px;">
					<form>
				        <table border="1" width="400px">
				        	<tr>
				        		<td colspan="2" align="center">회원정보</td>
				        	</tr>
				            <tr>
				                <td>아이디</td>
				                <td>${info.mem_id}</td>
				            </tr>
				            <tr>
				                <td>닉네임</td>
				                <td>${info.mem_nick}</td>
				            </tr>
				            <tr>
				                <td>이름</td>
				                <td>${info.mem_name}</td>
				            </tr>
				            <tr>
				                <td>회원상태</td>
				                <td>${info.mem_state}</td>
				            </tr>
				            <tr>
				                <td>가입일</td>
				                <td>
				                	${info.mem_date}
				                </td>
				            </tr>
				            <tr>
				                <td>회원등급</td>
				                <td>${info.mem_rank}</td>
				            </tr>
				            <tr>
				                <td>이메일</td>
				                <td>${info.mem_email}</td>
				            </tr>
				            <tr>
				                <td>전화번호</td>
				                <td>${info.mem_tel}</td>
				            </tr> 
				        </table>
				    </form>
				    
					<form action="apuserupdate" method="post">
						<table border="1" width="400px">
				        	
				        	<input style="display: none" type="text" name="id" value="${info.mem_id}" readonly/>
				        	
				        	<tr>
				        		<td colspan="2" align="center">회원상태</td>
				        	</tr>
				        	
				        	
				            <tr>
								<td colspan="2" align="center">
									<input type="radio" name="state" value="0" 
									<c:if test="${info.mem_state eq '0'}"> checked</c:if>
									/> 일반
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="state" value="1" 
									<c:if test="${info.mem_state eq '1'}"> checked</c:if>
									/> 제재
									<input style="display: none;" type="radio" name="state" value="2" 
									<c:if test="${info.mem_state eq '2'}"> checked</c:if>
									/>
									<input style="display: none;" type="radio" name="state" value="3" 
									<c:if test="${info.mem_state eq '3'}"> checked</c:if>
									/>
								</td>
							</tr>
				        </table>
				        &nbsp;&nbsp;&nbsp;&nbsp;
				        <table border="1" width="400px">
				        	<tr>
				        		<td colspan="2" align="center">회원등급</td>
				        	</tr>
				            <tr>
								<td colspan="2" align="center">
									<input type="radio" name="rank" value="0" 
									<c:if test="${info.mem_rank eq '0'}"> checked</c:if>
									/> 일반회원
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input style="display: none;" type="radio" name="rank" value="1" 
									<c:if test="${info.mem_rank eq '1'}"> checked</c:if>
									/>
									<input style="display: none;" type="radio" name="rank" value="2" 
									<c:if test="${info.mem_rank eq '2'}"> checked</c:if>
									/>
									<input type="radio" name="rank" value="3" 
									<c:if test="${info.mem_rank eq '3'}"> checked</c:if>
									/> 일반관리자
								</td>
							</tr>
				        </table>
				        &nbsp;&nbsp;&nbsp;&nbsp;
				        <table>
				            <tr>
				                <td colspan="2" align="center">
				                    <input type="submit" value="수정" >
				                </td>
				            </tr>
				        </table>
				    </form>
				
				    <form action="appointupdate" method="post">
				        <table border="1" width="400px">
				        	<input style="display: none" type="text" name="id" value="${info.mem_id}" readonly/>
				        	<tr>
				        		<td colspan="2" align="center">포인트 수정</td>
				        	</tr>
				        	<tr>
				        		<td>보유 포인트</td>
				        		<td name="point">${info.mem_point}</td>
				        	</tr>
				        	<tr>
				        		<td>처리 내용</td>
				        		<td>관리자 임의 수정</td>
				        	</tr>
				        	<tr>
								<td colspan="2" align="center">
									<input type="radio" id="bbb" name="pointstate" value="0" onchange="setDisplay()" checked="checked"> 적립
				    				<input type="radio" id="aaa" name="pointstate" value="1" onchange="setDisplay()"> 차감
								</td>
							</tr>
							<tr>
								<td colspan="2" id="divId0">
									<input type="text" name="CHpoint" value="${info.point_cdc}" placeholder="ex) 100(적립), -100(차감)"/>
									
								</td>
							</tr>	
				        </table>
				         &nbsp;&nbsp;&nbsp;&nbsp;
				        <table>
				            <tr>
				                <td colspan="2" align="center">
				                    <input type="submit" value="수정" >
				                </td>
				            </tr>
				        </table>
				    </form>
					
					
                </div>
                
            </div>

            
            
            
        </div>

    </section>



    
				
</body>
<script>

</script>
</html>