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
			width: 100%;
			border-collapse: collapse;
			/* text-align: left; */
			line-height: 1.5;
			border: 1px solid #ccc;
			margin: 15px 0px;
			/* width: 600px; */
		}
		table thead {
			border-right: 1px solid #ccc;
			border-left: 1px solid #ccc;
			background: #7092b0;
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
			width: auto;
			height: 50px;
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
    <!-- ?????? ??? ?????? -->
    <section style="width: 100%; height: 54px; display: flex; background-color: white;">
        <%@ include file="APHeader.jsp"%>
    </section>


    <!-- ?????? ??????(??????, ????????? ???) -->
    <section style="width: 100%; height: 914px; display: flex;">
        
        <!-- ????????? ??? ?????? -->
        <div style="width: 13%; height: 100%; background-color: rgb(75 70 70);"> 

            <div style="width: 100%; height: 9%;;"></div>

            
            <div style="width: 100%; height: 79%;">
                <a href="apuserlist2" style="text-decoration:none;"><div class= "sidebar" >???????????? ??? ??????</div></a>
                <a href="apshoplist2" style="text-decoration:none;"><div class= "sidebar" >???????????? ??? ??????</div></a>
                <a href="appointlist2" style="text-decoration:none;"><div class= "sidebar" style="background-color: rgb(167, 167, 167); color: #020202; font-weight: bold;" >????????? ?????? ??????</div></a>
                <a href="apreservelist2" style="text-decoration:none;"><div class= "sidebar" >?????? ??????</div></a>
                <a href="SingoListPage" style="text-decoration:none;"><div class= "sidebar" >?????? ??????</div></a>
                <a href="SingoHangmokPage" style="text-decoration:none;"><div class= "sidebar" >?????? ?????? ??????</div></a>
                <a href="AdminServicePage" style="text-decoration:none;"><div class= "sidebar" >??????????????? ??????</div></a>
                <a href="categoryPage" style="text-decoration:none;"><div class= "sidebar" >???????????? ??????</div></a>
                <a href="ChangeListPage" style="text-decoration:none;"><div class= "sidebar" >?????? ?????? ??????</div></a>
            </div>

        </div>
        <!-- ?????? -->
        <div style="width: 87%; height: 100%;">
            <!-- ?????? ??? -->
            <div style="width: 100%; height: 11%;">
                <div style="width: 100%; height: 30%;"></div> 
                <div style="width: 100%; height: 55%; display: flex;">
                    <div style="width: 5%; height: 100%;"></div>
                    <div style="width: 90%; height: 100%; display: flex; border : 1px solid transparent; border-radius: 20px 20px 20px 20px;">
                        <div style="width: 50%; height: 100%;">
                            
                        </div>

                        <div style="width: 1%; height: 100%;"></div>
                        <div style="width: 10%; height: 100%;">
                            
                        </div>
                        <div style="width: 1%; height: 100%;"></div>

                        <div style="width: 10%; height: 100%;">
                            
                        </div>

                        <div style="width: 1%; height: 100%;"></div>
                        <div style="width: 10%; height: 100%;">
                            
                        </div>
                        <div style="width: 1%; height: 100%;"></div>
                        
                    </div>
                    <div style="width: 5%; height: 100%;"></div>
                </div> 
                <div style="width: 100%; height: 15%;"></div> 
            </div>

            <div style="width: 100%; height: 75%; display: flex;">
                <div style="width: 5%; height: 100%;"></div>
                <!-- ?????? -->
                <div style="width: 90%; height: 100%; background-color:rgb(255, 255, 255); border : 1px solid transparent; border-radius: 20px 20px 20px 20px;">
					<table border="1" width="700px">
				        <div id="HangmokList">
							<table class="table1">
								<thead>
									<tr>
										<th>?????????</th>
							            <th>??????</th>
							            <th>????????? ?????????/??????</th>
							            <th>??????</th>
							            <th>??????</th>
							            <th>??????</th>
									</tr>
								</thead>
								<tbody id="list">
			
								</tbody>
								<tbody>
									<td colspan="3" id="paging">
										<div class="container">                           
					               			<nav aria-label="Page navigation" style="text-align:center; width: 600px;">
					                  			<ul class="pagination" id="pagination"></ul>
					              			</nav>               
					            		</div>
									</td>
								</tbody>
							</table>
								
								
						</div>
				    </table>
                </div>
                
            </div>

            
            
            
        </div>

    </section>



    
				
</body>
<script>
var currPage = 1;
var totalPage = 2;

appointlist3(currPage,10);


function appointlist3(page,cnt) {
	
	// ????????? ?????????????????? ajax ??????
	$.ajax({
		type:'POST',
		url:'appointlist3',
		data:{'page':page,'cnt':cnt}, 
		dataType:'JSON',
		success:function(data) {

			totalPage = data.pages;
			listDraw(data.list);
			console.log(data.list);
			
			if (data.list.length > 0) {
				$('#pagination').twbsPagination({
					startPage:currPage, // ?????? ?????????
					totalPages:totalPage, // ????????? ?????? ??? ????????? ???
					visiblePages:5, // [1][2][3]... ?????? ???????????? ????????? ?????????? ?????? ?????????????????????
					onPageClick:function(event,page) { // ?????? ????????? ????????? ?????? ????????? ????????? ??????
						console.log(event); // ?????? ???????????? ?????? ????????? ?????? ?????????
						console.log(page); // ??? ???????????? ?????? ???????????? ?????? ??????
						appointlist3(page,10);
					}
				});
			}
			
		},
		error:function(e) {
			console.log(e);
		}
	});
}


function listDraw(list) {
    var content = '';

    list.forEach(function(item,mem_id) {
    	var date = new Date(item.point_date);
    	
    	if (item.point_distin == 0) {
    		mestate = '<b  style="color: blue;">'+"??????"+'</b>';
		}else if (item.point_distin == 1) {
			mestate = '<b  style="color: red;">'+"??????"+'</b>';
		}
    	
    	
    	

    	content += '<tr>';
    	content += '<td>'+item.mem_id+'</td>';
   		content += '<td>'+item.mem_name+'</td>';
   		content += '<td>'+date.getFullYear()+"-"
	      +("0"+(date.getMonth()+1)).slice(-2)+"-"
	      +("0" + date.getDate()).slice(-2)+"  /  "
	      +("0" + date.getHours()).slice(-2)+"??? "
	      +("0" + date.getMinutes()).slice(-2)+"??? "
	      +("0" + date.getSeconds()).slice(-2)+"???"+'</td>'
    	content += '<td>'+item.point_cont+'</td>';
    	content += '<td>'+item.point_cdc+'</td>';
    	content += '<td>'+mestate+'</td>';
    	content += '</tr>';

    });
    $('#list').empty();
    $('#list').append(content);
}


</script>
</html>