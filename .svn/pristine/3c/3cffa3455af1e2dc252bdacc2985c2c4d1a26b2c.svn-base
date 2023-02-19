var req;
function printMsg1(){
	if(req.readyState==4 && req.status==200){
		if(req.responseText=="인증되었습니다"){
			alert(req.responseText);
			location.href="setting_Pw";
			}
		else{
			alert(req.responseText);
		}		
	}
}

function sendAuth2(){

	req = new XMLHttpRequest();
	req.onreadystatechange = printMsg1;
	req.open('post', 'sendEmail');
	req.send(document.getElementById('email').value);
}

function checkAuth(){
	req = new XMLHttpRequest();
	req.onreadystatechange = printMsg1;
	req.open('post', 'checkAuth');
	req.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
	var number = document.getElementById('member_email_confirm').value;
	var data = {authNumber:number};
	data = JSON.stringify(data);
	req.send(data);

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
