<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보</title>

<!-- JQuery Library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- css -->
<link rel = "stylesheet" href = "/css/admin/member/memberDetail.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- script -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src = "/js/admin/member/memberDetail.js"></script>
</head>
<body>
	<div id = "memberDetailWrapper" class = "memberDetailWrapper">
		<%-- 아이디, 이메일, 전화번호, 성별, 우편번호, 주소1, 주소2, 비밀번호 변경(임시 비밀번호 전송) --%>
		<form id = "memberUpdateForm" method = "POST">
			<table id = "memberDetailTable" class = "table table-light table-striped">
				<tr>
					<th>아이디<br>(* 수정불가)</th>
					<td>
						<input type = "text" id = "id" class = "form-control form-control-shapeFix" name = "id" value = "${ member.id }" readonly>
					</td>
				</tr>
				
				<tr>
					<th>이메일<br>(* 수정불가)</th>
					<td>
						<input type = "email" id = "email" class = "form-control form-control-shapeFix" value = "${ member.email }" readonly>
					</td>
				</tr>
				
				<tr>
					<th>전화번호</th>
					<td>
						<input type = "text" id = "phone" class = "form-control form-control-shapeFix" name = "phone" value = "${ member.phone }" readonly>
					</td>
				</tr>
				
				<tr>
					<th>성별</th>
					<td>
						<input type = "text" id = "gender" class = "form-control form-control-shapeFix" name = "gender" value = "${ member.gender }" readonly>
					</td>
				</tr>
				
				<tr>
					<th>우편번호</th>
					<td>
						<input type = "text" id = "zipcode" class = "form-control form-control-shapeFix postCode-shapeFix" name = "zipcode" value = "${ member.zipcode }" readonly size = 10>
						<button id = "zipcodeBtn" class = "btn btn-secondary postCodeOpenBtn" type = "button" onclick = "postCodeOpen()" style = "display : none;">주소 검색</button>
					</td>
				</tr>
				
				<tr>
					<th>주소</th>
					<td>
						<input type = "text" id = "addr1" class = "form-control form-control-shapeFix" name = "addr1" value = "${ member.addr1 }" readonly>
					</td>
				</tr>
				
				<tr>
					<th>상세주소</th>
					<td>
						<input type = "text" id = "addr2" class = "form-control form-control-shapeFix" name = "addr2" value = "${ member.addr2 }" readonly>
					</td>
				</tr>
				
				<tr>
					<td colspan = "2">
						<button id = "updateBtn" class = "btn btn-secondary" type = "button">수정</button>
						<button id = "memberListBtn" class = "btn btn-secondary" type = "button">목록</button>
						<button id = "saveBtn" class = "btn btn-secondary unvisible" type = "button">저장</button>
						<button id = "cancelBtn" class = "btn btn-secondary unvisible" type = "button">취소</button>
						<button id = "passwordUpdateBtn" class = "btn btn-secondary unvisible" type = "button">비밀번호 변경</button>
						<label id = "informLabel" class = "informLabel unvisible">*비밀번호 변경시 임시 비밀번호가 이메일로 전송됩니다.</label>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>