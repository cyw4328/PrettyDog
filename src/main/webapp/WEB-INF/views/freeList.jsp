<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
   	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
   	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>  
   	<script src="resources/js/jquery.twbsPagination.js"></script>
	<style>
		table, th, td{
			border : 1px solid black;
			border-collapse: collapse;
			}
			
		a {
  			text-decoration-line: none;
			}		
		a:link {
		  	color : black;
		}
		a:visited {
		  	color : black;
		}
		a:hover {
 			font-weight: bold;
		}
	</style>
</head>
<body>
	<div id="community_frame" style="margin-left: 600px">
	
	
		<h1>자유게시판</h1>
		
		<div>
			<label>카테고리 선택  </label>		
			<select> 
				<option value="">전체</option> 
					<c:forEach items="${category}" var="sel"> 
						<c:if test="${sel.category_num != 3}">
							<option value="${sel.category_num}">${sel.category_name}</option>
						</c:if>	
					</c:forEach> 
			</select>	
		</div>
		
		<br/>
		
		<input type="radio" name="sort_line" checked="checked" value="최신순"/>최신순
		<input type="radio" name="sort_line" value="좋아요순"/>좋아요순
		
		<br/><br/>
		
		<table>
	      <thead>
	         <tr>
	            <th>no</th>
		        <th>제목</th>
	            <th>카테고리</th>
	            <th>작성자</th>
		        <th>작성일</th>
		        <th>조회수</th>
		        <th>좋아요</th>
	         </tr>
	      </thead>
	      <tbody id="list">
	      	<c:if test="${list eq null||size == 0 }">
				<tr><td colspan="7">등록된 글이 없습니다.</td></tr>
			</c:if>
	      
	      </tbody>
	     
	   </table>
		
		<button onclick="location.href='freeWrite'">글작성</button>
		
	      		<div calss="continer" style="margin-right: 600px ">
	      			<nav area-label="Page navigation" style="text-align:center">
	      				<ul class="pagination" id="pagination"></ul>
	      			</nav>
	      		</div>
		
		
		
		<br/><br/>
		
		<div>
			<form action="freeSearch" method="get"> 		
		   			<select name="opt">
		   				<option value="community_sub">제목</option>
		   				<option value="community_cont">내용</option>
		   				<option value="mem_id">작성자</option>
		   			</select>
		   			<input type="text" name="keyword" placeholder="검색어를 입력하세요">
		   			<button>검색</button>
	   		</form>
		</div>
	</div><!-- community_frame.e -->
		
	

	
</body>



<script>

 
	var currPage = 1;
	var totalPage= 2;	  
	
	listCall(currPage,10);
	
	function more(){
	  currPage++;
	 console.log('currPage',currPage);	
	  if(currPage>totalPage){
		  $('button').attr('disabled',true);
	  }else{  
	    listCall(currPage, 10);
	  }
	}
	
	function listCall(page, cnt){
	  $.ajax({
	     type:'GET',
	     url:'listCall',
	     data:{'page':page,'cnt':cnt},
	     dataType:'JSON',
	     success:function(data){
	        console.log(data.list);
	        
	        totalPage = data.pages;
	        listDraw(data.list);
	        
	        $('#pagination').twbsPagination({
	        	startPage:currPage,
	        	totalPages:totalPage,
	        	visiblePages:5,
	        	onPageClick:function(evt,page){
	        		console.log(evt);
	        		console.log(page);
	        		listCall(page,10);
	        	}//onPageClick:function(evt,page).e
	        	
	        });//$('#pagination').twbsPagination.e
	        
	     },
	     error:function(e){
	        console.log(e);
	     }
	  });//ajax.e            
	}//function listCall(page, cnt).e
	
	
	function listDraw(list){ 
	  var content = '';
	
	  list.forEach(function(item,community_boardnum){
		  	if(item.category_num != 3){
			  	
		  		var coTime = item.community_date;
			    var codate = new Date(coTime);
		  		
			     content += '<tr>';
			        content += '<td>'+item.community_boardnum+'</td>';
			        content += '<td><a href="freeDetail?community_boardnum='+item.community_boardnum+'">'+item.community_sub+'</td>';
			        content += '<td>'+item.category_num+'</td>';
			       
			        content += '<td>'+item.mem_id+'</td>';
			        
			        content += '<td>'+ codate.getFullYear()+"-"
		            +("0"+( codate.getMonth()+1)).slice(-2)+"-"
		             +("0" + codate.getDate()).slice(-2)+" "
		      		 +"</td>";

			        content += '<td>'+item.community_view+'</td>';
			        content += '<td>'+item.community_likes+'</td>';
			    content += '</tr>';
			  
		  } 
		
	  });
	  $('#list').empty();
      $('#list').append(content);
	
	}

 
 
 

</script>
</html>