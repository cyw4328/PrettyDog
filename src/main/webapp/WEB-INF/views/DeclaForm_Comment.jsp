<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
   <style>
   
	   	table, th, td{
			border : 1px solid black;
			border-collapse: collapse;
			}
   </style>
</head>
<body>
	<h1>댓글  신고</h1>
   <form action="DeclaSend_comment" method="POST">
      <table>
         <tr>
            <th>댓글 작성자</th>
            <td>
            <input type="hidden" name="dec_targetNum" value = "${dto.community_boardnum}">
            
            <input type="text" name="dec_id" value="${dto.mem_id}" readonly="readonly">
           </td>
         </tr>
         <tr>
            <th>댓글 내용</th><!-- 게시글, 댓글 어떻게 구분해야 할까 --> <!-- 댓글번호가  0이면? 글번호 출력  -->
            <td>${dto.bcomment_cont}</td>
         </tr>
         <tr>
            <th>유형</th>
            <td>
            	<select name="decO_num" id="decOP_selecter"> 
						<c:forEach items="${list}" var="declaOP"> 																				
							<option value="${declaOP.decO_num}">${declaOP.decO_cont}</option>												
						</c:forEach> 
				</select>	
            </td>
         </tr>
         <tr>
            <th colspan="2">
            	신고자 아이디 <input type="text" name="mem_id">
            	<br/>
            	<br/>
               <button onclick="self.close(); alert('신고가 접수 되었습니다.')">제출</button>
            </th>
         </tr>
      </table>
   </form>
</body>
<script>
//var memberId = ${sessionScope.memberId};
var memberId = "";
declaAuth_chk();

function declaAuth_chk(){
	if (memberId==""){
		alert("로그인 후 이용 가능합니다.");
		window.close();
	}
}


</script>
</html>