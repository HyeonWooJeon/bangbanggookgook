<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의내역 관리</title>

<!-- css -->
<link rel = "stylesheet" href = "/css/admin/inquiry/inquiryManage.css">

<!-- JQuery Library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src = "/js/admin/inquiry/inquiryManage.js"></script>

<!-- functions -->
<!-- <script src = "/js/admin/inquiry/inquiryManage.js"></script> -->


</head>
<body>
	<div class = "inquiryManageWrapper">
		<div class = "topArea">
			<span class="searchArea"> 
				<select id = "options" class="form-select form-select-sm form-select-shapeFix">
					<option value="">선택</option>
					<option>제목</option>
					<option>내용</option>
					<option>답변미완료</option>
				</select>
			</span>
			
			<span class = "searchArea">
				<input type = "text" placeholder="검색" id = "searchText" class = "form-control form-control-shapeFix">
			</span>
			
			<span class = "searchArea">
				<button id = "searchBtn" class = "btn btn-light btn-shapeFix">검색</button>
			</span>
		</div>
		
		<table class = "table table-light table-striped table-shapeFix">
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>문의형태</th>
					<th width=40%>제목</th>
					<th>문의일자</th>
					<th>답변상태</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test = "${ inquiries eq '[]' }">
						<td colspan = 100>검색결과가 없습니다.</td>
					</c:when>
					<c:otherwise>
						<c:forEach var="cnt" begin="0" end="10" step="1">
							<c:choose>
								<c:when test="${ inquiries[cnt] != null }">
									<tr onclick="inquiryDetail(${ inquiries[cnt].num })">
										<td>${ inquiries[cnt].num }</td>
										<td>${ inquiries[cnt].id }</td>
										<td>${ inquiries[cnt].type }</td>
										<td id = "inquiryTitle" class = "inquiryTitle">
											${ inquiries[cnt].title }
										</td>
										
										<td>
											${ inquiries[cnt].inquiryDate }
										</td>
										
										<c:choose>
											<c:when test = "${ inquiries[cnt].result eq 'y' }">
												<td>답변완료</td>
											</c:when>
											<c:otherwise>
												<td>-</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:when>
							</c:choose>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<tr>
					<td colspan = 10>
						<div class = "paginationArea">
							<ul class = "pagination">
								<li class = "page-item" onclick = "prev('${ param.index }', ${ currentPage })"><label class = "page-link">prev</label></li>
									<c:forEach var="index" begin="${ currentPage * 4 + 1 }" end="${ (currentPage + 1) * 4 }" step="1">
										<c:choose>
											<c:when test="${ index le index_MAX }">
												<li class = "page-item"><label class = "page-link" onclick="tableDisplayByIndex('${ index }', '${ param.options }', '${ param.searchText }', '${ currentPage }')">${ index }</label></li>
											</c:when>
										</c:choose>
									</c:forEach> 
								<li class = "page-item page-item-shapeFix"><label id = "next" class = "page-link page-link-shapeFix" onclick = "next(${ currentPage }, ${ maxPage }, '${ param.index }')">next</label></li>
							</ul>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>