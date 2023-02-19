$(function() {
	$("#searchBtn").on("click", function() {
		var options = document.getElementById("options").value;
		var searchText = document.getElementById("searchText").value;
		
		console.log("options : " + options);
		
		if (options == null || options == "") {
			alert("검색 카테고리를 선택하세요.");
			return;
		} else if (searchText == null || searchText == "") {
			alert("검색어를 입력하세요.");
			return;
		}
		
		location.href = "/admin/communityManage?options=" + options + "&searchText=" + searchText;
	})
});

function communityDetail(num) {
	location.href = "/admin/communityDetail?num=" + num;
}

// 인덱스 세팅
function tableDisplayByIndex(index, options, searchText, currentPage) { 
	location.href = "/admin/communityManage?index=" + index + "&options=" + options + "&searchText=" + searchText + "&currentPage=" + currentPage; 
}

// 이전버튼 클릭시
function prev(index, currentPage) {
	if (currentPage == 0)
		return;
	else if (currentPage == "")
		currentPage = 0;
		
	if (index == "")
		index = 1;
	else
		index = parseInt(index);
		
	location.href = "/admin/communityManage?index=" + (parseInt(currentPage - 1) * 4 + 1) + "&currentPage=" + (parseInt(currentPage) - 1);
}


// 다음버튼 클릭시
function next(currentPage, maxPage, index) {
	if (currentPage == (maxPage - 1))
		return;
		
	if (currentPage == "")
		currentPage = 0;
		
	if (index == "")
		index = 1;
	else
		index = parseInt(index);
	
	location.href = "/admin/communityManage?index=" + (parseInt(currentPage + 1) * 4 + 1) + "&currentPage=" + (parseInt(currentPage) + 1);
}