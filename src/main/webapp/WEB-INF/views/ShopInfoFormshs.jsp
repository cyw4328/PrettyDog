<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		table{
			border:1px solid black;
			border-collapse: collapse;
			width: 900px;
			height: 450px;
		}

	</style>
</head>
<body>
<div class="container">
<div class="formDiv">
        <form action="ShopInfo" method="post" enctype="multipart/form-data">
                <table>
                	<tr><td colspan="2"  style="font-size: 26px;">매장 정보</td>
                	<td><input type="text" name="shopid" value="<%= request.getAttribute("id") %>"/></td>
                	<td><input type="text" name="shopname" value="<%= request.getAttribute("nickname") %>"/></td>
                	</tr>
                    <tr>
                        <td>매장소개</td>
                        <td colspan="3"><textarea rows="5"  style="width:700px;" name="shopSogae"></textarea></td>
                    </tr>
                    <tr>
                   		<td>사업자번호</td>
                        <td><input type="text" name="shopSaup"/></td>
                       <td colspan="2"> '-' 포함하여 입력해 주세요</td>
                    </tr>
                    <tr>
                   		<td>미용대상</td>
                        <td>
                        	<input type="checkbox" name="smallD" value="1" checked>소형견
                        	<input type="checkbox" name="middleD" value="1" checked>중형견
                        	<input type="checkbox" name="bigD" value="1" checked>대형견
                        </td>
                    </tr>
                    <tr>
                   		<td>매장사진</td>
                        <td>
    						<input type="file" id="file" name="shopPhoto" >
                        </td>
                    </tr>
                    <tr>
                        <td> 지역</td>
                          <td>
	                          <select name="addr" >
	                         <option value="">--시/도 선택--</option>
	                         <option value="서울특별시">서울특별시</option>
	                         <option value="인천광역시">인천광역시</option>
	                         <option value="대전광역시">대전광역시</option>
	                         <option value="광주광역시">광주광역시</option>
	                         <option value="대구광역시">대구광역시</option>
	                         <option value="울산광역시">울산광역시</option>
	                         <option value="부산광역시">부산광역시</option>
	                         <option value="경기도">경기도</option>
	                         <option value="강원도">강원도</option>
	                         <option value="충청북도">충청북도</option>
	                         <option value="충청남도">충청남도</option>
	                         <option value="전라북도">전라북도</option>
	                         <option value="전라남도">전라남도</option>
	                         <option value="경상북도">경상북도</option>
	                         <option value="경상남도">경상남도</option>
	                         <option value="제주도">제주도</option>
                    	 </select>
                  	 	 </td>
                        <td>상세주소</td>
                        <td><input type="text" name="shopAddr"/></td>
                    </tr>
                    <tr>
                        <td colspan="4" style="border:0px; text-align: right;"><input type="submit" value="디음" id="btn-join"></td>
                    </tr>
            </table>
        </form>
        </div>
        
    </div>


</body>
<script>
$("#alert-success-email").hide();
$("#alert-danger-email").hide();
$("#enumber").hide();
var check = false;
var checkId = false;
//회원가입 버튼 클릭
$("#btn-join").on("click", function(e) {
   e.preventDefault();
   var id = $("input[name='id']").val();
   var pw = $("input[name='pw']").val();
   var repw = $("input[name='repw']").val();
   var name = $("input[name='name']").val();
   var phone = $("input[name='phone']").val();
   var nickname = $("input[name='nickname']").val();
   var email = $("input[name='email']").val();
   
   /*   
   //아이디,비밀번호 유효성 검사
   if (id == null || id == "") { 
      alert("아이디를 입력해주세요");
      return false;
   } 
   if (pw == null || pw == "") { 
      alert("비밀번호를 입력해주세요");
      return false;
   } 
   if (repw == null || repw == "") { 
      alert("비밀번호 확인을 입력해주세요");
      return false;
   } 
   if (name == null || name == "") { 
      alert("이름을 입력해주세요");
      return false;
   } 
   if (phone == null || phone == "") { 
      alert("전화번호를 입력해주세요");
      return false;
   } 
   if (check == false) { 
      alert("인증번호를 확인 해주세요");
      return false;
   } 
   
   if (checkId == false) { 
	      alert("중복체크 확인 해주세요");
	      return false;
	   }
   
   if (nickname == null || nickname == "") { 
      alert("닉네임을 입력해주세요");
      return false;
   } 
   
   if (!phone.match("-")) { 
	      alert("전화번호 '-' 를 확인해 주세요.");
	      return false;
	   } 
   
   */
  
   
  
   
   var param = {'id':id};
   param.pw = pw;
   param.name = name;
   param.phone = phone;
   param.email = email;
   param.nickname = nickname;
   param.pw = pw;
   
   console.log(param);
   console.log('서버전송 시작');
   $("form").submit();
   
  
   
});


  
	

</script>
</html>