<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>

<!-- css -->
<link rel = "stylesheet" href = "/css/admin/notice/noticeDetail.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- script -->
<script src = "/js/admin/notice/noticeDetail.js"></script>

</head>
<body>
	<div class = "noticeDetailWrapper">
		<div class = "noticeUpdateArea">
			<input type = "hidden" id = "num" value = "${ noticeContent.num }">
			<form id = "noticeUpdateForm" method = "POST">
			<table class = "table table-light table-striped">
				<tr>
					<th width = 10% id = "noticeTitle" class = "noticeTitle">제목</th>
					<td width = 25%><input id = "noticeTitleInputBox" class = "form-control" type = "text" name = "noticeTitle" value = "${ noticeContent.title }" readonly></td>
					<th width = 10% id = "noticeWriteDate1" class = "noticeWriteDate1">작성일</th>
					<td width = 25% id = "noticeWriteDate2" class = "noticeWriteDate2">${ noticeContent.writeDate }</td>
				</tr>
				<tr>
					<th class = "fileText">파일</th>
					<c:choose>
						<c:when test = "${ empty noticeContent.fileName }">
							<td class = "fileDownload">파일 없음</td>
						</c:when>
						<c:otherwise>
							<td class = "fileDownload" onclick = "fileDownload(this)" style = "cursor : pointer;">${ noticeContent.fileName }</td>
						</c:otherwise>
					</c:choose>
				</tr>
			<tbody>
				<tr>
					<th class = "contentText">내용</th>
					<td colspan = 100>
						<textArea rows = 22 cols = 75 id = "noticeContent" class = "form-control" name = "noticeContent" readonly>${ noticeContent.content }</textArea>
					</td>
				</tr>
				
				<tr>
					<td colspan = 100 style = "padding-top : 8px;">
						<button id = "noticeList" class = "btn btn-secondary noticeList" type = "button">목록</button>
						<button id = "noticeUpdate" class = "btn btn-secondary noticeUpdate" type = "button" onclick = "noticeUpdates(${ param.num })">수정</button>
						<button id = "noticeDelete" class = "btn btn-secondary noticeDelete" type = "button" onclick = "noticeDeletes(${ param.num })">삭제</button>
						<button id = "noticeSave" class = "btn btn-secondary" style = "display : none" type = "button">저장</button>
						<button id = "cancel" class = "btn btn-secondary" style = "display : none" type = "button">취소</button>
					</td>
				</tr>
			</tbody>
		</table>
		</form>
		</div>
	</div>
</body>
</html>