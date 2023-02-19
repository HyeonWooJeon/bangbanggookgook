<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<title>대한민국 방방곡곡</title>
<meta charset="UTF-8">
  
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    
    
    
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
	<link rel="stylesheet" href="css/main/main.css">

<style>
.slick-next{
	    background : url(mainImages/btn_slider_next01.png) ;

	    width: 60px;
	    height: 60px;
 	    margin-top: -15px !important; 
	    right: 50px;
 	    text-indent: -9999px;} 
.slick-prev{
      	background : url(mainImages/btn_slider_prev01.png) ;
       
	    width: 60px;
	    height: 60px;
	    margin-top: -15px !important;
	    right: -30px;
	    left : 50px;
	    text-indent: -9999px;
 	    z-index : 10;
	    }
	    
.slick-next:hover, .slick-next:focus{
   	    background : url(mainImages/btn_slider_next01.png);
	    width: 60px;
		height: 60px;
 	    margin-top: -15px !important; 
	    right: 50px;
 	    text-indent: -9999px ;
}
.slick-prev:hover , .slick-prev:focus{
      	background : url(mainImages/btn_slider_prev01.png) ;
	    width: 60px;
	    height: 60px;
	    margin-top: -15px !important;
	    right: -30px;
	    left : 50px;
	    text-indent: -9999px;
	    z-index : 10;
}



