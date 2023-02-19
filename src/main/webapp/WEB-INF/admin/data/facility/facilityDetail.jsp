<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel = "stylesheet" href = "/css/admin/data/facility/facilityDetail.css">

<!-- script -->
<!-- KakaoMap API Import -->
<%-- 
	kakaoMap API Key : 
	b430f2906597b025c6f5b2e2f62729be
--%>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b430f2906597b025c6f5b2e2f62729be&libraries=services"></script>

<!-- Daum PostCode API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- script -->
<script src = "/js/admin/data/facility/facilityDetail.js"></script>

</head>
<body>
	<div class = "facilityDetailWrapper">
		<div id = "facilityDetailData" class = "facilityDetailData">
			<form id = "facilityRegForm" class="row g-3" method = "POST" enctype = "multipart/form-data">
				<div class="facilityDataInputArea">
					<label for="formGroupExampleInput" class="form-label">업체명</label> 
					<input type="text" class="form-control" id = "facilityTitle" name = "title" placeholder="업체명을 입력하세요." value = "${ facility.title }">
					
					<%-- img 경로 재설정시에 이전 경로 삭제를 위해 보관 --%>
					<input name = "prevTitle" type = "hidden" value = "${ facility.title }">
					<input name = "contentId" type = "hidden" value = "${ facility.contentId }">
				</div>
				
				<c:choose>
					<c:when test = "${ facility.recommend ne 'y' }">
						<div id = "recommandArea-1" class="facilityDataInputArea">
							<label for="formGroupExampleInput" id = "recommandTxt" class="form-label">추천업소 등록</label> <br>
							<button type = "button" id = "detailRecommand" class = "btn btn-secondary btn-secondary-shapeFix">추천업소 등록하기</button>
							<input id = "recommend" name = "recommend" type = "hidden">
						</div>
					</c:when>
					<c:otherwise>
						<input type = "hidden" name = "recommend" value = 'y'>
					</c:otherwise>
				</c:choose>
				
