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
	table{
		width: 800px;
	}
   
   </style>
</head>
<body>
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
         <td>${dto.mem_id}</td>
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
           	 	<a href= "freeUpdateForm?community_boardnum=${dto.community_boardnum}" >수정</a>
           	 	<a href = "freeDelete?community_boardnum=${dto.community_boardnum}" onclick="return confirm('해당 게시글을 삭제하시겠습니까?');">삭제</a>
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
	   					 <%-- ${commentCount.bcomment_cnt}	  --%>  				
	   				</th>
	   				<th></th>
	   			</tr>	   			   			
    		</thead>
    		<tbody>
    			<c:forEach items="${commentList}" var="comm">
    				<c:if test="${comm.bcomment_blind != 1}">		
    					<tr>
    						<td style="background-color:khaki; width: 80%">${comm.mem_id}</td>
							<td style="background-color:khaki;">${comm.bcomment_date}</td>	    				
    					</tr>
    					<tr>
    						<td style="height: 100px">${comm.bcomment_cont}</td>
							<td>
								<a  href="free_commentDelete?bcomment_num=${comm.bcomment_num}" onclick="return confirm('해당 댓글을 삭제하시겠습니까?');">삭제</a>
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


</script>
</html>