<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${empty sessionScope.id }">
	<script>
		location.href="main";
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/member/myRoute.css">
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
			<span>나의 일정</span>
		</div>
		<!-- 끝 -->
		
		<div class="content">
		<input type="hidden" id = "id" name="id" value="${sessionScope.id }" />
		
			<c:choose>
			<c:when test="${empty subject}">
			<div class="routeNon1">
<!-- 				<div class="routeNon2"> -->
<!-- 					<input type="button" value="일정만들기" class="RouteBtn" onclick="location.href='route'"> -->
<!-- 				</div> -->
				<div class="routeNon2">
					<span style="font-size: 40px;">나의 일정이 없습니다.</span>
				</div>
			</div>
			</c:when>
			<c:otherwise>
			<c:forEach var = "cnt" begin = "0" end = "${ subject.size() - 1 }" step = "1">
			<div class="listWrap">
				<div class="list">
					<div class="listNum">
						<label>
							${ cnt+1 }
						</label>
					</div>
					<label class = "">
						<img src = "${ image[cnt] }">
					</label>
						<div class="travelName">
					<label class = "listSubjectName">
					여행이름 : </label>
					<label class = "listSubject"  style="font-size: 20px; cursor : pointer;"  
					onclick = "location.href='myRouteDetail?id=${ id }&subject=${ subject[cnt] }'">
						${ subject[cnt] }
					</label>
					</div>
					<div class="travelDate">
					<label class = "travelDateLabel">
					여행날짜 : </label>
					<label class = "listSubjectDate">
						${ calendar_start[cnt] }&nbsp;&nbsp;~
					</label>
					
					<label class = "listSubjectDate">
						${ calendar_end[cnt] }
					</label>
					</div>
					<div style="float: right;    margin: -70px 88px 0 0;">
					</div>
				</div>
				<div style="float: right; margin: -140px 80px 0 0;">
				<div>
					<input type="button" value="상세보기" class="RouteBtn" onclick="location.href='myRouteDetail?id=${ id }&subject=${ subject[cnt] }'" >
				</div>
				<div style="margin-top: 25px;">
					<input type="button" value="일정삭제" class="RouteBtn" onclick="myRouteDelete('${ subject[cnt] }')">
				</div>
				</div>
				
			</div>
			</c:forEach>
			</c:otherwise>
			</c:choose>
		</div>
<!-- 			<hr> -->
		<div class="routeImg">
			<img src="image/route.gif" class="gif">
		</div>
	</div>
</body>
<script type="text/javascript">
function myRouteDelete(subject) {
	if(!confirm("삭제하시겠습니까?")){return;}
	location.href="myRouteDelete?subject=" + subject;
}
</script>
</html>