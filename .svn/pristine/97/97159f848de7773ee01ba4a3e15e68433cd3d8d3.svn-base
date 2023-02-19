$(function() {
	$(document).ready(function() {
		var url = window.location.pathname;
		
		// sectionTemplate에 클릭된 li tag css 적용
		if (url.includes("member"))
			$("#memberManageArea").attr("class", "list-group-item list-group-item-action list-group-item-dark");
		else if (url.includes("notice"))
			$("#noticeManageArea").attr("class", "list-group-item list-group-item-action list-group-item-dark");
		else if (url.includes("community"))
			$("#communityManageArea").attr("class", "list-group-item list-group-item-action list-group-item-dark");
		else if (url.includes('inquiry'))
			$("#inquiryManageArea").attr("class", "list-group-item list-group-item-action list-group-item-dark");
		else if (url.includes('data') || url.includes("facility"))
			$("#dataManageArea").attr("class", "list-group-item list-group-item-action list-group-item-dark");
	});
	
	// 회원관리 클릭시
	$("#memberManageArea").on("click", function() {
		location.href = "/admin/memberManage";
	});
	
	// 공지사항 관리 클릭시
	$("#noticeManageArea").on("click", function() {
		location.href = "/admin/noticeManage";
	});
	
	// 커뮤니티 관리 클릭시
	$("#communityManageArea").on("click", function() {
		location.href = "/admin/communityManage";
	});
	
	// 문의내역 관리 클릭시
	$("#inquiryManageArea").on("click", function() {
		location.href = "/admin/inquiryManage";
	});
	
	// 데이터관리 클릭시
	$("#dataManageArea").on("click", function() {
		location.href = "/admin/dataManage";
	});
	
	// 로그아웃 클릭시
	$("#logoutBtn").on("click", function() {
		location.href = "/admin/logout"
	});
	
	// 로고 클릭시
	$("#logo").on("click", function() {
		location.href = "/admin/noticeManage";
	});
});