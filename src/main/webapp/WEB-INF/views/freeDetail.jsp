<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
	

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <!-- <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> -->
    <script src="resources/js/jquery.twbsPagination.js"></script>
   
   
   
   
   <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
   
   <style>
   	table, th, td{
			border : 1px solid black;
			border-collapse: collapse;
			}
	table{
		width: 800px;
	}
   
   </style>
</head>
<body>
<section style="width: 100%; height: 84px; display: flex; background-color: rgb(66, 52, 52);">
        <%@ include file="Header.jsp"%>
    </section>




   <table>
      <tr>
         <th>글 번호</th>
         <td>${dto.community_boardnum}</td>
      </tr>
      <tr>
         <th>제목</th>
         <td>${dto.community_sub}</td>     
      </tr>
      <tr>
      	<th></th>
      	<td>카테고리: ${dto.category_name} | 조회수: ${dto.community_view}</td>
      </tr>
      <tr>
         <th>작성자</th>
         <td id ="writer">${dto.mem_id}</td>
      </tr>
      <tr>
         <th>작성일</th>
         <td>${dto.community_date}</td>
      </tr>
      <tr>
         <td colspan="2">        
         	<img width="300px" height="300px" src="resources/commu/${imgs.bphoto_newname}" onerror="this.style.display='none';"/>
         	<br/>
        	 <br/>
         	${dto.community_cont}
         </td>
         <td></td>
      </tr>
     	 <tr>
         <th colspan="2">
           	 	<a href="freeList">리스트</a>
           	 	<a href= "freeUpdateForm?community_boardnum=${dto.community_boardnum}"  onclick= "memAuthchk(event);">수정</a>
           	 	<a href = "freeDelete?community_boardnum=${dto.community_boardnum}" onclick= "memAuthchk(event);">삭제</a>
           	 	<a href="DeclaForm_Post?community_boardnum=${dto.community_boardnum}" onclick="window.open(this.href,'','width=500, height=300, scrollbars=yes'); return false;">신고</a>
         	</th>
     	</tr> 
   </table>
   
   <hr/>
   
   <!--댓글영역 ------------------------------------------------------------------------------------------------------ -->
   
   <div id="free_commentList">
   		<table>
   		<!-- commentCount -->
   			<thead>
	   			<tr>
	   				<th colspan="2">	   				   				
	   					댓글수: ${commentListCnt}	   				
	   				</th>
	   				<th></th>
	   			</tr>	   			   			
    		</thead>
    		<tbody>
    			<c:forEach items="${commentList}" var="comm">
    				<c:if test="${comm.bcomment_blind != 1}">		
    					<tr>
    						<td style="background-color:khaki; width: 80%" id="comm_writer">${comm.mem_id}</td>
							<td style="background-color:khaki;">${comm.bcomment_date}</td>	    				
    					</tr>
    					<tr>
    						<td style="height: 100px">${comm.bcomment_cont}</td>
							<td>
								<a  href="free_commentDelete?bcomment_num=${comm.bcomment_num}" onclick= "memAuthchk(event);">삭제</a>
							 	<a href="DeclaForm_Comment?bcomment_num=${comm.bcomment_num}" onclick="window.open(this.href,'','width=500, height=300, scrollbars=yes'); return false;">신고</a>
							 </td>	    				
    					</tr>
    				</c:if>	
    			</c:forEach>
   			</tbody>
   			
    </tbody>
   		</table>
   		<form action="free_commentWrite" method="post">
   			<div id="commentWriter">
   			<table>
   			<tr>
   				<td>
	   				<input type="text" name="mem_id"> 				
	   				<input type="hidden" name='community_boardnum' value='${dto.community_boardnum}'>
   				</td>
   			</tr>
   			<tr>	
   				<td>
	   				<textarea name="bcomment_cont" placeholder="댓글 내용을 입력하세요" style="width: 100%;height: 100px "></textarea>   				
   				</td>
   			</tr>
   			<tr>	
   				<td>
	   				<button>댓글 작성</button>		
   				</td>
   			</tr>
				
   			</table>

   			</div>
   		</form>
   		<button id="addBtn" onclick="moreList();"><span> 댓글 더보기</span></button>
   </div>
   
</body>
<script>
//var memberId = ${sessionScope.memberId};
var memberId = "a1";
var currId = document.getElementById('comm_writer').text();

function memAuthchk(event){
	
	console.log("권한검사 메서드 실행");		
	
	console.log(currId);
	
	if(memberId != currId){
		alert("권한이 없습니다.");
		event.preventDefault();
	}

}






</script>
</html>