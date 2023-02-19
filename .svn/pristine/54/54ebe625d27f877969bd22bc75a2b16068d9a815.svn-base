$(function() {
	$("#noticeList").on("click", function() {
		location.href = "/admin/noticeManage";
	});
	
});

function noticeRegist() {
	var title = document.getElementById("noticeTitle_write").value;
	var content = document.getElementById("noticeContent").value;
	
	if (title == "") {
		alert("제목을 입력하세요.");
		return;
	} else if (content == "") {
		alert("내용을 입력하세요.");
		return;
	}
	
	document.getElementById("noticeForm").submit();
}