<!-- 				<div id = "recommandArea-2" class="facilityDataInputArea display-none"> -->
<!-- 					<input id = "recommend" name = "recommend" type = "hidden">  -->
<!-- 					<label for="formGroupExampleInput2" id = "recommandComment" class="form-label">추천 comment</label>  -->
<!-- 					<input type="text" class="form-control" id="facilityRecommendComment" name = "recommandComment" placeholder = "추천 comment를 입력하세요."> -->
<!-- 				</div> -->
				
				<div class="facilityDataInputArea">
					<label for="formGroupExampleInput2" class="form-label">전화번호</label> 
					<input type="text" class="form-control" id="facilityTel" name = "tel" placeholder="업체 전화번호를 입력하세요." value = "${ facility.tel }">
				</div>
				
				<div class="facilityDataInputArea">
					<label for="formGroupExampleInput2" class="form-label addressLabel">주소</label> 
					<input type="text" class="form-control addressInput" id="facilityZipcode" name = "zipcode" placeholder = "우편번호" value = "${ facility.zipcode }" readonly>
					<button type = "button" class = "btn btn-secondary addressSearchBtn"  onclick = "postCodeOpen()">주소 검색</button>
					<input type="text" class="form-control address" id = "facilityAddr1" name = "addr1" placeholder = "주소" value = "${ facility.addr1 }" readonly>
					<input type="text" class="form-control address" id = "facilityAddr2" name = "addr2" placeholder = "상세주소를 입력하세요." value = "${ facility.addr2 }">
					<input type = "hidden" id = "areaCode" name = "areaCode" value = "${ facility.areaCode }">
					<input type = "hidden" name = "prevAreaCode" value = "${ facility.areaCode }">
					<input type = "hidden" id = "mapX" name = "mapX">
					<input type = "hidden" id = "mapY" name = "mapY">
				</div>

				<div class="facilityDataInputArea">
					<label for="facilityCat1" class="form-label">업태</label> <br>
					<select id = "cat1" class = "form-select form-select-lg mb-3 facilityCat1" name = "cat1">
						<option value = "">-- 카테고리(1) --</option>
						<c:choose>
							<c:when test = "${ facility.cat1 eq 'A02' }">
								<option id = "cat1_1" class = "cat1_1" value = "A02" selected>[A02]인문(문화/예술/역사)</option>
								<option id = "cat1_2" class = "cat1_2" value = "A05">[A05]음식</option>
								<option id = "cat1_3" class = "cat1_3" value = "B02">[B02]숙박</option>
							</c:when>
							
							<c:when test = "${ facility.cat1 eq 'A05' }">
								<option id = "cat1_1" class = "cat1_1" value = "A02">[A02]인문(문화/예술/역사)</option>
								<option id = "cat1_2" class = "cat1_2" value = "A05" selected>[A05]음식</option>
								<option id = "cat1_3" class = "cat1_3" value = "B02">[B02]숙박</option>
							</c:when>
							
							<c:when test = "${ facility.cat1 eq 'B02' }">
								<option id = "cat1_1" class = "cat1_1" value = "A02">[A02]인문(문화/예술/역사)</option>
								<option id = "cat1_2" class = "cat1_2" value = "A05">[A05]음식</option>
								<option id = "cat1_3" class = "cat1_3" value = "B02" selected>[B02]숙박</option>
							</c:when>
							
							<c:otherwise>
								<option id = "cat1_1" class = "cat1_1" value = "A02">[A02]인문(문화/예술/역사)</option>
								<option id = "cat1_2" class = "cat1_2" value = "A05">[A05]음식</option>
								<option id = "cat1_3" class = "cat1_3" value = "B02">[B02]숙박</option>
							</c:otherwise>
						</c:choose>
					</select>

					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-fast-forward bi-fast-forward-margin" viewBox="0 0 16 16">
  						<path d="M6.804 8 1 4.633v6.734L6.804 8Zm.792-.696a.802.802 0 0 1 0 1.392l-6.363 3.692C.713 12.69 0 12.345 0 11.692V4.308c0-.653.713-.998 1.233-.696l6.363 3.692Z" />
  						<path d="M14.804 8 9 4.633v6.734L14.804 8Zm.792-.696a.802.802 0 0 1 0 1.392l-6.363 3.692C8.713 12.69 8 12.345 8 11.692V4.308c0-.653.713-.998 1.233-.696l6.363 3.692Z" />
					</svg>

					<select id = "cat2" class = "form-select form-select-lg mb-3 facilityCat2" name = "cat2">
						<option id = "cat2" class = "cat2_noVal" value = "">-- 카테고리(2)--</option>
						<script>
							document.getElementById("cat2").style.display = "inline-block";
						</script>
						
						<c:choose>
							<c:when test = "${ facility.cat2 eq 'A0101' }">
								<option id = "cat2_1" class = "cat2_1" value = "A0101" selected>[A0101]자연관광지</option>
								<option id = "cat2_2" class = "cat2_2" value = "A0102">[A0102]관광자원</option>
								<option id = "cat2_3" class = "cat2_3" value = "A0502">[A0502]음식점</option>
								<option id = "cat2_4" class = "cat2_4" value = "B0201">[B0201]숙박시설</option>
							</c:when>
							
							<c:when test = "${ facility.cat2 eq 'A0102' }">
								<option id = "cat2_1" class = "cat2_1" value = "A0101">[A0101]자연관광지</option>
								<option id = "cat2_2" class = "cat2_2" value = "A0102" selected>[A0102]관광자원</option>
								<option id = "cat2_3" class = "cat2_3" value = "A0502">[A0502]음식점</option>
								<option id = "cat2_4" class = "cat2_4" value = "B0201">[B0201]숙박시설</option>
							</c:when>
							
							<c:when test = "${ facility.cat2 eq 'A0502' }">
								<option id = "cat2_1" class = "cat2_1" value = "A0101">[A0101]자연관광지</option>
								<option id = "cat2_2" class = "cat2_2" value = "A0102">[A0102]관광자원</option>
								<option id = "cat2_3" class = "cat2_3" value = "A0502" selected>[A0502]음식점</option>
								<option id = "cat2_4" class = "cat2_4" value = "B0201">[B0201]숙박시설</option>
							</c:when>
							
							<c:when test = "${ facility.cat2 eq 'B0201' }">
								<option id = "cat2_1" class = "cat2_1" value = "A0101">[A0101]자연관광지</option>
								<option id = "cat2_2" class = "cat2_2" value = "A0102">[A0102]관광자원</option>
								<option id = "cat2_3" class = "cat2_3" value = "A0502">[A0502]음식점</option>
								<option id = "cat2_4" class = "cat2_4" value = "B0201" selected>[B0201]숙박시설</option>
							</c:when>
							
							<c:otherwise>
								<option id = "cat2_1" class = "cat2_1" value = "A0101">[A0101]자연관광지</option>
								<option id = "cat2_2" class = "cat2_2" value = "A0102">[A0102]관광자원</option>
								<option id = "cat2_3" class = "cat2_3" value = "A0502">[A0502]음식점</option>
								<option id = "cat2_4" class = "cat2_4" value = "B0201">[B0201]숙박시설</option>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				
				<div class="facilityDataInputArea">
					<label for="formFileMultiple" class="form-label">대표이미지</label><label style = "color : red; font-size : 14px;">(* 기존 이미지를 유지할 경우 건너뛰기)</label>
					<input class="form-control" type="file" id="formFileMultiple" name = "uploadFile">
				</div>
				
				<div class="facilityDataInputArea">
					<label for="formFileMultiple" class="form-label">썸네일 이미지</label><label style = "color : red; font-size : 14px;">(* 기존 이미지를 유지할 경우 건너뛰기)</label>
					<input class="form-control" type="file" id="formFileMultiple" name = "uploadFile">
				</div>
				
				<div class = "facilityDataInputArea" align = center>
					<button id = "nextBtn" type="button" class="btn btn-secondary btn-secondary-shapeFix-next btn-secondary-event">다음단계</button>
					<button id = "nextBtn" type="button" class="btn btn-secondary btn-secondary-shapeFix-next btn-secondary-event" onclick = "history.back()">목록</button>
				</div>
			</form>
		</div>
		
		<div id = "map" class = "map">
			<script src = "/js/admin/data/facility/facilityDetail_kakaoMap.js"></script>
		</div>
	</div>
	<div id = "facilityDetailData2" class = "facilityDetailData overviewArea">
		<div class="facilityDataInputArea">
			<label for="formGroupExampleInput" class="form-label">설명/정보</label> 
			<textarea rows = 25 id = "facilityOverview" class="form-control form-control-resizable" name = "overview" placeholder="업체에 대한 설명과 정보를 작성하세요.">${ facility.overview }</textarea>
		</div>
		
		<div class = "facilityDataInputArea facilityDataInputArea-btnReplace" align = center>
			<button id = "prevBtn" type="button" class="btn btn-secondary btn-secondary-shapeFix-prev btn-secondary-event">이전단계</button>
			<button type="button" id = "detailBtn" class="btn btn-danger btn-danger-shapeFix">저장</button>
		</div>
	</div>
</body>
</html>