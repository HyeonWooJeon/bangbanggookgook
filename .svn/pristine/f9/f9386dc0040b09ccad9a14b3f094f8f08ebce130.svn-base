$(function() {
	// 목록 클릭시
	$("#inquiryList").on("click", function() {
		location.href = "/admin/inquiryManage";
	});
	
	// 답변 클릭시
	$("#answer").on("click", function() {
		location.href = "/admin/inquiryAnswer?num=" + document.getElementById("num").value;
	});
	
	// 수정 클릭시
	$("#update").on("click", function() {
		$("#inquiryContent_answer").removeAttr("readOnly");
		
		$("#update").css("display", "none");
		$("#updateSave").css("display", "inline-block");
	});
});

// 삭제 클릭시
function inquiryDelete(num) {
	if (confirm("삭제하시겠습니까?")) {
		location.href = "/admin/inquiryDelete?num=" + num;
	}
}

// 저장 클릭시
function answerUpdate() {
	var searchParam = new URL(location.href).searchParams; 
	var answer = document.getElementById("inquiryContent_answer").value;
	var num =  searchParam.get("num");
	
	location.href = "/admin/inquiryUpdate?num=" + num + "&answer=" + answer;
}