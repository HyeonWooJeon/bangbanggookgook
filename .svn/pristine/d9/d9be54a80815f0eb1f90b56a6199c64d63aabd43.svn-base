/**
서울시 : 1 / 인천시 : 2 / 대전시 : 3 / 대구시 : 4 / 광주시 : 5
부산시 : 6 / 울산시 : 7 / 세종특별자치시 : 8 / 경기도 : 31 / 강원도 : 32
충청북도 : 33 / 충청남도 : 34 / 경상북도 : 35 / 경상남도 : 36 / 전라북도 : 37 
전라남도 : 38 / 제주도 : 39
 */

// 서울 : 서울, 인천 : 인천, 대전 : 대전, 대구 : 대구, 광주 : 광주 
// 부산 : 부산, 울산 : 울산, 세종 : 세종특별자치시, 경기도 : 경기, 강원도 : 강원 
// 충청북도 : 충북, 충청남도 : 충남, 경상북도 : 경북, 경상남도 : 경남, 전라북도 : 전북
// 전라남도 : 전남, 제주도 : 제주특별자치도
$(function() {
	// cat1 value 변경시
	$("#cat1").change(function() {
		document.getElementById("cat2").selected = "true";
		
		var tmp = $("#cat1").val();
		if (tmp == "") {
			document.getElementById("cat2").style.display = "none";
			return;
		}
		
		document.getElementById("cat2").style.display = "inline-block";
		if (tmp == 'A02') {
			document.getElementById("cat2_1").style.display = "block";
			document.getElementById("cat2_2").style.display = "block";
			document.getElementById("cat2_3").style.display = "none";
			document.getElementById("cat2_4").style.display = "none";
		}
		else if (tmp == 'A05') {
			document.getElementById("cat2_1").style.display = "none";
			document.getElementById("cat2_2").style.display = "none";
			document.getElementById("cat2_3").style.display = "block";
			document.getElementById("cat2_4").style.display = "none";
		}
		else if (tmp == 'B02') {
			document.getElementById("cat2_1").style.display = "none";
			document.getElementById("cat2_2").style.display = "none";
			document.getElementById("cat2_3").style.display = "none";
			document.getElementById("cat2_4").style.display = "block";
		}
	});
	
	// 다음단계 버튼 클릭시
	$("#nextBtn").on("click", function() {
		document.getElementById("facilityRegistData").className = "facilityRegistData slide-event-1";
		document.getElementById("facilityRegistData2").className = "facilityRegistData slide-event-2 overviewArea";
	});
	
	// 이전단계 버튼 클릭시
	$("#prevBtn").on("click", function() {
		document.getElementById("facilityRegistData").className = "facilityRegistData slide-event-3";
		document.getElementById("facilityRegistData2").className = "facilityRegistData slide-event-4 overviewArea";
	});

	// 추천업소 등록하기 버튼 클릭시
	$("#registRecommand").on("click", function() {
		if (confirm("추천업소로 등록하시겠습니까?")) {
			document.getElementById("recommend").value = "y";
			document.getElementById("recommandArea-1").className = "display-none";
//			document.getElementById("recommandArea-2").className = "facilityDataInputArea";
		}
	});
	
	// 등록하기 버튼 클릭시
	$("#registBtn").on("click", function() {
		// 입력데이터 검증
		if (document.getElementById("facilityTitle").value == "") {
			msg("title");
			return;
		} else if (document.getElementById("facilityZipcode").value == "" && document.getElementById("facilityAddr1").value == "") {
			msg("addr");
			return
		} else if (document.getElementById("cat1").value == "") {
			msg("category");
			return;
		} else if (document.getElementById("cat2").value == "") {
			msg("category");
			return;
		}
		
		var overview = document.getElementById("facilityOverview").value;
		document.getElementById("facilityRegForm").action = "/admin/facilityRegist?overview=" + overview;
		document.getElementById("facilityRegForm").submit();
	});
});

function msg(obj) {
	if (obj == "title")
		alert("업체명을 작성하세요.");
	else if (obj == "addr")
		alert("주소지를 입력하세요.");
	else if (obj == "category")
		alert("업태를 선택하세요.");
}