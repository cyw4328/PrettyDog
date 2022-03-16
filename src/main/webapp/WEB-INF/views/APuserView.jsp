<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자-회원리스트(상세)</title>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
    <script src="resources/js/jquery.twbsPagination.js"></script>
	<style>

	</style>
</head>
<body>
    <h2>회원정보 상세</h2>
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
    
	<%-- <form action="appointupdate" method="post">
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
					<input type="radio" id="bbb" name="pointstate" value="0" onchange="setDisplay()"> 적립
    				<input type="radio" id="aaa" name="pointstate" value="1" onchange="setDisplay()"> 차감
				</td>
			</tr>
			<tr>
				<td colspan="2" id="divId0" style="display:none">
					<input type="text" name="CHpoint" value="${info.point_cdc}" placeholder="적립"/>
				</td>
			</tr>	
			<tr>
				<td colspan="2" id="divId1" style="display:none">
					<input type="text" name="CHpoint" value="${info.point_cdc}" placeholder="차감"/>
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
    </form> --%>
	
	


    
</body>
<script>
	/* function setDisplay(){
	    if($('input:radio[id=aaa]').is(':checked')){
	        $('#divId0').hide();
	        $('#divId1').show();
	    }else{
	        $('#divId0').show();
	        $('#divId1').hide();
	    }
	} */


</script>
</html>