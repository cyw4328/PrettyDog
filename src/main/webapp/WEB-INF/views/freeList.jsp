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
			<select id="category_selecter" onchange="change_selecter()"> 
				<option value="999">전체</option> 
					<c:forEach items="${category}" var="sel"> 
						<!-- 트렌드 게시판 , 블라인드된 카테고리, 관리자용 카테고리 필터링-->
						<c:if test="${sel.category_num != 3 && sel.category_blind != 1}">			
							<!-- 카테고리 번호, 블라인드된 카테고리 여부, 관리자용 카테고리 여부, 카테고리 이름 -->			
							<option value="${sel.category_num}">${sel.category_name}</option>							
						</c:if>	
					</c:forEach> 
			</select>	
		</div>
		
		<br/>
		
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
	         </tr>
	      </thead>
	      <tbody id="list">
	      	<c:if test="${list eq null||size == 0 }">
				<tr><td colspan="7">등록된 글이 없습니다.</td></tr>
			</c:if>
	      
	      </tbody>
	     
	   </table>
		
		<button onclick="location.href='freeWriteForm'">글작성</button>
		
	      		<div calss="continer" style="margin-right: 600px ">
	      			<nav area-label="Page navigation" style="text-align:center">
	      				<ul class="pagination" id="pagination"></ul>
	      			</nav>
	      		</div>
		
		
		
		<br/><br/>
		
		<div>					
		   			<select name="searchOpt">
		   				<option value="community_sub">제목</option>
		   				<option value="community_cont">내용</option>
		   				<option value="mem_id">작성자</option>
		   			</select>
		   			<input type="text" name="keyword" placeholder="검색어를 입력하세요">
		   			<button id = "searchBtn">검색</button>
		</div>
	</div><!-- community_frame.e -->
		
	

	
</body>



<script>
	var selectValue = "";
	
	 
	var currPage = 1;
	var totalPage= 2;	  
	listCall(currPage,10);
	   
	//셀렉트 값서  값받아오기
	
	$(document).ready(function(){
		var selectValue = $("#category_selecter").val();
		listCall(currPage,10,selectValue);
	}); 
	
	function change_selecter(){
		currPage = 1;
		console.log('체인지 셀렉터 메서드');
		var selectValue = $("#category_selecter").val();
		listCall(currPage,10,selectValue);
	}
	
	
	
	function more(){
	  currPage++;
	 console.log('currPage',currPage);	
	  if(currPage>totalPage){
		  $('button').attr('disabled',true);
	  }else{  
		var selectValue = $("#category_selecter").val();
	    listCall(currPage, 10, selectValue);
	  }
	}
	
	  var searchOpt ="";
	  var keyword =  "";

	document.getElementById("searchBtn").onclick = function () {
    
	  searchOpt =   document.getElementsByName("searchOpt")[0].value;
	  keyword =  document.getElementsByName("keyword")[0].value;
	  
	  console.log(searchOpt);
	  console.log(keyword);
	  listCall(currPage, 10, selectValue);
	 };
	
	 
	function listCall(page, cnt, selectValue){
		//var selectValue = $("#category_selecter").val();
		if(selectValue == '' || selectValue == "unsearchOptdifined" || selectValue == null){
			selectValue = 999;
		}
		
	  $.ajax({
	     type:'GET',
	     url:'listCall',
	     data:{'page':page, 'cnt':cnt, 'catNum':selectValue,'searchOpt':searchOpt, 'keyword':keyword},
	     dataType:'JSON',
	     success:function(data){
	        //console.log(data.list);
	        totalPage = data.pages;
	        listDraw(data.list);
	        
	        $('#pagination').twbsPagination({
	        	startPage:currPage,
	        	totalPages:totalPage,
	        	visiblePages:5,
	        	onPageClick:function(evt,page,catNum){
	        		console.log(evt);
	        		console.log(page);
	        		console.log(catNum);
	        		listCall(page,10,catNum, searchOpt, keyword);
	        	}//onPageClick:function(evt,page).e
	        	
	        });//$('#pagination').twbsPagination.e
	        
	     },// success:function(data).e
	     error:function(e){
	        console.log(e);
	     }//error:function(e).e
	  });//ajax.e            
	}//function listCall(page, cnt).e
	
	
	function listDraw(list){ 
	  var content = '';
	
	  list.forEach(function(item,community_boardnum){
		  //트렌드 게시판 , 블라인드된 카테고리, 관리자용 카테고리 필터링
		  	if(item.category_num != 3 && item.category_blind != 1){
		  		
			  	
		  		var coTime = item.community_date;
			    var codate = new Date(coTime);
		  		
			     content += '<tr>';
			        content += '<td>'+item.community_boardnum+'</td><input type="hidden" name= "com_blind" fvalue='+item.community_blind+'></td>';			        
			        content += '<td><a href="freeDetail?community_boardnum='+item.community_boardnum+'">'+item.community_sub+'</td>';
			        
			        //(카테고리 번호, 카테고리 관리자, 카테고리 블라인드) 카테고리 이름
			      	content += '<td><input type="hidden" name="cate_num" value='
			      		+item.category_num+'><input type="hidden" name="cate_admin" value='
			      		+item.category_admin+'><input type="hidden" name="cate_blind" value='
			      		+item.category_blind+'>'
			      		+item.category_name+'</td>';			      					   			      		
			
			        content += '<td>'+item.mem_id+'</td>';
			        //날짜
			        content += '<td>'+ codate.getFullYear()+"-"
		            +("0"+( codate.getMonth()+1)).slice(-2)+"-"
		             +("0" + codate.getDate()).slice(-2)+" "
		      		 +"</td>";

			        content += '<td>'+item.community_view+'</td>'
			    content += '</tr>';
			  
		  } 
		
	  });//foreach.e
	  $('#list').empty();
      $('#list').append(content);
	
	}

 
 
 

</script>
</html>