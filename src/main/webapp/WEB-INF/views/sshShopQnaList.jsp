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
		<textarea cols="90" rows="5" placeholder="내용을 입력해 주세요" id="QnaTextWrite"></textarea><a href="#" onclick="QnaWrite()">등록</a>
	</div>
	<c:forEach items="${sshShopQnaList }" var="sshShopQnaList">
	<div class="textarea">
		<p style="font-weight: bold; margin-bottom: -5px;">${sshShopQnaList.mem_id }</p>
		<p>${sshShopQnaList.shop_boarddate }</p>
		<input type="hidden" value="${sshShopQnaList.shop_boardnum}" class="shopBoardNum"/>
		<textarea style="margin-top: -10px;" class="${sshShopQnaList.shop_boardnum}" cols="90" rows="3">${sshShopQnaList.shop_boardcont }</textarea>
		<c:forEach items="${sshShopQnaNnswerList }" var="sshShopQnaNnswerList">
			<c:if test="${sshShopQnaList.shop_boardnum == sshShopQnaNnswerList.shop_boardnum }">
				<p style="margin-left: 50px; font-weight: bold; margin-bottom: -5px;">${sshShopDetail[0].busin_name }</p>
				<p style="margin-left: 50px; margin-bottom: -5px;">${sshShopQnaNnswerList.scomment_date }</p>
				<textarea style="margin-left: 50px; margin-bottom: 3px;" cols="90" rows="3">${sshShopQnaNnswerList.scomment_cont }</textarea>
			</c:if>
		</c:forEach>
		<div id="qnaBoard${sshShopQnaList.shop_boardnum }"></div>
		<div id="qnaBoard2${sshShopQnaList.shop_boardnum }"></div>
	</div>
	</c:forEach>
</body>
<script>


var memId0 = loginId;
var memId1 = $("#busin_mem_id_chk").val();

console.log("큐앤에이에서 확인한 로그인 아이디 : "+memId0);
console.log("큐앤에이에서 확인한 점주 아이디 : "+memId1);
	//console.log(memId0);
//	console.log(memId1);
	var content = "";
	var textLength = 0;
	
	//var busin_num = "";

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
	/*
	$(".textarea").children(".shopBoardNum");
	console.log($(".textarea").children(".shopBoardNum"));
	console.log($(".textarea").children("input")[0]);
	console.log($(".textarea").children("input")[1]);
	console.log($(".textarea").children("input")[2]);
	*/
	var a = new Array();
	
	for(var i=0; i<$(".textarea").children("input").length; i++){
		a.push($(".textarea").children("input")[i].value);	
		//console.log(a.val());
		//console.log($(".textarea").children("input")[i].value);
	}
	
	console.log(a);
	
	if(a.length != 0){
		qnaComChk();
	}
	
    
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
				console.log("data[0] " + data[0]);
				
				//busin_num = data[0].busin_num;
				//console.log("busin_numbusin_numbusin_num : " + busin_num);
				
				
				var cnt = [];
				
				for(var i=0; i<data.length; i++){
					cnt.push(data[i].shop_boardnum);			
				}
				
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
				 
				 if(data.length==0){
					 console.log("1번 실행");
					 if(memId0 === memId1){
						 for(var i=0; i<a.length; i++){
							 content = "";
								//console.log("아"); <button onclick="location.href='beautyTrendList'">
								content = "<a href='#' id='answerDiv"+a[i]+"' onclick='answerBtn0("+a[i]+")'>답글 달기</a>";
								$("#qnaBoard"+a[i]).append(content);
						 }
					 }
				 }else{
					 console.log("2번 실행");
					 if(memId0 === memId1){
						 for(var i=0; i<a1.length; i++){
							 content = "";
								//console.log("아"); <button onclick="location.href='beautyTrendList'">
								content = "<a href='#' id='answerDiv"+a1[i]+"' onclick='answerBtn("+a1[i]+")'>답글 달기</a>";
								$("#qnaBoard"+a1[i]).append(content);
						 }					 
					 }
				 }
				
			},
			error:function(e){
				console.log(e);
			}
		})
	}
	 var bb = "";
	 var answerBtnNew = "";
	 function answerBtn(b){
		answerBtnNew = "";
		bb = b;
		$("#answerDiv"+b).text("답글 닫기");
		console.log("응답바람");

		answerBtnNew += '<textarea name="answerFinish" class="answerDivFn" cols="90" rows="3">';
		answerBtnNew += '</textarea>';
		answerBtnNew += '<button class="answerFinishBtn" onclick="answerFinishBtn()">답글 작성</button>';
		$("#qnaBoard2"+b).append(answerBtnNew);
		//$("#answerDiv"+b).removeAttr("onclick");
		$("#answerDiv"+b).attr("onclick", "answerBtn1("+b+")");
		
	 }
	 
	 function answerBtn0(b){
			answerBtnNew = "";
			bb = b;
			$("#answerDiv"+b).text("답글 닫기");
			console.log("응답바람");

			answerBtnNew += '<textarea name="answerFinish" class="answerDivFn2" cols="90" rows="3">';
			answerBtnNew += '</textarea>';
			answerBtnNew += '<button class="answerFinishBtn" onclick="answerFinishBtn2()">답글 작성</button>';
			$("#qnaBoard2"+b).append(answerBtnNew);
			//$("#answerDiv"+b).removeAttr("onclick");
			$("#answerDiv"+b).attr("onclick", "answerBtn1("+b+")");
			
		 }
	 
	 function answerBtn1(c){
		 $(".answerDivFn").hide();
		 $(".answerDivFn2").hide();
		 $(".answerFinishBtn").hide();
		 $(".answerFinishBtn2").hide();
		 $("#answerDiv"+c).text("답글 달기");
		 $("#answerDiv"+c).attr("onclick", "answerBtn("+c+")");
	 }
	 
	 
	 function answerFinishBtn() {
		console.log("answerFinishBtn 확인");
		//$(".answerDivFn").text();
		var QnaNnswerText = $('.answerDivFn').val();
		var memId = memId0;
		var busin_num = $("#busin_num").val();
		console.log(QnaNnswerText);
		console.log(memId);
		console.log(bb);
		console.log(busin_num);
		location.href='QnaNnswerInsert?QnaNnswerText='+QnaNnswerText+'&memId='+memId+'&qnaDivNum='+bb+'&busin_num='+busin_num;
		//location.href='doFindMemberId?name='+name+'&email='+email;
	}
	 
	 function answerFinishBtn2() {
			console.log("answerFinishBtn2 확인");
			//$(".answerDivFn").text();
			var QnaNnswerText = $('.answerDivFn2').val();
			var memId = memId0;
			var busin_num = $("#busin_num").val();
			console.log(QnaNnswerText);
			console.log(memId);
			console.log(bb);
			console.log(busin_num);
			location.href='QnaNnswerInsert?QnaNnswerText='+QnaNnswerText+'&memId='+memId+'&qnaDivNum='+bb+'&busin_num='+busin_num;
			//location.href='doFindMemberId?name='+name+'&email='+email;
	}
	 
	function QnaWrite() {
		console.log("QnaWrite() 확인");
		var qnaText = $("#QnaTextWrite").val();
		var busin_num = $("#busin_num").val();
		console.log(qnaText);
		console.log(memId0);
		console.log(busin_num);
		location.href='QnaWrite?qnaText='+qnaText+'&memId='+memId0+'&busin_num='+busin_num;
	}
	
</script>
</html>














































































































































