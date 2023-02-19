function check(){
	var pw = document.getElementById("pw").value;
	var confirmPw = document.getElementById("confirmPw").value;
	var phone = document.getElementById("phone").value;
	var form = document.getElementById("form");
	var zipcode = document.getElementById("zonecode").value;
	var addr2 = document.getElementById("addr2").value;
	
	if(pw==null ||pw==""|| phone==null||phone==""||confirmPw==null||confirmPw==""){
		alert("전체 사항을 입력해주세요"); return;
	}
	if(pw!=confirmPw){
		alert("비밀번호가 일치하지 않습니다");
		return;
	}
	if(addr2==null){
		alert('상세주소를 입력해주십시오');
		return;
	}
	
	form.action = "userUpdate";
	form.submit();
}