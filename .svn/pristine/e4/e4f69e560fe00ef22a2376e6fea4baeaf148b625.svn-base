<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>

<!-- JQuery Library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- css -->
<link rel = "stylesheet" href = "/css/admin/member/memberManage.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- functions -->
<script src = "/js/admin/member/memberManage.js"></script>

<c:if test = "${ not empty msg }">
	<script>
		alert("${ msg }");
	</script>
</c:if>
</head>
<body>
	<div class = "memberManageWrapper">
			<div class = "member_bottom">
				<span class="searchArea"> 
					<select id = "options" class="form-select form-select-sm form-select-shapeFix">
						<option value = "">선택</option>
						<option>아이디</option>
						<option>이메일</option>
					</select>
				</span>
				
				<span class = "searchArea">
					<input type = "text" placeholder = "검색" id = "searchText" class = "form-control form-control-shapeFix">
				</span>
				
				<span class = "searchArea">
					<button id = "searchBtn" class = "btn btn-light btn-shapeFix">검색</button>
				</span>
			</div>
		
		<div class = "TableArea">
			<table class = "table table-light table-striped">
				<thead>
					<tr>
						<th width = 10%>아이디</th>
						<th>이메일</th>
						<th>전화번호</th>
						<th>성별</th>
						<th>우편번호</th>
						<th>주소1</th>
						<th>주소2</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test = "${ members eq '[]' }">
							<td colspan = 100>검색결과가 없습니다.</td>
						</c:when>
						<c:otherwise>
							<c:forEach var = "cnt" begin = "0" end = "10" step = "1">
								<c:choose>
									<c:when test = "${ members[cnt] != null && members[cnt].id != 'admin' }">
										<tr class = "memberDetail" onclick = "memberDetail('${ members[cnt].id }')">
											<td>${ members[cnt].id }</td>
											<td>${ members[cnt].email }</td>
											<td>${ members[cnt].phone }</td>
											<td>${ members[cnt].gender }</td>
											<td>${ members[cnt].zipcode }</td>
											<td>${ members[cnt].addr1 }</td>
											<td>${ members[cnt].addr2 }</td>
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
	</div>
</body>
</html>