
function daumPost(){
	
    new daum.Postcode({
        oncomplete: function(data) {
   			var addr = "";
   			// R == 도로명 주소, J == 지번 주소
   			if(data.userSelectedType == "R")
   				addr = data.roadAddress;
   			else{
   				addr = data.jibunAddress;
   			}
   			document.getElementById('zipcode').value= data.zonecode; // 우편번호
   			document.getElementById('addr1').value = addr;
   			document.getElementById('addr2').focus();
        }
    }).open();
    
}

var req;

function id_check(){
	var letter = /^[a-zA-Z0-9-@_/,.][a-zA-Z0-9-@_/,. ]*$/;
	var id = document.getElementById('id').value;
	if(id==null || id==''){
		alert('아이디를 입력하세요');return;
	}
	if(!letter.test(id)){
		alert('조건에 맞게 아이디를 입력하세요'); return;
	}
	req = new XMLHttpRequest();
	req.onreadystatechange = printMsg;
	req.open('post', 'isExistId');
	req.send(document.getElementById('id').value);
}

function printMsg(){
	if(req.readyState==4 && req.status==200){
	alert(req.responseText);}
	
}

function sendAuthemail(){

	req = new XMLHttpRequest();
	req.onreadystatechange = printMsg;
	req.open('post', 'sendAuth');
	req.send(document.getElementById('email1').value);
}

function checkAuthemail(){
	req = new XMLHttpRequest();
	req.onreadystatechange = printMsg;
	req.open('post', 'checkAuth');
	req.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
	var number = document.getElementById('member_email_confirm1').value;
	var data = {authNumber:number};
	data = JSON.stringify(data);
	req.send(data);

}



function idcheck(obj){
	
	var id_info = document.getElementById("id_info");
	var letter = /^[a-zA-Z0-9-@_/,.][a-zA-Z0-9-@_/,. ]*$/;
	if(obj.value==""){

		id_info.innerHTML = "필수 입력 항목입니다";
		id_info.style.color = "red";
		obj.style.outline = "0.5px solid red";
		
	}
	else if(!letter.test(obj.value)){
		id_info.innerHTML = "영문(대,소문자), 숫자,_만 사용가능합니다.";
		id_info.style.color = "red";
		
	}
	else{
		id_info.innerHTML = " ";
		obj.style.outline = "#999999";
	}
}

