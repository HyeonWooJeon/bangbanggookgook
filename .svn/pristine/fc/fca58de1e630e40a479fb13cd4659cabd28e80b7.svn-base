<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대한민국 방방곡곡</title>
<link rel ="stylesheet" href="css/notice/notice.css">
</head>
<body>
<div class="notice_main">
	<form action="notice">	
		<div class="notice_sub">
			<div class="notice_title">
			<p style="color : #408080;">공지사항</p>
			</div>
		
			<div class="notice_search">
				<div class="notice_search_div">
					<div class="notice_search_info"><span class="child">총 ${totalCount}건</span><span class="count_page child">현재페이지 ${currentPage}/${totalPage}</span></div>
					<div class="notice_search_box ">
					<select class="notice_search_select child" name="select">
					<option>제목</option>
					</select>
					<c:choose>
						<c:when test="${not empty search}">
								<input type="text" class="search_bar child" value="${search}" name="search" onkeypress="if(event.keyCode == 13){ location.href='notice'; return;}">				
						</c:when>
						<c:otherwise>
					<input type="text" class="search_bar child"   name="search" onkeypress="if(event.keyCode == 13){ location.href='notice'; return;}">
						</c:otherwise>
					</c:choose> 
					<button class="search_bt" ><img src="mainImages/search_bt.png" class= "child" name="search" onclick="location.href='notice'; return;" style="cursor : pointer;"></button>
					</div><hr style="color :#408080;">
				</div>
			</div>
		
			<div class="notice_info">
			<div><img src="mainImages/notice_icon.png" class="notice_info_img">
			<div class="notice_info_span"><span>대한민국 방방곡곡의 공지사항, NEWS, 이벤트 등 여러가지 소식을 알려드립니다.</span>
			<br><span>문의사항은 고객센터의 1:1 문의를 이용해주세요</span></div></div>
			</div>
			<table class="notice_table" style="text-align : center;">
			<tr style="background-color : #408080; height : 40.5px;">
				<th width=10%>번호</th>
				<th width = 55%>제목</th>
				<th width = 10%>첨부</th>
				<th width = 10%>조회</th>
				<th width = 15%>등록일</th>
			</tr>
		<c:if test="${empty noticeList}">
			<tr><td><br></td></tr>
			<tr><th colspan="5">검색 결과가 없습니다</th></tr>
			<tr><td><br></td></tr>
		</c:if>
		<c:forEach var = "list" items="${noticeList}">
			<tr>
				<td>${list.num}</td>
				<td class="notice_title_title" style="text-align : left;"><span style="cursor : pointer;" onclick="location.href='noticeDetail?hit=1&num='+${list.num}">${list.title}</span></td>
				<c:choose>
					<c:when test="${list.fileName eq '파일없음' or list.fileName eq '-' or list.fileName eq null or list.fileName==''}"><td>-</td></c:when>
					<c:otherwise><td><img style="vertical-align: middle;" width ="22" height ="22" src="mainImages/disket.png"></td></c:otherwise>
				</c:choose>
				<td>${list.hit}</td>
				<td>${list.writeDate}</td>	 
			</tr>
			
		</c:forEach>
				
			</table>
			<div align="center" class="paging">${page}</div>
		</div>
	</form>
</div>
</body>
</html>