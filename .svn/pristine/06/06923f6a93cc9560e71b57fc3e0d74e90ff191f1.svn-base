$(function() {
	$("#cancelBtn").on("click", function() {
		location.href = "/admin/inquiryManage";
	});
});

function answerRegist() {
	var answer = document.getElementById("inquiryAnswerContent").value;
	var num = document.getElementById("inquiryNum").value;
	
	if (answer == "") {
		alert("내용을 작성해주세요.");
		return;
	}
	
	document.getElementById("inquiryForm").action = "/admin/inquiryAnswer?num=" + num 
	document.getElementById("inquiryForm").submit();
}