<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->
<link rel = "stylesheet" href = "/css/admin/inquiry/inquiryDetail.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- functions -->
<script src = "/js/admin/inquiry/inquiryDetail.js"></script>

</head>
<body>
	<div class = "inquiryDetailWrapper">
		<div class = "inquiryUpdateArea">
			<%-- type, result, answer --%>
			<input type = "hidden" id = "num" value = "${ inquiryContent.num }">
			<table border = 1 class = "table table-light table-striped">
				<tr>
					<th width = 10% id = "inquiryTitle" class = "titleText">제목</th>
					<td width = 25%><input id = "inquiryTitleInputBox" class = "form-control" type = "text" name = "inquiryTitle" value = "${ inquiryContent.title }" readonly></td>
					<th width = 10% id = "inquiryWriteDate1" class = "inquiryWriteDate1">작성일</th>
					<td width = 25% id = "inquiryWriteDate2" class = "inquiryWriteDate2">${ inquiryContent.inquiryDate }</td>
				</tr>
				<tbody>
					<tr>
						<th class = "contentText">내용</th>
						<td class = "inquiryContentTd" colspan = 100>
							<textArea rows = 10 cols = 75 id = "inquiryContent" class = "form-control" name = "inquiryContent" readonly>${ inquiryContent.inquiryContent }</textArea>
						</td>
					</tr>
					<c:if test = "${ inquiryContent.result eq 'y' }">
						<tr>
							<th class = "contentText">답변</th>
							<td class = "answerTd" colspan = 100>
								<textArea rows = 10 cols = 75 id = "inquiryContent_answer" class = "form-control" name = "inquiryContent" readonly>${ inquiryContent.answer }</textArea>
							</td>
						</tr>
					</c:if>
					
					<tr>
						<td colspan = 100 style = "padding-top : 8px;">
							<button class = "btn btn-secondary" type = "button" onclick = "location.href = '/admin/inquiryManage'">목록</button>
							<c:choose>
								<c:when test = "${ inquiryContent.result ne 'y' }">
									<button id = "answer" class = "btn btn-secondary" type = "button">답변</button>
								</c:when>
								<c:otherwise>
									<button id = "update" class = "btn btn-secondary" type = "button">수정</button>
								</c:otherwise>
							</c:choose>
							<button id = "updateSave" class = "btn btn-secondary" type = "button" style = "display : none;" onclick = "answerUpdate()">저장</button>
							<button id = "inquiryDelete" class = "btn btn-secondary inquiryDelete" type = "button" onclick = "inquiryDelete(${ param.num })">삭제</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>