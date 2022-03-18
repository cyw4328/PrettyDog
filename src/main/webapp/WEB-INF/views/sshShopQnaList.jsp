<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
    <style>
		#QnaTitle {
			font-size: 30px;
		}
    </style>
</head>
<body>
	<p><span id="QnaTitle"> QnA 작성</span>(욕설 및 악의적인 글은 법적인 처벌을 받을 수 있습니다.)</p>
	<div>
		<textarea cols="90" rows="5" placeholder="내용을 입력해 주세요"></textarea><a href="#">등록</a>
	</div>
	<c:forEach items="${sshShopQnaList }" var="sshShopQnaList">
	<div class="textarea">
		<p>${sshShopQnaList.mem_id }</p>
		<p>${sshShopQnaList.shop_boarddate }</p>
		<input type="hidden" value="${sshShopQnaList.shop_boardnum}" class="shopBoardNum"/>
		<textarea class="${sshShopQnaList.shop_boardnum}" cols="90" rows="3">${sshShopQnaList.shop_boardcont }</textarea>
		<div id="qnaBoard${sshShopQnaList.shop_boardnum }"></div>
		<div id="qnaBoard2${sshShopQnaList.shop_boardnum }"></div>
	</div>
	</c:forEach>
</body>
<script>

	var memId0 = '${memId}'; // 로그인 아이디
	var memId1 = '${sshShopDetail[0].mem_id}'; // 점주 아이디
	var content = "";
	var textLength = 0;
	/* var a = new Array();
	var b = '${sshShopQnaIdChk}'.length;
	a = '${sshShopQnaIdChk}'.slice(1,(b-1)).split(',');
	console.log(a);
	for(var i=0; i<a.length; i++){
		
	}
	
	 if(memId0 === memId1){
		textLength = $(".textarea").length;
		console.log(textLength);
		for(var i = 0; i<=textLength; i++){
			
			
			//content = "<a href='#'>답글 달기</a>";
			
		}
		$(".textarea").append(content);
	}  */
	
	
	$(".textarea").children(".shopBoardNum");
	console.log($(".textarea").children(".shopBoardNum"));
	console.log($(".textarea").children("input")[0]);
	console.log($(".textarea").children("input")[1]);
	console.log($(".textarea").children("input")[2]);	
	
	var a = new Array();
	
	for(var i=0; i<$(".textarea").children("input").length; i++){
		a.push($(".textarea").children("input")[i].value);	
		//console.log(a.val());
		//console.log($(".textarea").children("input")[i].value);
	}
	
	console.log(a);
    qnaComChk();
	 function qnaComChk(){
		$.ajax({
			type:'POST',
			url:'qnaComChk',
			data:{a:a},
			dataType:'JSON',
			success:function(data){
				console.log("data : ", data);
				console.log("data.length : " + data.length);
				console.log("a.length : " + a.length);
				console.log("a[0] : " + a[0]);
				console.log("data[0] " , data[0]);
				console.log("data[0].shop_boardnum : " , data[0].shop_boardnum);
				
			
				
				var cnt = [];
				
				for(var i=0; i<data.length; i++){
					cnt.push(data[i].shop_boardnum);			
				}
				/*
				var filterArr = a.filter(function(cnt){
					return a != cnt;				
				})
				console.log(filterArr);
				*/
				
				console.log(cnt);
				var a1 = [];
				for(var i=0; i<a.length; i++){
					a1.push(parseInt(a[i]));
				}
				
				console.log(a1);

				var b = cnt;

 
				b.forEach(function(item) { // b의 배열을 반복문을 돌리는데 b의 값들을 하나씩 뽑아서 item에 담아라

					// forEach의 맨처음 돌아갈때 item에 값은 b 배열의 0번째 값(2)가 담김
					// 그래서 a1의 배열값들중에 2가 있냐 있으면 변수 index에 담아라
					// 없으면 -1 를 담아라
				   var index = a1.indexOf(item); 

				   if (index !== -1) {

				      a1.splice(index, 1);

				    }

				});
				 console.log(a1);
				 
				 for(var i=0; i<a1.length; i++){
					 content = "";
						//console.log("아"); <button onclick="location.href='beautyTrendList'">
						content = "<a href='#' id='answerDiv"+a1[i]+"' onclick='answerBtn("+a1[i]+")'>답글 달기</a>";
						$("#qnaBoard"+a1[i]).append(content);
				 }
				
				
			},
			error:function(e){
				console.log(e);
			}
		})
	}
	 
	 var answerBtnNew = "";
	 function answerBtn(b){
		answerBtnNew = "";
		$("#answerDiv"+b).text("답글 닫기");
		console.log("응답바람");
		console.log($(this));
		answerBtnNew += '<textarea name="answerFinish" class="answerDivFn" cols="90" rows="3">';
		answerBtnNew += '</textarea>';
		answerBtnNew += '<button class="answerFinishBtn" onclick="answerFinishBtn()">답글 작성</button>';
		$("#qnaBoard2"+b).append(answerBtnNew);
		//$("#answerDiv"+b).removeAttr("onclick");
		$("#answerDiv"+b).attr("onclick", "answerBtn1("+b+")");
		
	 }
	 
	 function answerBtn1(c){
		 $(".answerDivFn").hide();
		 $(".answerFinishBtn").hide();
		 $("#answerDiv"+c).text("답글 달기");
		 $("#answerDiv"+c).attr("onclick", "answerBtn("+c+")");
	 }
	 
	 
	 function answerFinishBtn() {
		console.log("answerFinishBtn 확인");
		//$(".answerDivFn").text();
		var QnaNnswerText = $('.answerDivFn').val();
		var memId0 = console.log(memId0);
		console.log(QnaNnswerText);
		console.log(memId0);
		location.href="QnaNnswerInsert?QnaNnswerText="+QnaNnswerText;
	}
	
</script>
</html>














































































































































