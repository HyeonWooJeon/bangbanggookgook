var xmlReq;

$(function() {
	$(document).ready(function() {

		$('.field').on('focus', function() {
			$('body').addClass('is-focus');
		});

		$('.field').on('blur', function() {
			$('body').removeClass('is-focus is-type');
		});

		$('.field').on('keydown', function(event) {
			$('body').addClass('is-type');
			if ((event.which === 8) && $(this).val() === '') {
				$('body').removeClass('is-type');
			}
		});
		
		// 일정 저장하기 클릭시
		$("#RPBtn").on("click", function() {
			$(".modal-overlay").css("display", "block");
		});
			
		// 일정 저장하기 -> 취소 클릭시
		$("#cancel").on("click", function() {
			$(".modal-overlay").css("display", "none");
		});
		
		// 일정 불러오기 -> x 클릭
		$("#xx1").on("click", function() {
			$(".modal-overlay").css("display", "none");
		});
		
		// 일정 불러오기 클릭시
		$("#GCBtn").on("click", function() {
			$(".modal-overlay2").css("display", "block");
		});
		
		// 일정 저장하기 -> 취소 클릭시
		$("#cancel2").on("click", function() {
			$(".modal-overlay2").css("display", "none");
		});
		
		// 일정 저장하기 -> x 클릭 
		$("#xx").on("click", function() {
			$(".modal-overlay2").css("display", "none");
		});
		
		$("#save1").on("click", function() {
			$("#calendarSubject").css("display", "inline-block");
			$("#save2").css("display", "inline-block");
			
			$("#save1").css("display", "none");
			$("#update").css("display", "none");
		});
		
		$("#update").on("click", function() {
			$("#save1").css("display", "none");
			$("#update").css("display", "none");
			
			$("#updateInfoText").css("display", "inline-block")
			$("#updateSelectBox").css("display", "inline-block");
			$("#updateBtn").css("display", "inline-block");
		});
	});
	
});

function update() {
	
}

// 로고 클릭시
function logoCheck(e) {
	if (confirm("일정을 저장하지 않고 나가시면 작업을 잃게됩니다. 나가시겠습니까?"))
		location.href = "/main";
}

//$(function() {
//            //모든 datepicker에 대한 공통 옵션 설정
//            $.datepicker.setDefaults({
//                dateFormat: 'yy.mm.dd' //Input Display Format 변경
//                ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
//                ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
//                ,changeYear: true //콤보박스에서 년 선택 가능
//                ,changeMonth: true //콤보박스에서 월 선택 가능                
//                // ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
//                // ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
//                // ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
//                // ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
//                ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
//                ,showAnim: "slide" //애니메이션을 적용한다.
//                ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
//                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
//                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
//                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
//                ,minDate: "D" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
//                ,maxDate: "+1Y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
//                ,autoclose: true //사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션 
//            });
// 
//            //input을 datepicker로 선언
//            $("#datepicker").datepicker();                    
//            $("#datepicker2").datepicker();
//            
//            //From의 초기값을 오늘 날짜로 설정
//            $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
//            //To의 초기값을 내일로 설정
//            $('#datepicker2').datepicker('setDate', '+1D'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
// });



// X 클릭시