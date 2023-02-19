<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty sessionScope.id }">
	<script>
		location.href='main';
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/member/userUpdateCheck.css">
<meta charset="UTF-8">
<title>대한민국 방방곡곡</title>

<c:if test = "${ not empty msg }">
	<script>
		alert(${msg});
	</script>
</c:if>

</head>
<body>
	<%@ include file="../member/aside.jsp"%>
	<div class="wrap">
		<form id="passwordConfirmForm" action="userUpdateCheck" method="post">
			<!-- 마이페이지 제목 -->
			<div class="title">
				<img src="image/my_icon_01.png"> <span>마이페이지</span>

			</div>
			<div class="subTitle">
				<span>내 정보수정</span>
			</div>
			<!-- 끝 -->
			<div class="content1">
			
			<div class="center">
            <label><div class="padlock">
            <svg id="lock" viewbox="0 0 64 64">
            <circle stroke-width="2" fill="none" cx="32" cy="32" r="31"/>
            <path d="M40.2,29v-4c0-4.5-3.7-8.2-8.2-8.2s-8.2,3.7-8.2,8.2v4H21v15h22V29H40.2z M27.2,25 c0-2.6,2.1-4.8,4.8-4.8s4.8,2.1,4.8,4.8v4h-9.5V25z"/>
            </svg> 
            </div></label> 
            </div>
            
				<table>
					<tr>
						<td>
							<input type=password name='pw' id='pw' placeholder='비밀번호 입력' class="inputBox" onkeyup="pwcheck()" />
						</td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td class="td">비밀번호 확인</td> -->
<!-- 						<td> -->
<!-- 							<input type=password name='confirmPw' id='confirmPw' placeholder='비밀번호 확인' class="inputBox"  onkeyup="pwcheck()" /> -->
<!-- 						</td> -->
<!-- 					</tr> -->
                     <tr><td></td></tr>
                     <tr>
						<td colspan=2 align='center'>
							<input type='button' value='확인' onclick="check() " class="submitButton" /> 
							<input type='button'value='취소' class="submitButton" onclick='location.href = "main"' />
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<script type="text/javascript">
function check(){
	var pw = document.getElementById("pw");
// 	var confirmPw = document.getElementById("confirmPw");
	var form = document.getElementById("passwordConfirmForm");
    if(pw.value=="" || pw.value==null){
        alert("비밀번호를 입력하세요");
        return;
    }
    
//     console.log("pw : " + pw.value);
//     console.log("confirmPw : " + confirmPw.value);
    form.submit();
}

</script>
	
</body>
</html>