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
	var member_pw = document.getElementById("new_Pw").value;
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

function submit(){
	var new_Pw =document.getElementById("new_Pw").value;
	var new_Pw_Confirm = document.getElementById("new_Pw_Confirm").value;
	var letter = /^[a-zA-Z0-9-_!@#$%^&*]{8,16}$/;
	
	if(new_Pw==""){
		alert('비밀번호를 입력해주십시오');
		return;
	}
	if(new_Pw_Confirm==""){
		alert('비밀번호 확인을 입력해주십시오');
		return;
	}
	if(!letter.test(new_Pw)){
		alert('조건에 맞는 비밀번호를 만들어주십시오');
		return;
	}
	if(new_Pw!=new_Pw_Confirm){
		alert("비밀번호가 일치하지 않습니다");
		return;
	}
	var f = document.getElementById("form");
	f.action = "edit_Pw";
	f.submit();
	
}

function reset(){
	if(confirm('비밀번호 재설정을 하지 않고 페이지를 벗어나시겠습니까? 작성중이던 내용은 사라집니다')==true){
		location.href="main";
	}
	else return;
}