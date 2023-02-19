<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 상세보기</title>

<!-- css -->
<link rel = "stylesheet" href = "/css/admin/community/communityDetail.css">

<!-- script -->
<script src = "/js/admin/community/communityDetail.js"></script>
</head>
<body>
	<div class = "communityDetailWrapper">
		<div class = "communituUpdateArea">
			<table class = "table table-light table-striped">
				<thead>
					<tr>
						<th width = 10% id = "communityTitle" class = "titleText">제목</th>
						<td width = 25%>
							<input id = "communityTitleInputBox" class = "form-control" type = "text" name = "communityTitle" value = "${ communityContent.title }"readonly>
						</td>
						<th width = 10% id = "communityWriteDate1" class = "writeDateText1">작성일</th>
						<td width = 25% id = "communityWriteDate2" class = "writeDateText2">${ communityContent.writeDate }</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th class = "contentText">내용</th>
						<td colspan = 100>
							<div class = "communityContent">
								${ communityContent.content }
							</div>
						</td>
					</tr>
					
					<tr class = "dataRow">
						<td colspan = 100 style = "padding-top : 8px;">
							<button id = "communityList" class = "btn btn-secondary communityList" type = "button">목록</button>
							<button id = "communityDelete" class = "btn btn-secondary communityDelete" type = "button" onclick = "communityDelete(${ param.num })">삭제</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>