$(function() {
	$("#options").change(function() {
		if ($("#options").val() == '답변미완료') {
			document.getElementById("searchText").value = "";
			document.getElementById("searchText").readOnly = "false";
		}
	});
	
	$("#searchBtn").on("click", function() {
		var option = document.getElementById("options").value;
		var searchText = document.getElementById("searchText").value;
		
		if (option == '답변미완료') {
			location.href = "/admin/inquiryManage?options=" + option + "&searchText=" + searchText;
			return;
		}
		else if (option == null || option == "") {
			alert("검색 카테고리를 선택하세요.");
			return;
		} else if (searchText == null || searchText == "") {
			alert("검색어를 입력하세요.");
			return;
		} 
		
		location.href = "/admin/inquiryManage?options=" + option + "&searchText=" + searchText;
	});
});

function inquiryDetail(num) {
	location.href = "/admin/inquiryDetail?num=" + num;
}

function tableDisplayByIndex(index, options, searchText, currentPage) {
	location.href = "/admin/inquiryManage?index=" + index + "&options=" + options + "&searchText=" + searchText + "&currentPage=" + currentPage; 
}

function prev(index, currentPage) {
	if (currentPage == 0)
		return;
	else if (currentPage == "")
		currentPage = 0;
		
	if (index == "")
		index = 1;
	else
		index = parseInt(index);
		
	location.href = "/admin/inquiryManage?index=" + (parseInt(currentPage - 1) * 4 + 1) + "&currentPage=" + (parseInt(currentPage) - 1);
}

function next(currentPage, maxPage, index) {
	if (currentPage == (maxPage - 1))
		return;
		
	if (currentPage == "")
		currentPage = 0;
		
	if (index == "")
		index = 1;
	else
		index = parseInt(index);
	
	location.href = "/admin/inquiryManage?index=" + (parseInt(currentPage + 1) * 4 + 1) + "&currentPage=" + (parseInt(currentPage) + 1);
}
