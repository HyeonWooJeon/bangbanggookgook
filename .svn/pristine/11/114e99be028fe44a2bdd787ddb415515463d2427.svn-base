var req;

function login_check(){
	req = new XMLHttpRequest();
	req.onreadystatechange = printMsg;
	req.open('post', 'loginCheck');
	req.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
	var loginId = document.getElementById('loginId').value;
	var loginPw = document.getElementById('loginPw').value;
	var data = {id:loginId, pw:loginPw};
	data = JSON.stringify(data);
	req.send(data);
	
	}



function printMsg(){
	if(req.readyState==4 && req.status==200){
	var alert_info = document.getElementById("alert_info");
	if(req.responseText=="로그인 성공"){
		
		location.href="main";return;
	}

	alert_info.innerHTML=req.responseText;
	alert_info.style.color = "red";
	alert_info.style.fontSize = "6px";
	 
	}
	
}
	



