var xmlReq;

$(function(){
	// 관광지 데이터 가져오기
	$("#culture").on("click", function() {
		$(".modal-overlayWrapper").css("display", "inline-block");
		console.log("동작")
		getData("A02");
	});
	
	// 음식점 데이터 가져오기
	$("#food").on("click", function() {
		$(".modal-overlayWrapper").css("display", "block");
		getData("A05");
	});
	
	// 숙박시설 데이터 가져오기
	$("#lodge").on("click", function() {
		$(".modal-overlayWrapper").css("display", "block");
		getData("B02");
	});
	
	function getData(cat1) {
		console.log(cat1);
		xmlReq = new XMLHttpRequest();
		xmlReq.onreadystatechange = result;
		xmlReq.open("POST", "/getData");
		xmlReq.send(cat1);
	}

	function result() {
		if (xmlReq.readyState == 4 && xmlReq.status == 200) {
			$("#modal-overlayWrapper").css("display", "none");
		}
	}

});