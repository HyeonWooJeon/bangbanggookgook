<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>

<!-- css -->
<link rel = "stylesheet" href = "/css/layout/adminLayout/sectionTemplate.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- script -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src = "/js/admin/sectionTemplate.js"></script>

<c:if test = "${ empty verifyAdmin }">
	<script>
		alert("비정상적인 접근입니다.");
		location.href = "/main";
	</script>
</c:if>


</head>
<body>
	<div class = "sectionWrapper">
	<img src="/image/logologo.png" class="logo" id="logo"> 
		<ul class="list-group">
			<!-- 활성화 표시하고 싶을 시 class에 active 추가 -->
			<li id = "noticeManageArea" class="list-group-item list-group-item-shapeFix"><span class="sp" >공지사항 관리</span></li>
			<li id = "memberManageArea" class="list-group-item list-group-item-shapeFix"><span class="sp">회원 관리</span></li>
			<li id = "communityManageArea" class="list-group-item list-group-item-shapeFix"><span class="sp">커뮤니티 관리</span></li>
			<li id = "inquiryManageArea" class="list-group-item list-group-item-shapeFix"><span class="sp">문의내역 관리</span></li>
			<li id = "dataManageArea" class = "list-group-item list-group-item-shapeFix"><span class="sp">데이터 관리</span></li>
			<li id = "logoutBtn" class = "list-group-item logout list-group-item-shapeFix"><span class="sp">로그아웃</span></li>
			<br>
			
		</ul>
	</div>
</body>
</html>