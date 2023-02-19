<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${empty sessionScope.id }">
	<script>
		location.href="main";
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/member/myPage.css">
<meta charset="UTF-8">
<title>대한민국 방방곡곡</title>
</head>
<body>
	<%@ include file="../member/aside.jsp" %>
	<div class="wrap">
		<!-- 마이페이지 제목 -->
		<div class="title">
			<img src="image/my_icon_01.png"> <span>마이페이지</span>

		</div>
		<div class="subTitle">
			<span>내정보</span>
		</div>
		<!-- 끝 -->
		
			<table class="table1">
			<hr>
				<tbody>
					<tr>
						<th colspan="2">
						<c:set var="img" value="${user.profilePhoto }"/>
						<c:choose>
				<c:when test="${fn:startsWith(img, 'http')}">
					<img src="${user.profilePhoto}" class="profileImage">
				</c:when>
				<c:when test="${fn:startsWith(img, 'no')}">
					<img src="/image/${user.profilePhoto}" class="profileImage">
				</c:when>
				<c:otherwise>
					<img src="/image/profile/${user.id}/${user.profilePhoto}" class="profileImage">
				</c:otherwise>
			</c:choose>
						</th>
					</tr>
					<!-- <tr>
						<th colspan="2">프로필 변경</th>
					</tr> -->
					<tr>
						<th colspan="2">
						<form action="imageInsert" id="form" name="form"
			method="post" enctype="multipart/form-data" autocomplete="off">
			<label for="ex_file">파일선택</label>
			<input type="file" id="ex_file" name="filename" class="inputButton" required />
			</th>
					</tr>
					<tr>
						<th colspan="2"><button type="submit" class="btn btn-default button">업로드</button>
		</form></th>
					</tr>
					<tr>
						<th colspan="2">&nbsp;&nbsp;</th>
					</tr>
					<tr>
						<th colspan="2">${user.id }님 환영합니다!</th>
					</tr>
			</table>
		<hr>
		
	<div class="contents">
	
	
</div>
		<div class="down">
			<table class="table2">
				<tr>
					<th>아이디</th>
					<td>${user.id }</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${user.email }</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${user.phone }</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${user.zipcode } ${user.addr1 } &nbsp;&nbsp;${user.addr2 } </td>
				</tr>
				</tbody>
			</table>
		
			<hr>
	</div>
		<div class="up">
			<div class="img">
				<img src="image/subscribe.gif">
			</div>
		</div>
</div>

</body>
</html>
