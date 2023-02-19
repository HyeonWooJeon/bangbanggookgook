<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<title>대한민국 방방곡곡</title>
<meta charset="UTF-8">


<link rel="stylesheet" href="css/search/search.css">
</head>
<body>
	<div class="search_body">
		<div class="search_middle">
			<div class="search_category">
		<c:choose>
			<c:when test="${param.select eq 'A02'}">
				<span onclick="location.href='search_onKeyProc?title=${param.title}&select=A02'" style="color : orange;">관광지</span>&nbsp&nbsp|&nbsp&nbsp<span class= "search_category_span" onclick="location.href='search_onKeyProc?select=A05&title=${param.title}'">맛집</span>&nbsp&nbsp|&nbsp&nbsp<span class= "search_category_span" onclick="location.href='search_onKeyProc?select=B02&title=${param.title}'">숙소</span>		
			</c:when>
			<c:when test="${param.select eq 'A05'}">
				<span class= "search_category_span" onclick="location.href='search_onKeyProc?title=${param.title}&select=A02'" >관광지</span>&nbsp&nbsp|&nbsp&nbsp<span onclick="location.href='search_onKeyProc?select=A05&title=${param.title}'" style="color : orange;">맛집</span>&nbsp&nbsp|&nbsp&nbsp<span class= "search_category_span" onclick="location.href='search_onKeyProc?select=B02&title=${param.title}'">숙소</span>		
			</c:when>
			<c:when test="${param.select eq 'B02'}">
				<span class= "search_category_span" onclick="location.href='search_onKeyProc?title=${param.title}&select=A02'" >관광지</span>&nbsp&nbsp|&nbsp&nbsp<span class= "search_category_span" onclick="location.href='search_onKeyProc?select=A05&title=${param.title}'">맛집</span>&nbsp&nbsp|&nbsp&nbsp<span onclick="location.href='search_onKeyProc?select=B02&title=${param.title}'" style="color : orange;">숙소</span>		
			</c:when>
		</c:choose>
		<div style="float : right;"><span>현재 검색어 :</span><span style="color : pink;"> ${param.title}</span></div>
			</div>
			<div class="search_middle_mainInfo">
			<c:choose>
				<c:when test="${empty searchList}">
					<div class="no_info_main">
						<div class="no_info_middle">
							<div class="no_info_imgDiv"><img  class="no_info_img" src="mainImages/no_search.jpg"></div>
							<div class="no_info_letterDiv"><span class="no_info_span"><strong style="color : black;">"${param.title}"</strong>에 대한 검색결과가 없습니다.<br><br>다른 검색어를 입력하시거나 철자,띄어쓰기를 확인해보세요.</span></div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<c:forEach var="list" items="${searchList}">
							<div class="search_spot">
								<c:choose>
									<c:when test="${not empty list.firstImage2}">
											<c:set var = "image" value="${list.firstImage2}"/>
										<c:choose>
											<c:when test="${fn:startsWith(image, 'C:')}">
												<div class="search_imgDiv">
													<img class="search_img" src="/facilityImage/(${list.areaCode})_${list.title}/firstImage2.png" onclick="location.href='concept_detail?contentId=${list.contentId}'" style="cursor : pointer;">
												</div>											
											</c:when>
											<c:otherwise>
												<div class="search_imgDiv">
													<img class="search_img" src="${list.firstImage2}" onclick="location.href='concept_detail?contentId=${list.contentId}'" style="cursor : pointer;">
												</div>											
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<div class="search_imgDiv">
											<img class="search_img" src="mainImages/no_image.jpg" onclick="location.href='concept_detail?contentId=${list.contentId}'" style="cursor : pointer;">
										</div>									
									</c:otherwise>
								</c:choose>
								<div class="search_info">
								<br>
									<div class="search_a"><a class="search_a_a" href="concept_detail?contentId=${list.contentId}" >${list.title}</a></div><br>
									<c:set var="addr" value="${fn:split(list.addr1,' ')}"/>
									<span>${addr[0]} ${addr[1]}</span><br>
									<c:set var = "overView" value="${fn:split(list.overview,' ')}"/>
									<span>${overView[0]} ${overView[1]} ${overView[2]} ${overView[3]} ${overView[4]} ${overView[5]} ${overView[6]} ${overView[7]} ${overView[8]} ${overView[9]}..</span>
								</div>
							</div>
					</c:forEach>
					
				</c:otherwise>
			</c:choose>
		</div>
		<div class="page_div"><span class="page_span">${page}</span></div>
	</div>


	</div>
</body>
</html>