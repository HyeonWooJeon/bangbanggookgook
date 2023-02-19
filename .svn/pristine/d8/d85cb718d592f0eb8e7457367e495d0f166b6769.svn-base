<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:if test="${empty sessionScope.id }">
	<script>
		location.href = "main";
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/member/userUpdate.css">
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="js/member/myPage.js"></script>
<script>
	function daumPost() {

		new daum.Postcode({
			oncomplete : function(data) {
				var addr = "";
				// R == 도로명 주소, J == 지번 주소
				if (data.userSelectedType == "R")
					addr = data.roadAddress;
				else {
					addr = data.jibunAddress;
				}
				document.getElementById('zonecode').value = data.zonecode; // 우편번호
				document.getElementById('addr1').value = addr;
				document.getElementById('addr2').focus();
			}
		}).open();

	}
</script>

<meta charset="UTF-8">
<title>대한민국 방방곡곡</title>
</head>
<body>
	<c:if test="${not empty msg }">
		<script>
			alert('${msg}')
		</script>
	</c:if>
	<%@ include file="../member/aside.jsp"%>
	<div class="wrap">
		<!-- 마이페이지 제목 -->
		<div class="title">
			<img src="image/my_icon_01.png"> <span>마이페이지</span>

		</div>
		<div class="subTitle">
			<span>내 정보수정</span>
		</div>

		<form id="form" method="post" enctype="multipart/form-data">
			<div class="down">
				<table class="info">
					<tr>
						<td width="120">프로필 이미지</td>

						<th style="text-align: center; border-spacing: 5px;"><c:set
								var="img" value="${user.profilePhoto }" /> <c:choose>
								<c:when test="${fn:startsWith(img, 'http')}">

									<img src="${user.profilePhoto}" class="profileImage">

								</c:when>

								<c:when test="${fn:startsWith(img, 'no')}">

									<img src="/image/${user.profilePhoto}" class="profileImage">

								</c:when>

								<c:otherwise>

									<img src="/image/profile/${user.id}/${user.profilePhoto}" b
										class="profileImage">

								</c:otherwise>

							</c:choose></th>

						<th style="text-align: left;"><label for="ex_file">파일선택</label>
							<input type="file" id="ex_file" name="filename"
							class="inputButton"></th>

					</tr>

					<tr>
						<td class="td">아이디</td>
						<td><input type=text name='id' value="${sessionScope.id }"
							disabled="disabled" class="inputBox" /></td>
					</tr>
					<tr>
						<td class="td">비밀번호</td>
						<td><input type="password" id="pw" name="pw" class="inputBox"
							onkeyup="pwcheck(this)"></td>
						<td class="td1">비밀번호 확인</td>
						<td><input type="password" id="confirmPw" name="confirmPw"
							onkeyup="pwcheck(this)" class="inputBox"></td>
					</tr>
					<tr>
						<td colspan="4" style="text-align: center"><span
							id="pwre_info" style="font-size: 15px;"></span></td>
					</tr>
					<tr>
						<td class="td">전화번호</td>
						<td><input type="text" name='phone' id="phone"
							value="${user.phone }" class="inputBox" maxlength="13"
							oninput="autoHyphen(this)" onclick="digitcheck(this)" /></td>
					</tr>

					<tr>
						<td align='right' height=40 class="td">E-Mail</td>
						<td><input type=text name='email' id="email"
							value="${user.email }" disabled="disabled" class="inputBox" /></td>

					</tr>
					<tr>
						<td align='right' class="td">우편번호</td>
						<td><input type=text name='zipcode' id="zonecode"
							value="${user.zipcode }" readonly="readonly" class="inputBox" />
						</td>
						<td colspan="2"><input type="button" value="우편번호 검색"
							onclick="daumPost()" class="button"></td>
					</tr>
					<tr>
						<td align='right' class="td">주소</td>
						<td colspan="3"><input type=text name='addr1' id="addr1"
							value="${user.addr1 }" readonly="readonly" style="width: 475px;"
							class="inputBox" /></td>
					</tr>
					<tr>
						<td align='right' class="td">상세주소</td>
						<td colspan="3"><input type=text name='addr2' id="addr2"
							value="${user.addr2 }" style="width: 475px;" class="inputBox" />
						</td>
					</tr>


					<tr>
						<td align='center' height=40 colspan=4><input type=button
							value='수정' class="submitButton" onclick="check()"> <input
							type=reset value='취소' class="submitButton" /></td>
					</tr>
					</tbody>
				</table>
			</div>
		</form>

	</div>
</body>


<script type="text/javascript">
	function pwcheck(obj) {

		var pw = document.getElementById("pw").value;
		var confirmPw = document.getElementById("confirmPw").value;

		var pw_info = document.getElementById("pwre_info");
		var letter = /^[a-zA-Z0-9-_!@#$%^&*]{8,16}$/;

		if (obj.value == "") {
			pw_info.innerHTML = "필수 입력 항목입니다";
			pw_info.style.color = "red";
			obj.style.outline = "0.5px solid red";
		} else if (!letter.test(obj.value)) {
			pw_info.innerHTML = "영문(대,소문자)와 숫자, _!@#$%^&*(8~16자)만 사용가능합니다.";
			pw_info.style.color = "red";
			obj.style.outline = "0.5px solid red";
		} else if (pw != confirmPw) {
			pw_info.innerHTML = "입력하신 두 비밀번호가 일치하지 않습니다.";
			pw_info.style.color = "red";
			obj.style.outline = "0.5px solid red";
		} else {
			pw_info.innerHTML = " ";
			obj.style.outline = "#999999";
		}
	}
	function digitcheck(obj){
		
		var digit_Info = document.getElementById("digit_Info");
		
		if(obj.value==""){
			
			digit_Info.innerHTML = "필수 입력 항목입니다";
			digit_Info.style.color = "red";
			obj.style.outline = "0.5px solid red";
		}
		else if(obj.value.length<13){
			digit_Info.innerHTML = "유효한 전화번호를 입력하십시오.";
			digit_Info.style.color = "red";
			obj.style.outline = "0.5px solid red";
		}
		else{
			digit_Info.innerHTML = " ";
			obj.style.outline = "#999999";
		}
		
	}
	const autoHyphen = (target) => {
		 target.value = target.value
		   .replace(/[^0-9]/g, '')
		  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
		}

</script>
</html>