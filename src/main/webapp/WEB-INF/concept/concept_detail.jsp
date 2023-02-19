<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>


<title>대한민국 방방곡곡</title>
  
    <link rel="stylesheet" href="css/concept/concept_detail.css">   

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3677b9e21496224e68f549d3edb54274"></script>


  </head>
  
<body onload="setDraggable(false) , setZoomable(false)">
		<div class="All">
		
		<div class="title"><a style="color: black;">${detail.title}</a></div>
		<div class="add1">${detail.addr1}</div>
		
		<c:choose>
			<c:when test="${not empty detail.firstImage}">
				<c:set var ="image" value="${detail.firstImage}"/>
				<c:choose>
					<c:when test="${fn:startsWith(image,'C:')}">
						<div class="img">
						<img class="image" src="/facilityImage/(${detail.areaCode})_${detail.title}/firstImage.png">
						</div>					
					</c:when>
					<c:otherwise>
						<div class="img">
						<img class="image" src="${detail.firstImage}">
						</div>					
					</c:otherwise>
				</c:choose>
				</c:when>
				<c:otherwise>
				<div class="img">
				<img class="image" src="image/no_image.jpg">
				</div> 				
				</c:otherwise>
		</c:choose>
		<div class="text">
		<div class="textHead">
		<a style="color: black;">상세 정보</a><hr style="border: solid 1px black;">
		</div>
		<div >
		<a style="color: black;">${detail.overview}</a><br><br>
		</div>
		<div>
		
		</div>


<%-- <div class="text">우편번호 : ${detail.zipcode}</div><br> --%>
<c:if test="${not empty detail.tel }">
<div class="text">[ 전화번호 ]<br>${detail.tel}</div>
</c:if>
<c:if test="${empty detail.tel}">
<div class="text">전화번호 : 없음(전화번호를 제공하지 않은 업체입니다.)</div>
</c:if>
</div>

<div id="map" style="width:800px; height:400px; margin:auto; margin:30px 30px 30px 80px; border : 1px solid gray"></div>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(${detail.mapY}, ${detail.mapX}), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(${detail.mapY}, ${detail.mapX}); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

function setDraggable(draggable) {
    // 마우스 드래그로 지도 이동 가능여부를 설정합니다
    map.setDraggable(draggable);    
}
function setZoomable(zoomable) {
    // 마우스 휠로 지도 확대,축소 가능여부를 설정합니다
    map.setZoomable(zoomable);    
}

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);
</script>
</div>
</body>
</html>