$(function() {
	// 목록버튼 클릭
	$("#noticeList").on("click", function() {
		location.href = "/admin/noticeManage";
	});
	
	// 저장 클릭시
	$("#noticeSave").on("click", function() {
		var urlParams = new URL(location.href).searchParams;
		var num = urlParams.get("num");
		 
		document.getElementById("noticeUpdateForm").action = "/admin/noticeUpdate?num=" + num;
		document.getElementById("noticeUpdateForm").submit();
	});

	// 취소버튼 이벤트
	$("#cancel").on("click", function() {
		location.href = "/admin/noticeManage";
	});
});

// 수정 로직
var xmlReq;

function noticeUpdates(num) {
	// readonly 속성 변경
	document.getElementById("noticeTitleInputBox").readOnly = false;
	document.getElementById("noticeContent").readOnly = false;

	// 작성일자 숨기기
	document.getElementById("noticeWriteDate1").style.display = "none";
	document.getElementById("noticeWriteDate2").style.display = "none";
	
	// 제목 크기 조정
	document.getElementById("noticeTitle").style.width = "4%";

	// 제목입력 크기 조절
//	document.getElementById("noticeTitle").style.width = "80%";

	// 테이블 하단 버튼변경
	document.getElementById("noticeList").style.display = "none";
	document.getElementById("noticeUpdate").style.display = "none";
	document.getElementById("noticeDelete").style.display = "none";
	document.getElementById("noticeSave").style.display = "inline-block";
	document.getElementById("cancel").style.display = "inline-block";

//	// 저장, 취소버튼 Event 설정
//	$("#noticeSave").on("click", function() {
//		var title = document.getElementById("noticeTitleInputBox").value;
//		var content = document.getElementById("noticeContent").value;
//
//		if (title == null || title == "") {
//			alert("제목을 입력하세요.");
//			return;
//		} else if (content == null || title == "") {
//			alert("내용을 입력하세요.");
//			return;
//		}
//
//		xmlReq = new XMLHttpRequest();
//		xmlReq.onreadystatechange = noticeUpdate;
//		xmlReq.open("POST", "/noticeUpdate");
//		xmlReq.send(title + "," + content + "," + num);
//	});
//	
//	function noticeUpdate() {
//		if (xmlReq.readyState == 4 && xmlReq.status == 200) {
//			location.href = "/admin/noticeManage";
//			alert("수정되었습니다.");
//		}
//	}
}

// 삭제버튼 클릭
function noticeDeletes(num) {
	if (confirm("삭제하시겠습니까?"))
		location.href = "/admin/delete?num=" + num;
		
	return;
}

function fileDownload(obj) {
	var num = document.getElementById("num").value;
	location.href = "/admin/noticeFileDownload?num=" + num;
}
