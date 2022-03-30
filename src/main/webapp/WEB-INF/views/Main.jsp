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
    <!-- <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> -->
    <script src="resources/js/jquery.twbsPagination.js"></script>
	
    <style>

    </style>

<body id="body">
    <!-- (헤더)상단 바 고정 -->
    <section style="width: 100%; height: 84px; display: flex; background-color: rgb(66, 52, 52);">
        <%@ include file="Header.jsp"%>
    </section>


    <!-- 중간 영역(내용) -->
    <section style="width: 100%; height: auto; background-color: rgb(255, 255, 255);">
        <!-- 사진 3장-->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12" style="padding-right: 0px; padding-left: 0px;">
                    <div class="carousel slide" id="carousel-852840" data-ride="carousel" data-interval="100000">
                        <ol class="carousel-indicators"> 
                            <li data-slide-to="0" data-target="#carousel-852840" class="active">
                            </li>
                            <li data-slide-to="1" data-target="#carousel-852840">
                            </li>
                            <li data-slide-to="2" data-target="#carousel-852840">
                            </li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="d-block w-100" alt="Carousel Bootstrap First" src="/photo/새 프로젝트.jpg" />
                                <div style="display: flex; justify-content: center; align-items: center;" class="carousel-caption">
                                	<div  style="background-color: #ffffff59; padding: 20px;">
		                                <a href="./ShopList" style="color: black;">
		                                    <h4>
		                                        미용예약
		                                    </h4>
		                                    <p>
		                                        PrettyDog를 통해 늘 가장 가까운 거리에 있는 애견미용사와 애견미용샵을 만나보세요!
		                                    </p>
		                                </a>  
	                                </div> 
                                </div>
                            </div>
                            <div style="background-color: black;" class="carousel-item">
                                <img class="d-block w-100" alt="Carousel Bootstrap Second" src="/photo/새 프로젝트2.jpg" />
                                <div style="display: flex; justify-content: center; align-items: center;" class="carousel-caption">
                                	<div  style="background-color: #ffffff59; padding: 20px;">
	                                    <a href="./freeList" style="color: black;">
	                                        <h4>
	                                            자유게시판
	                                        </h4>
	                                        <p>
	                                            PrettyDog를 통해 애견, 애견미용 등의 애견 관련 사항을 공유하고 소통해 보세요!
	                                        </p>
	                                    </a>
                                	</div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" alt="Carousel Bootstrap Third" src="/photo/새 프로젝트3-1.jpg" />
                                <div style="display: flex; justify-content: center; align-items: center;" class="carousel-caption">
	                                <div  style="background-color: #ffffff59; padding: 20px;">
		                                <a href="./beautyTrendList" style="color: black;">
		                                    <h4>
		                                        트렌드
		                                    </h4>
		                                    <p>
		                                        PrettyDog를 통해 요즘 트렌드의 애견미용을 만나보세요!
		                                    </p>
		                                </a>   
	                                </div> 
                                </div>
                            </div>
                        </div> <a class="carousel-control-prev" href="#carousel-852840" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-852840" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
                    </div>
                </div>
            </div>
        </div>
        <div style="width: 100%; height: 50px; background-color: aliceblue;">  </div>

        <!-- 교차 이미지 텍스트-->
        <div class="container" style="">
            <div class="row" style="height: 200px;">
                <div class="col-md-3" style="height: 200px;">
                    <img style=" height: 100%;" alt="Bootstrap Image Preview" src="/photo/핑크 독.png" class="rounded-circle" />
                </div>
                <div class="col-md-9" style="height: 200px;">
                    <h2>
                       		예약하기
                    </h2>
                    <p>
                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
                    </p>
                    <p>
                        <!-- <a class="btn" href="#">View details »</a> -->
                    </p>
                </div>
            </div>
            <div style="width: 100%; height: 10px;"></div>
            <div style="width: 100%; height: 2px; background-color: rgb(200, 200, 200);"></div>
        </div>
        <div style="width: 100%; height: 50px; background-color: aliceblue;">  </div>
        <div class="container">
            <div class="row" style="height: 200px;">
                <div class="col-md-9" style="height: 200px;">
                    <h2>
                        	트렌드
                    </h2>
                    <p>
                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
                    </p>
                    <p>
                        <!-- <a class="btn" href="#">View details »</a> -->
                    </p>
                </div>
                <div class="col-md-3" style="height: 200px;">
                    <img style=" height: 100%;" alt="Bootstrap Image Preview" src="/photo/스카이 독.png" class="rounded-circle" />
                </div>
            </div>
            <div style="width: 100%; height: 10px;"></div>
            <div style="width: 100%; height: 2px; background-color: rgb(200, 200, 200);"></div>
        </div>
        <div style="width: 100%; height: 50px; background-color: aliceblue;">  </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5" style="border: solid; border-width: 1px; border-color: rgb(200, 200, 200); display: flex; justify-content: center; align-items: center; background-color: lightgray;">
                    
                    <div style="width: 100%; height: auto; text-align: center; font-size: 20px;">
                        <a>요즘 미용 보러가기</a>
                        <div style="height: 20px;"></div>
                        <div>
                            <a href="./beautyTrendList" type="button" class="btn btn-outline-info" >
                                	GO ▷
                            </a>
                        </div>
                    </div>
                    

                    
                </div>
                <div class="col-md-7">
                    <div class="carousel slide" id="carousel-271964"  data-ride="carousel" data-interval="2000">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="d-block w-100" alt="Carousel Bootstrap First" src="/photo/dog grooming2.jpg" />
                                <div class="carousel-caption">
                                    
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" alt="Carousel Bootstrap Third" src="/photo/dog grooming1.jpg" />
                                <div class="carousel-caption">
                                    
                                </div>
                            </div>
                        </div> <a class="carousel-control-prev" href="#carousel-271964" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-271964" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
                    </div>
                </div>
            </div>
            <div style="width: 100%; height: 10px;"></div>
            <div style="width: 100%; height: 2px; background-color: rgb(200, 200, 200);"></div>
        </div>
        <div style="width: 100%; height: 50px; background-color: aliceblue;">  </div>



    </section>


    <!-- 푸터 -->
    <section style="width: 100%; height: auto; display: flex;">
        
       

    </section>
    
				
</body>
<script>
var loginSuccessAlert = "${loginSuccessAlert}" ;
if (loginSuccessAlert != "") {
   alert("${loginSuccessAlert}");
}
</script>
</html>