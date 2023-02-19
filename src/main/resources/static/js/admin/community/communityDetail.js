$(function() {
	// 목록버튼 클릭
	$("#communityList").on("click", function() {
		location.href = "/admin/communityManage"
	});
});

function communityDelete(num) {
	if(confirm("삭제하시겠습니까?"))
		location.href = "/admin/communityDelete?num=" + num;
}