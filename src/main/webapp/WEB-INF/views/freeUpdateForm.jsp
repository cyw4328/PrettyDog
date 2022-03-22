<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
   	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
   	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>  
   	<script src="resources/js/jquery.twbsPagination.js"></script>
	<style>
		table{
			border : 1px solid black;
			border-collapse: collapse;
			}
		
		table{
			width: 800px;
			height: 500px;
			margin-left: 500px; 
			margin-top: 100px;
		}	
			
		
	</style>
</head>
<body>
	<h1>자유게시판 게시물 수정</h1>
	<form action="freeWrite" name="freeForm" method="POST" enctype="multipart/form-data"  onsubmit="submit_chk(event);"><!-- 여러가지~ -->
      	<table>
         <tr style="height: 5%">
            <td>
            	<input type="text" name="community_sub" id="subject" style="width: 70%" value = "${dto.community_sub}">
            	
            	<select name="category_num" id="category_selecter" > 
            	
					<option value="${sel.category_num}"  selected="selected">${dto.category_name}</option> 
					
						<c:forEach items="${category}" var="sel"> 
							<!-- 트렌드 게시판 , 블라인드된 카테고리, 관리자용 카테고리 필터링-->
							<c:if test="${sel.category_num != 3 && sel.category_blind != 1  && sel.category_admin != 1}">			
								<!-- 카테고리 번호, 블라인드된 카테고리 여부, 관리자용 카테고리 여부, 카테고리 이름 -->			
								<option value="${sel.category_num}">${sel.category_name}</option>							
							</c:if>	
						</c:forEach> 
				</select>	
            </td>
         </tr>
         <tr style="height: 5%">      
            <td><input type="text" name="mem_id"  id="writer" value="${dto.mem_id}"/></td>
         </tr>
         <tr style="height: 60%">     
            <td>
            	<textarea name="community_cont" id="content" style="width: 100%; height: 100%">${dto.community_cont}</textarea>
           	</td>
         </tr>
         
       <tr style="height: 20%">
            <td>
            	<div id="image_container" style="width: 130px; height: 130px; margin: 20px">
            	 	<%-- <img width="300px" height="300px" src="resources/commu/${imgs.bphoto_newname}"/> --%>
            	</div>
            	
            		<input type="file" name="imgs" onchange="setThumbnail(event);"/>
            		
            		
            </td>
         </tr>
         <tr style="height: 10%">
            <th colspan="2">
               <input type="button" onclick="listChk();" value="목록"/>
               <button>수정</button>
            </th>
         </tr>
      </table>
   </form>

	
</body>



<script>

function submit_chk(event){
	var sub = document.getElementById('subject').value;
	var cat = document.getElementById('category').value;
	var con = document.getElementById('content').value;
	
	if(sub == ""){
		alert("제목을 기입하세요")
		document.freeForm.community_sub.focus();
		event.preventDefault();
	} else if(cat == ""){
		alert("카테고리를 선택하세요")
		document.freeForm.category_num.focus();
		event.preventDefault();
	} else if(con == ""){
		alert("내용을 기입하세요")
		document.freeForm.community_cont.focus();
		event.preventDefault();
	} else{
		alert("게시물을 수정하였습니다.");
	}
	
	
}

	
function setThumbnail(event) { 
	var reader = new FileReader(); 

	reader.onload = function(event) { 
		var img = document.createElement("img"); 
		img.setAttribute("src", event.target.result); 
		img.setAttribute('height', '120px');
		img.setAttribute('width', '120px');
		document.querySelector("div#image_container").appendChild(img); 
	}; 
	reader.readAsDataURL(event.target.files[0]); 
	}

function listChk(){
	if(confirm("저장하지 않은 내용은 지워집니다. 이동하시겠습니까?") == true){
		location = './freeList';
	}else{
		 return;
	}
		
}
	
	
	
	
	
</script>
</html>