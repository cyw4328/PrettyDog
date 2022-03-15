<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
 
   #con_memberDe{width: 1200px;}
   #sujung_txt{
      position: relative;
      top :100px;
      right:0px;
      float:right;
      width:900px;
      
      
   }
   
   #sujung_txt p{
   display: inline;
   }
   
   
   .formSt{
      padding:5px;
      margin:5px;
      margin-bottom: 5px;
   }
   .pw{
      padding:5px;
      margin:5px;
      margin-bottom: 5px;
   }
	#headTxt{
	  font-size: 28px;
 	 font-style: bold;
	}
		
		

	</style>
</head>
<body>
<div id="con_memberDe">

<div id="sujung_txt">
<p id="headTxt">애견정보 확인</p>

<hr>
<input type="button" value="등록하기" style="float: right;" id="MyDog_btn">
   <div id="formCs">
     	 <form action="userUp" method="POST">
     	 <table style ="width:420px;">
     	 		
	         </table>
	      </form>
	   </div>
	</div>

</div>
</body>
<script>
$("#successPw").hide();
$("#dangerPw").hide();

var checkPw = false;
var finalPw = null;

var pw =$("input[name='pw']").val();
var repw = $("input[name='repw']").val();
$("#btn-join").click(function() {
	
	alert('저장이 완료되었습니다.');
	$("form").submit();
});	


$("#MyDog_btn").click(function() {
    console.log('MyDogInfoshs 확인');     
	
  
    		location.href="./MyDogInfoshs";
    	
    	
    }
    
 });


$('.pw').keyup(function () {
    pw =$("input[name='pw']").val();
    repw = $("input[name='repw']").val();

    if (pw != "" || repw != "") {
		if (pw == repw) {
			$("#successPw").show();
			$("#dangerPw").hide();
			finalPw = repw;
			checkPw = true;
		} else {
			$("#successPw").hide();
			$("#dangerPw").show();
			checkPw = false;
		}
	}
});



</script>
</html>