<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty sessionScope.id }">
	<script>
		location.href="main";
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/member/myLog.css">
<meta charset="UTF-8">
<title>대한민국 방방곡곡</title>
</head>
<body>
	<%@ include file="../member/aside.jsp"%>
	<div class="wrap">
		<!-- 마이페이지 제목 -->
		<div class="title">
			<img src="image/my_icon_01.png"> <span>마이페이지</span>

		</div>
		<div class="subTitle">
			<span>커뮤니티 활동</span>
		</div>
		<!-- 끝 -->
		<div class="tableWrap">
		<table class="myLogTable">
		<thead>
			<tr>
				<th width=5%>번호</th>
				<th width=10%>작성자</th>
				<th width = 20%>제목</th>
				<th width = 5%>첨부</th>
				<th width = 15%>등록일</th>
			</tr>
			</thead>
			<tbody>
			<c:if test="${empty myLogList}">
			<tr><td><br></td></tr>
			<tr><th colspan="6">검색 결과가 없습니다</th></tr>
			<tr><td><br></td></tr>
		</c:if>
		<c:forEach var = "list" items="${myLogList}">
			<tr>
				<td>${list.num}</td>
				<td>${list.id}</td>
				<td><span style="cursor : pointer;" onclick="location.href='communityDetail?hit=0&num='+${list.num}">${list.title}</span></td>
				<c:choose>
					<c:when test="${list.fileName eq '파일 없음' or list.fileName eq '-' or list.fileName eq null}"><td>-</td></c:when>
					<c:otherwise><td><img style="vertical-align: middle;" width ="22" height ="22" src="mainImages/disket.png"></td></c:otherwise>
				</c:choose>
				<td>${list.writeDate}</td>	 
			</tr>
			<tr><th colspan="6"><hr></th></tr>
		</c:forEach>
				</tbody>
			</table>
			<div  class="paging">${myLogPage}</div>
		</div>
	</div>
</body>
</html>