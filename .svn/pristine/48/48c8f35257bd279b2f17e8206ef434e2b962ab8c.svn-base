<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 관리</title>

<!-- css -->
<link rel = "stylesheet" href = "/css/admin/community/communityManage.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- JQuery Library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src = "/js/admin/community/communityManage.js"></script>

<c:if test = "${ not empty msg }">
	<script>
		alert("${ msg }");
	</script>
</c:if>

</head>
<body>
	<div class = "communityManageWrapper">
		<div class = "topArea">
			<span class = "searchArea"> 
				<select id = "options" class="form-select form-select-sm form-select-shapeFix">
					<option value="">선택</option>
					<option>작성자</option>
					<option>제목</option>
					<option>내용</option>
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
				<tr>
					<th width = 22%>작성자</th>
					<th width = 40%>제목</th>
					<th width = 38%>작성일</th>
				</tr>
			<tbody>
				<tr>
					<c:choose>
						<c:when test = "${ communitys eq '[]' }">
							<td colspan = 100>검색결과가 없습니다.</td>
						</c:when>
						
						<c:otherwise>
							<c:forEach var="cnt" begin = "0" end = "10" step = "1">
								<c:choose>
									<c:when test="${ communitys[cnt] != null }">
										<tr onclick="communityDetail(${ communitys[cnt].num })">
											<td>${ communitys[cnt].id }</td>
				
											<td id = "" class = "communityTitle">
												${ communitys[cnt].title }
											</td>
				
											<td>
												${ communitys[cnt].writeDate }
											</td>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tr>
				
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