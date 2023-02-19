<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대한민국 방방곡곡</title>
<link rel ="stylesheet" href="css/community/community.css">

</head>
<body>
<div class="community_main">
	<form action="community">	
		<div class="community_sub">
			<div class="community_title">
			<p style="color : #13294B;">커뮤니티</p>
			</div>
		
			<div class="community_search">
				<div class="community_search_div">
					<div class="community_search_info"><span class="child">총 ${totalCount}건</span><span class="count_page child">현재페이지 ${currentPage}/${totalPage}</span></div>
					<div class="community_search_box ">
					
					<select class="community_search_select child" name="select">
					<option value="all">전체</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="id">작성자</option>
					<option value="num">글번호</option>
					
					</select>
					<c:choose>
						<c:when test="${not empty search}">
								<input type="text" class="search_bar child" value="${search}" name="search" onkeypress="if(event.keyCode == 13){ location.href='community'; return;}">				
						</c:when>
						<c:otherwise>
					<input type="text" class="search_bar child"   name="search" onkeypress="if(event.keyCode == 13){ location.href='community'; return;}">
						</c:otherwise>
					</c:choose> 
					<button class="search_bt" ><img src="mainImages/search_bt.png" class= "child" name="search" onclick="location.href='community'; return;" style="cursor : pointer;"></button>
					</div><hr>
				</div>
			</div>
		
			<div class="community_info">
			<div><img src="mainImages/notice_icon.png" class="community_info_img">
			<div class="community_info_span"><span>회원 여러분들의 즐거운 소식을 마음껏 공유하세요!</span>
			<br><span>욕설, 비방 시 예고없이 삭제될 수 있습니다.</span></div></div>
			</div>
			<table class="community_table" style="text-align : center;">
			<tr style="background-color : #13294B; height : 40.5px; color : white;">
				<th width=9%>번호</th>
				<th width=12%>작성자</th>
				<th width = 40%>제목</th>
				<th width = 4%>첨부</th>
				<th width = 5%>조회</th>
				<th width = 18%>등록일</th>
			</tr>
			
		<c:if test="${empty communityList}">
			<tr><td><br></td></tr>
			<tr><th colspan="6">검색 결과가 없습니다</th></tr>
			<tr><td><br></td></tr>
		</c:if>
		<c:forEach var = "list" items="${adminList}">
		
			<tr>
				<td class="community_title_td">★필독사항★</td>
				<td> <h1 contenteditable> admin </h1> </td>
                 
				<td class="community_title_title" style="text-align : left;"><span  style="cursor : pointer;" onclick = "location.href='communityDetail?hit=1&num='+${list.num}">${list.title}</span>
			<c:choose>
				<c:when test="${list.commentCount==null || list.commentCount=='' }">
				
				</c:when>
				<c:otherwise>
				<span>&nbsp&nbsp [${list.commentCount}]</span>				
				</c:otherwise>
			</c:choose>	
				</td>
				<c:choose>
					<c:when test="${list.fileName eq '파일 없음' or list.fileName eq '-' or list.fileName eq null}"><td>-</td></c:when>
					<c:otherwise><td><img style="vertical-align: middle;" width ="22" height ="22" src="mainImages/disket.png"></td></c:otherwise>
				</c:choose>
				<td>${list.hit}</td>
				<td>${list.writeDate}</td>	 
			</tr>
			
		</c:forEach>

		<c:forEach var = "list" items="${userList}">
		
			<tr>
				<td class="community_title_td">${list.num}</td>
				<td>${list.id}</td>
				<td class="community_title_title" style="text-align : left;"><span  style="cursor : pointer;" onclick = "location.href='communityDetail?hit=1&num='+${list.num}">${list.title}</span>
			<c:choose>
				<c:when test="${list.commentCount==null || list.commentCount=='' }">
				
				</c:when>
				<c:otherwise>
				<span>&nbsp&nbsp [${list.commentCount}]</span>				
				</c:otherwise>
			</c:choose>	
				</td>
				<c:choose>
					<c:when test="${list.fileName eq '파일 없음' or list.fileName eq '-' or list.fileName eq null}"><td>-</td></c:when>
					<c:otherwise><td><img style="vertical-align: middle;" width ="22" height ="22" src="mainImages/disket.png"></td></c:otherwise>
				</c:choose>
				<td>${list.hit}</td>
				<td>${list.writeDate}</td>	 
			</tr>
			
		</c:forEach>
				
			
			</table>
			<div align="center" class="paging">${page}</div>
		<div class="community_writediv"><input type="button" value="글쓰기" class="community_write_bt" onclick="location.href='community_write_proc'"></div>
		</div>
	</form>
</div>
</body>
</html>