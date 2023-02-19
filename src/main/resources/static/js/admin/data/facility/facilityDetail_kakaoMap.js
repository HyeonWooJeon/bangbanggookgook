var xmlReq;
var returnData;

// kakaoMap 활용
// mapContainer변수에 map(div tag) 참조값 부여
// map변수에 new kakao.maps.Map 객체 참조값 부여
var mapContainer = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var geocoder = new daum.maps.services.Geocoder(); // Post API에서 위치 검색시 주소값으로 좌표 찾아 map위치 변경
var coords;

var urlParams = new URL(location.href).searchParams;
var mapX = urlParams.get("mapX");
var mapY = urlParams.get("mapY"); 
console.log("mapX : " + mapX + "\nmapY : " + mapY);

// 지도 생성시 옵션
var options = { //지도를 생성할 때 필요한 기본 옵션
	// center 메뉴얼
	// - 흔히 위경도 좌표라고 부르는 WGS84 좌표계의 좌표값을 넣어서 만드는데요
	// - 생성인자는 위도(latitude), 경도(longitude) 순으로 넣어주세요.
	center: new kakao.maps.LatLng(mapY, mapX), //지도의 중심좌표. 지도를 생성하는데 반드시 필요하다.
	level: 3, //지도의 레벨(확대, 축소 정도)
	draggable : false
};


var map = new kakao.maps.Map(mapContainer, options); //지도 생성 및 객체 리턴

// 지도 마커
var marker = new daum.maps.Marker ({
    position: new daum.maps.LatLng(mapY, mapX),
    map : map
});

function postCodeOpen() {
    new daum.Postcode({
        oncomplete: function(data) {
			document.getElementById("facilityZipcode").value = data.zonecode;
			if (data.userSelectedType == "R")
				document.getElementById("facilityAddr1").value = data.address;
			else if (data.userSelectedType == "J")
				document.getElementById("facilityAddr1").value = data.jibunAddress;
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
			var areaCode = document.getElementById("areaCode");
			switch(data.sido) {
				case "서울" :
					areaCode.value = 1;
				case "인천" :
					areaCode.value = 2;
				case "대전" :
					areaCode.value = 3;
				case "대구" :
					areaCode.value = 4;
				case "광주" :
					areaCode.value = 5;
				case "부산" :
					areaCode.value = 6;
				case "울산" :
					areaCode.value = 7;
				case "세종특별자치시" :
					areaCode.value = 8;
				case "경기" :
					areaCode.value = 31;
				case "강원" :
					areaCode.value = 32;
				case "충북" :
					areaCode.value = 33;
				case "충남" :
					areaCode.value = 34;
				case "경북" :
					areaCode.value = 35;
				case "경남" :
					areaCode.value = 36;
				case "전북" :
					areaCode.value = 37;
				case "전남" :
					areaCode.value = 38;
				case "제주특별자치도" :
					areaCode.value = 39;
			}
			
			// 검색 위치로 Map 변경
			geocoder.addressSearch(data.address, function(results, status) {
				if (status === daum.maps.services.Status.OK) {
					var result = results[0];
					var coords = new daum.maps.LatLng(result.y, result.x);
					document.getElementById("mapX").value = result.x
					document.getElementById("mapY").value = result.y
					map.setCenter(coords);
					marker.setPosition(coords);
				}
			});
        }
    }).open();
}