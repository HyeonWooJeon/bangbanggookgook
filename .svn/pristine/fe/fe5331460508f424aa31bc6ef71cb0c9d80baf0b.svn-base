<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<title>대한민국 방방곡곡 일정만들기</title>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/route/route.css"> 
<link href="https://fonts.googleapis.com/css?family=Poppins:600" rel="stylesheet">
<link href="mainImages/icon.ico" rel="shortcut icon" type="image/x-icon">

<script src="js/route/bootstrap-datepicker.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="js/route/route.js"></script>

<!-- css -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/
4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous"> -->

<%-- 로그인상태 확인 --%>
<c:if test = "${ empty id }">
   <script>
      alert("로그인 후 이용 가능합니다.");
      location.href = "/main"
   </script>
</c:if>

</head>
<body style = "overflow : hidden;">
<div class="map_wrap">
<div id="map"> 
   <!-- kakaoMap API -->
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=323990993000f85cf458c22c6ceaa8cf&libraries=services"></script>
   <script src ="js/route/mapAPI.js"></script>
</div>
    <div id="menu_wrap" class="bg_white">
        <div class="option">
            <div class="search">
                <input type="text" placeholder="검색어를 입력하세요"  id = "keyword" size="15"> 
                <button type="button" id="search_btn" onclick = "search()" style = "cursor : pointer;"> </button>
                <div class = "categoryBtnArea">
                   <button type="button" class="btn btn-primary btn-primary-shapeFix1" onclick = "searchResult()">#전체</button>
                   <button type="button" class="btn btn-primary btn-primary-shapeFix2" onclick = "searchResult('A02')">#관광지</button>
                   <button type="button" class="btn btn-primary btn-primary-shapeFix3" onclick = "searchResult('A05')">#음식</button>
                   <button type="button" class="btn btn-primary btn-primary-shapeFix4" onclick = "searchResult('B02')">#숙박</button>
                </div>
                <div class="searchDataCount">
                   <label id = "searchDataCount"></label>
                </div>
            </div>
        </div>
        <hr>
        
        <div id="placeListWrapper" class = "placeListWrapper">
           <%-- search Data Area --%>
        </div>
    </div>
    
<!--     <div id="mapwrap">  -->
<!--     지도가 표시될 div -->
<!-- <!--     <div id="map" style="width:100%;height:350px;"></div> -->
<!--     지도 위에 표시될 마커 카테고리 -->
<!--     <div class="category"> -->
<!--         <ul> -->
<!--             <li id="coffeeMenu" onclick="changeMarker('coffee')"> -->
<!--                 <span class="ico_comm ico_coffee"></span> -->
<!--             </li> -->
<!--             <li id="storeMenu" onclick="changeMarker('store')"> -->
<!--                 <span class="ico_comm ico_store"></span> -->
<!--                 편의점 -->
<!--             </li> -->
<!--             <li id="carparkMenu" onclick="changeMarker('carpark')"> -->
<!--                 <span class="ico_comm ico_carpark"></span> -->
<!--                 주차장 -->
<!--             </li> -->
<!--         </ul> -->
<!--     </div> -->
<!-- </div> -->
    <c:if test = "${ calendar ne 0 }">
       <a class="getCalendarBtn" id="GCBtn"><h6>일정 불러오기</h6></a> 
    </c:if>
    <a class="recommendplaceBtn" id="RPBtn"><h6>저장 / 수정</h6></a>
    <a class="calendarSaveBtn" id="RHBtn"  onclick="searchRecommend()"><h6>추천장소</h6></a>
</div>


</body>

<div class="side-left" > 

<span class = "logoArea">
<a>   <img src = "image/logologo.png" class = "logo" onclick="logoCheck()"></a>
</span>

<div class ="da">
   <input type="text" id="datepicker" size=10> <span class="hp"> - </span><input type="text" id="datepicker2">      
</div>

   <div class="selectCard">

      <div class="selectTitle">
         <span> 선택목록 </span>
      </div>
<!-- 
      <div class="selectCard2">
         <ul id="tabs">
            <li class="tab"><a id="hotelTab" href="#"> 숙소 </a></li>
            <li class="tab"><a id="placeTab" href="#"> 장소 </a></li>
         </ul>
      </div> 
-->
      
      <div class="allDelete">
         <button type="button" id="allClear" onclick="allClearList()">
            전체 삭제
         </button>
      </div>

      <ul class="selectBox" id="card">
         <li>
            <div class = "cartList2" id = "cartList2">
            </div>
         </li>
      </ul>
   </div>
</div>
<div class = "categoryArea">
<%-- 하단 hidden Tag의 value는 service까지 가져감 --%>
<input type = "button" id = "category_tour" class = "common common_tour" value = "관광지">
<input type = "button" id = "category_food" class = "common common_food" value = "음식점">
<input type = "button" id = "category_lodge" class = "common common_lodge" value = "숙소">
</div>

<%-- 일정 저장하기 --%>
<div class = "modal-overlay">
   <div class = "modalArea">
      <div class = "modal_top">
         <img alt="" src="mainImages/icon.ico" id="i-icon">
         <label class = "modal_topText">일정 저장</label>
         <label style = "color : white;" id="xx1">x</label>
      </div>
   
      <div class = "modal_bottom">
         
         <button id = "save1" type = "button">신규저장</button>
         <c:if test = "${ subject ne '[]' }">
            <button id = "update" type = "button">수정 / 덮어쓰기</button>
         </c:if>
         <%-- 신규저장 --%>
         <input id = "calendarSubject" class = "calendarSubject" type = "text" placeholder = "제목을 입력하세요"> <br>
         <button id = "save2" class = "save2" type = "button" onclick = "saveCalendar()">저장</button>
         
         <%-- 수정저장 --%>
         <label id = "updateInfoText" class = "updateInfoText"> * 선택하신 제목의 일정에 덮어씌워집니다. *</label>
         <select  size="5" id = "updateSelectBox" class = "updateSelectBox">
            <option value = "" hidden>------ 일정을 선택 해주세요 ------</option>
            <c:forEach var = "s" items = "${ subject }">
               <option class="optiont" value = "${ s }"> &nbsp &nbsp &nbsp  ${ s }</option>
            </c:forEach>
         </select>
         <div> <button id = "updateBtn" class = "updateBtn" onclick = "updateCalendar()">수정</button> </div>
<!--          <button id = "cancel" type = "button">취소</button> -->
      </div>
   </div>
</div>

<%-- 일정 불러오기 --%>
<div class = "modal-overlay2">
   <div class = "modalArea2">
      <div class = "modal_top2">
         <img alt="" src="mainImages/icon.ico" id="i-icon2">
         <label class = "modal_topText2">일정 불러오기</label>
         <label style = "color : white;" id="xx"  onclick="xxCheck()">x</label>
      </div>
      
      <div class = "modal_bottom2">
         <%-- change = onclick="getCalendar('${ id }')" --%>
         <select  size="5" id = "myCalendars" onsearch = "getCalendar('${ id }', this)">
            <option value = "" hidden > &nbsp 일정을 선택해주세요 </option>
               
            <c:forEach var = "s" items = "${ subject }">
               <option class="option1" value = "${ s }" onclick = "getCalendar('${ id }', this.value)"> &nbsp ${ s }</option>
            </c:forEach>
         </select>
         <!-- <button id = "cancel2" type = "button">취소</button>  -->
      </div>
   </div>
</div>
</body>
</html>