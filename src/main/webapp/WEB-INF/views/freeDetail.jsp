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
   <table>
      <tr>
         <th>글 번호</th>
         <td>${dto.community_boardnum}</td>
      </tr>
      <tr>
         <th>제목</th>
         <td>${dto.community_sub}</td>
         <td> 조회수: ${dto.community_view}</td>
         <td> 카테고리: ${dto.category_num}</td>
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
         <th>내용</th>
         <td>${dto.community_cont}</td>
      </tr>
      <tr>
      <c:if test="${photos.size()>0}">
      <tr>
         <th>사진</th>
         <td>
            <c:forEach items="${imgs}" var="photo">
               <img src="C:/STUDY/PrettyDog/PrettyDog/src/main/webapp/resources/commu/"${photo.newFileName} width="250px"/><br/><br/>
              
            </c:forEach>
         </td>
      </tr>
      </c:if>
         <th colspan="2">
            <input type="button" value="리스트" onclick="location.href='./freeList'">
            <input type="button" value="수정" onclick="location.href='./freeUpdateForm?community_boardnum=${dto.community_boardnum}'">
            <input type="button" value="삭제" onclick="location.href='./freeDelete?community_boardnum=${dto.community_boardnum}'">
         </th>
      </tr>
   </table>
</body>
<script></script>
</html>