</style>


  <body>

    <div class="slider">
      <div class = "sliderImg" onclick="location.href='https://korean.visitkorea.or.kr/detail/rem_detail.do?cotid=14a13909-134a-4a0e-a581-fc1ace95d925'"><img src="mainImages/slick_1.jpg" width="100%;"></div>
      <div class = "sliderImg"><img src="mainImages/slick_2.jpg" width="100%;"></div>
      <div class = "sliderImg"><img src="mainImages/slick_3.jpg" width="100%;"></div>
      <div class = "sliderImg"><img src="mainImages/slick_4.jpg" width="100%;"></div>
      <div class = "sliderImg"><img src="mainImages/slick_5.jpg" width="100%;"></div>
      <div class = "sliderImg"><img src="mainImages/slick_6.jpg" width="100%;"></div>
      <div class = "sliderImg"><img src="mainImages/slick_7.jpg" width="100%;"></div>
      <div class = "sliderImg"><img src="mainImages/slick_8.jpg" width="100%;"></div>
    </div>
    
    
    <div class ="planMaker">
    <div class = "planMaker_Title">
    <h2 class="planMaker_h2"><img class="menuImg" src = "mainImages/tit_curation_marea.png"></h2>
    </div><br>
    <div class="menu">
		<ul class="menu_ul">
			<li id = "tab_1" class="menu_li" data-tab="tab-1" data-tab2="tab-2"><a href ="tab-1"><img class = "menuli" src="mainImages/menu1.png"></a>
			<br>
			<pre id ="tab-2" class="menu_span current">
 지역 별 
 핫한 여행지를 
 소개합니다!</pre>
			</li>
			<li id = "tab_2" class="menu_li" data-tab="tab-11" data-tab2="tab-21"><a href ="#"><img class = "menuli" src="mainImages/menu2.png"></a>
			<br><pre id ="tab-21" class="menu_span">
 지역 별 핫한 
 맛집을 소개합니다!</pre>
			</li>
			<li id = "tab_3" class="menu_li" data-tab="tab-12" data-tab2="tab-22"><a href ="tab-3"><img class = "menuli" src="mainImages/menu3.png"></a>
			<br><pre id ="tab-22" class="menu_span">
 나만의 코스를 
 만들어보세요!</pre>
			</li>
		</ul>
    </div>
    <div class="tab_cont">
		<div id="tab-1" class="ai_condiv current">
			<ul id="ailist">
			<c:forEach var = "list" items="${recommendSights}">
				<c:choose>
					<c:when test="${not empty list.firstImage}">
						<li><div class="ai_endiv"><div class="ai_div"><a href="concept_detail?contentId=${list.contentId}" ><img class="ai_img" src="${list.firstImage}"></a></div><div class="ai_letter"><span class="ai_span">${list.title}</span></div></div></li>					
					</c:when>
					<c:otherwise>
						<li><div class="ai_endiv"><div class="ai_div"><a href="concept_detail?contentId=${list.contentId}" ><img class="ai_img" src="mainImages/no_image.jpg"></a></div><div class="ai_letter"><span class="ai_span" style="color : #606060;">${list.title}</span></div></div></li>					
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</ul>
		</div>
		<div id="tab-11" class="ai_condiv">
			<ul id="ailist">
			<c:forEach var = "list" items="${recommendFood}">
				<c:choose>
					<c:when test="${not empty list.firstImage}">
						<li><div class="ai_endiv"><div class="ai_div"><a href="concept_detail?contentId=${list.contentId}"><img class="ai_img" src="${list.firstImage}"></a></div><div class="ai_letter"><span class="ai_span" >${list.title}</span></div></div></li>					
					</c:when>
					<c:otherwise>
						<li><div class="ai_endiv"><div class="ai_div"><a href="concept_detail?contentId=${list.contentId}" ><img class="ai_img" src="mainImages/no_image.jpg"></a></div><div class="ai_letter"><span class="ai_span" style="color : #606060;">${list.title}</span></div></div></li>					
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</ul>
		</div>
		<div id="tab-12" class="ai_condiv">
			<ul id="ailist">
				<li ><div class="noCourse_div" ><img class="noCourse_img" src ="mainImages/bg_curation_cos1.png">
				<div class="noCourse_right">
				<h3 style="margin-top : -50px;">여행 계획을 준비중이신가요?</h3><br>
				<span>나만의 여행코스를 만들어보세요!</span><br><br>
				<a href="route" class="makeCourse" style="color:white; size : 16px;">나만의 코스 생성 시작</a><br><br>
				</div>
				</div>
				</li>
			</ul>
		</div>
	</div>
    </div>
    
    <div class="third_main">
    <div class="third_middle">
    <div class="third_left">
    <table style="margin : 0 auto;">
    <tr><th width="450" align ="left"><span class="third_table_span">여행 Issue</span><span style="color :#755aa5 ; font-size : 20px; margin-left : 30px;">feat.공지사항</span></th><th width="80"><span class="third_table_span2" onclick="location.href='notice'">더보기</span></th></tr>
    <tr><td><br></td></tr>
    <c:forEach var="list" items="${noticeList}">
    <tr><td class="third_left_notice_title" colspan="2" height="40" style="vertical-align : middle;"><span class="third_table_content" onclick="location.href='noticeDetail?hit=1&num='+${list.num}">${list.title}</span></td></tr>
   <tr><td colspan="2"  style="border-bottom : 2px solid #EFEFEF; "></td></tr>
    </c:forEach>
    </table>
    </div>
    <div class="third_right">
    	<div class="third_right_slider1">
    		<div class="third_right_pack">
    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/digtCard/digt_card_intro.do?utm_source=mainshowcase')">
    			<img src="mainImages/middle_slider1.png">
    		</div>
    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/detail/rem_detail.do?cotid=42913301-ed13-43fb-9e73-1cc540f5849b&temp=')">
    			<img src="mainImages/middle_slider2.png">
    		</div>
    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/wallpaper/main.do')">
    			<img src="mainImages/middle_slider3.png">
    		</div>
    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/detail/event_detail.do?cotid=667ebc68-58dd-47e8-aceb-ac1ca8d8ac03')">
    			<img src="mainImages/middle_slider4.png">
    		</div>
    		</div>
    		
    		<div class="third_right_pack">
    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/detail/event_detail.do?cotid=2cd4725e-8a24-45c3-829e-b25e2e05e37d')">
    			<img src="mainImages/middle_slider5.png">
    		</div>
    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/detail/event_detail.do?cotid=5e7bfff9-9d90-44ac-b586-a865a281f3bf')">
    			<img src="mainImages/middle_slider6.png">
    		</div>

    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/trss/applyintro.do?utm_source=main_showcase')">
    			<img src="mainImages/middle_slider7.png">
    		</div>
    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/detail/event_detail.do?cotid=d80c2c04-6e0c-4b9f-be9c-f08be21a120a')">
    			<img src="mainImages/middle_slider8.png">
    		</div>
    		</div>
    		
    		<div class="third_right_pack">
    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/detail/event_detail.do?cotid=0911b879-31f4-4e9b-916f-0d47139bf1e9')">
    			<img src="mainImages/middle_slider9.png">
    		</div>
    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/localfood/main.do')">
    			<img src="mainImages/middle_slider10.png">
    		</div>
    		<div class="third_right_div" onclick="window.open('https://19.visitkorea.or.kr/jeju/')">
    			<img src="mainImages/middle_slider11.png">
    		</div>
    		<div class="third_right_div" onclick="window.open('https://korean.visitkorea.or.kr/detail/rem_detail.do?cotid=3ce96d9a-d814-465e-b8b0-7fb9d17bcaf9&temp=')">
    			<img src="mainImages/middle_slider12.png">
    		</div>   
    		</div> 		
    	
    	
    	</div>
    </div>
    </div>
    
    </div>

  </body>
  <script src="js/main/main.js"></script>
</html>