function pwcheck(obj){
	
	var pw_info = document.getElementById("pw_info");
	var letter = /^[a-zA-Z0-9-_!@#$%^&*]{8,16}$/;
	if(obj.value==""){

		pw_info.innerHTML = "필수 입력 항목입니다";
		pw_info.style.color = "red";
		obj.style.outline = "0.5px solid red";
		
	}
	else if(!letter.test(obj.value)){
		pw_info.innerHTML = "영문(대,소문자)와 숫자, _!@#$%^&*(8~16자)만 사용가능합니다.";
		pw_info.style.color = "red";
		obj.style.outline = "0.5px solid red";
		
	}
	else{
		pw_info.innerHTML = " ";
		obj.style.outline = "#999999";
	}
}

function pwrecheck(obj){
	
	var pwre_info = document.getElementById("pwre_info");
	var member_pw = document.getElementById("pw").value;
	if(obj.value==""){
		pwre_info.innerHTML = "필수 입력 항목입니다";
		pwre_info.style.color = "red";
		obj.style.outline = "0.5px solid red";
	}
	else if(obj.value!=member_pw){
		pwre_info.innerHTML = "비밀번호가 일치하지 않습니다.";
		pwre_info.style.color = "red";
		obj.style.outline = "0.5px solid red";
	}
	else{
		pwre_info.innerHTML = "일치합니다.";
		obj.style.outline = "#999999";
	}
}

function emailcheck(obj){
	var email_info = document.getElementById("email_info");
	var letter = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if(obj.value==""){
		email_info.innerHTML = "필수 입력 항목입니다";
		email_info.style.color = "red";
		obj.style.outline = "0.5px solid red";
	}
	else if(!letter.test(obj.value)){
		email_info.innerHTML = "이메일 형태로 입력해주세요. 해당 이메일로 인증번호가 발송됩니다.";
		email_info.style.color = "red";
		obj.style.outline = "0.5px solid red";
	}
	else{
		email_info.innerHTML = " ";
		obj.style.outline = "#999999";
	}
}

function digitcheck(obj){
	
	var digit_Info = document.getElementById("digit_Info");
	
	if(obj.value==""){
		
		digit_Info.innerHTML = "필수 입력 항목입니다";
		digit_Info.style.color = "red";
		obj.style.outline = "0.5px solid red";
	}
	else if(obj.value.length<13){
		digit_Info.innerHTML = "유효한 전화번호를 입력하십시오.";
		digit_Info.style.color = "red";
		obj.style.outline = "0.5px solid red";
	}
	else{
		digit_Info.innerHTML = " ";
		obj.style.outline = "#999999";
	}
	
}



function upyeoncheck(obj){
	var city_info3 = document.getElementById("city_info3");
		if(obj.value==""){
		city_info3.innerHTML = "필수 입력 항목입니다";
		city_info3.style.color = "red";
		obj.style.outline = "0.5px solid red";
		
	}

	else{
		city_info3.innerHTML = " ";
		obj.style.outline = "#999999";
	}
}


const autoHyphen = (target) => {
		 target.value = target.value
		   .replace(/[^0-9]/g, '')
		  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
		}



function member_outcheck(){
	if(confirm('입력하던 정보가 사라집니다. 취소하시겠습니까?')){
		location.href='main';
	}
	else{
		return;
	}
}
function confirmText(){
	if(req.readyState==4 && req.status==200){
		if(req.responseText=="이미 등록되어 있는 아이디입니다"){
		alert(req.responseText);
		return;	
		}
	}
}



function member_allcheck(){

	
	
	var idletter = /^[a-zA-Z0-9-@_/,.][a-zA-Z0-9-@_/,. ]*$/;
	var pwletter = /^[a-zA-Z0-9-_!@#$%^&*]{8,16}$/;
	var emailletter = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	var digitletter = /^(?:(010-\d{4})|(01[1|6|7|8|9]-\d{3,4}))-(\d{4})$/;

	var member_id = document.getElementById("id");
	var member_pw = document.getElementById("pw");
	var member_repw = document.getElementById("member_repw");
	var member_email = document.getElementById("email1");
	var member_email_confirm = document.getElementById("member_email_confirm1");
	var member_digit = document.getElementById("phone");
	var member_gender1 = document.getElementById("gender1");
	var member_gender2 = document.getElementById("gender2");
	var member_gender3 = document.getElementById("gender3");
	
	var zipcode = document.getElementById("zipcode");
	var addr2 = document.getElementById("addr2");


		
	if(member_id.value==""){
		alert("필수 입력 항목이 누락되었습니다.");
		return;
	}

	
	if(!idletter.test(member_id.value)){
		alert("영문만 입력 가능합니다.");
		return;
	}
	if(member_id.value!=""){
		req = new XMLHttpRequest();
		req.open('post', 'isExistId');
		req.send(member_id.value);
		req.onreadystatechange=confirmText;
	}
		
	
	if(member_pw.value==""){
		alert("비밀번호를 입력하세요.");
		return;
	}

	if(!pwletter.test(member_pw.value)){
		alert('유효한 전화번호를 입력하세요.')
		return;
	}
	if(member_pw.value!=member_repw.value){
		alert("비밀번호를 다시 확인해주세요");
		return;
	}
	if(member_digit.value==""){
		alert("전화번호를 입력하세요.");
		return;
	}
	
	if(!digitletter.test(member_digit.value)){
		alert('유효한 전화번호를 입력하세요.')
		return;
	}
	if(member_email.value==""){
		alert("이메일을 입력하세요.");
		return;
	}
	if(!emailletter.test(member_email.value)){
		alert('유효한 이메일을 입력하세요.')
		return;
	}
	if(member_email_confirm.value==""){
		alert("인증번호를 입력하세요.");
		return;
	}

	if(member_gender1.value==""||member_gender2.value==""||member_gender3.value==""){
		alert("성별을 선택하세요.");
		return;
	}
	if(zipcode.value==""){
		alert("우편번호를 입력하세요.");
		return;
	}

	if(addr2.value==""){
		alert("상세정보를 입력하세요.");
		return;
	}


	else{
	var register_Form = document.getElementById("register_Form");
	register_Form.action ="member_register";
	register_Form.submit();
}
}

