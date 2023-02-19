var phone, gender, addr1, addr2;

$(function() {
	// 수정버튼
	$("#updateBtn").on("click", function() {
		
		
		// 수정 가능한 상태(readOnly)로 변경
		// 아이디, 이메일 : 수정불가
		document.getElementById("phone").readOnly = false;
		document.getElementById("gender").readOnly = false;
		document.getElementById("zipcode").readOnly = false;
		document.getElementById("addr1").readOnly = false;
		document.getElementById("addr2").readOnly = false;
		document.getElementById("zipcodeBtn").style.display = "inline-block";
		
		// 버튼변경
		document.getElementById("updateBtn").style.display = "none";
		document.getElementById("memberListBtn").style.display = "none";
		$("#saveBtn").attr("class", "btn btn-secondary visible");
		$("#cancelBtn").attr("class", "btn btn-secondary visible");
		$("#passwordUpdateBtn").attr("class", "btn btn-secondary visible");
		$("#informLabel").attr("class", "visible");
	});
	
	// 목록버튼
	$("#memberListBtn").on("click", function() {
		location.href = "/admin/memberManage";
	})
	
	// 저장버튼
	$("#saveBtn").on("click", function() {
		// 전화번호, 성별, 우편번호, 주소, 상세주소
		phone = document.getElementById("phone").value;
		gender = document.getElementById("gender").value;
		addr1 = document.getElementById("addr1").value;
		addr2 = document.getElementById("addr2").value;
		
		document.getElementById("memberUpdateForm").action = "/admin/memberUpdate";
		document.getElementById("memberUpdateForm").submit();
	});
	
	// 취소버튼
	$("#cancelBtn").on("click", function() {
		location.href = "/admin/memberManage";
	});
	
	// 비밀번호변경 버튼
	$("#passwordUpdateBtn").on("click", function() {
		if (confirm("회원의 기존 비밀번호가 임시 비밀번호로 변경됩니다. 해당 회원이 비밀번호를 분실한 경우에 사용하세요.")) {
			var id = document.getElementById("id").value;
			var email = document.getElementById("email").value;
			location.href = "/admin/memberPasswordUpdate?id=" + id + "&email=" + email;
		}
	});
});

function postCodeOpen() {
    new daum.Postcode({
        oncomplete: function(data) {
			document.getElementById("zipcode").value = data.zonecode;
			if (data.userSelectedType == "R")
				document.getElementById("addr1").value = data.address;
			else if (data.userSelectedType == "J")
				document.getElementById("addr2").value = data.jibunAddress;
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
		} 
   }).open();
}