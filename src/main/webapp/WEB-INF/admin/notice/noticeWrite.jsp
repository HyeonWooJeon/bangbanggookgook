<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>

<!-- css -->
<link rel = "stylesheet" href = "/css/admin/notice/noticeWrite.css">

<!-- script -->
<script src = "/js/admin/notice/noticeWrite.js"></script>
</head>
<body>
	<div class = "noticeWriteWrapper">
		<div class = "noticeWriteArea">
			<form id = "noticeForm" action = "/admin/noticeWrite" method = "POST" enctype = "multipart/form-data">
				<table class = "table table-light table-striped table-shapeFix">
					<tr>
						<td>제목</td>
						<td><input type="text" id = "noticeTitle_write" class = "form-control" name = "title"></td>
					</tr>

					<tr>
						<td colspan="100">
							<div class="mb-3">
							  <label for="formFileMultiple" class="form-label">파일 업로드</label>
							  <input class="form-control" type="file" id="formFileMultiple" name = "uploadFile">
							</div>
						</td>
					</tr>

					<tr>
						<th>내용</th>
						<td>
							<textarea id = "noticeContent" class = "form-control" cols = 70 rows = 20 name = "content"></textarea>
						</td>
					</tr>

					<tr>
						<td colspan="2">
							<button type = "button" onclick="noticeRegist()">저장</button> 
							<input id = "noticeList" type="reset" value="취소">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>