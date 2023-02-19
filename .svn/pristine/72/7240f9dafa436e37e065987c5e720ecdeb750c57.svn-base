	
	$(document).on('click', '#btnList', function(e){

		e.preventDefault();
		if(confirm('작성하던 내용이 사라집니다. 페이지를 벗어나시겠습니까?')==true){
		location.href="community";}
		else{return;}

	});
	var req;
	
	function save_proc(){
		var title = document.getElementById("title").value;
		
		var form = document.getElementById("form");
		
		if(title==""){
			alert('제목을 입력해주세요');return;
		}
		if(getEditordata()==""){
			alert('내용을 입력해주세요'); return;
		}
		form.action="community_write";
		form.submit();
		
	}
	

	function comment_reg(){
		var comment_form = document.getElementById("comment_form");
		var loginCheck = document.getElementById("loginCheck");
		var reContent = document.getElementById("reContent");
		if(loginCheck.value==null || loginCheck.value==""){
			alert('로그인 후 이용가능합니다.');
			return;
		}
		if(reContent.value==""){
			alert("내용을 입력하세요");
			return;
		}
		comment_form.action = "comment_regist";
		comment_form.submit();
	}
	
	function my_write_delete(num){
		if(!confirm("삭제하시겠습니까?")){
			return;
		}
		location.href="my_write_delete?num="+num;
	}
	

	function comment_delete(replyNo){
		if(!confirm("삭제하시겠습니까?")){
			return;
		}
		var form = document.form2;
	
	    form.action="ReplyDelete";
	    form.replyNo.value=replyNo;
	    form.submit();   
	}
	
	var updateReplyNo = updateReContent = null;
	
	function fn_replyUpdate(replyno){
	    var form = document.form2;
	    var reply = document.getElementById("reply"+replyno);
	    var replyDiv = document.getElementById("replyDiv");
	    replyDiv.style.display = "";
	   
	    if (updateReplyNo) {
	        document.body.appendChild(replyDiv);
	        var oldReplyno = document.getElementById("reply"+updateReplyNo);
	        oldReplyno.innerText = updateReContent;
	    }
	   
	    form.replyNo.value=replyno;
	    form.reContent.value = reply.innerText;
	    reply.innerText ="";
	    reply.appendChild(replyDiv);
	    updateReplyNo   = replyno;
	    updateReContent = form.reContent.value;
	    form.reContent.focus();
	}
	
	function fn_replyUpdateSave(){
	    var form = document.form2;
	    if (form.reContent.value=="") {
	        alert("글 내용을 입력해주세요.");
	        form.reContent.focus();
	        return;
	    }
	   
	    form.action="replyUpdate";
	    form.submit();   
	}
	
	function fn_replyUpdateCancel(){
	    var form = document.form2;
	    var replyDiv = document.getElementById("replyDiv");
	    document.body.appendChild(replyDiv);
	    replyDiv.style.display = "none";
	   
	    var oldReplyno = document.getElementById("reply"+updateReplyNo);
	    oldReplyno.innerText = updateReContent;
	    updateReplyNo = updateReContent = null;
	}
	
	function hideDiv(id){
    var div = document.getElementById(id);
    div.style.display = "none";
    document.body.appendChild(div);
}

	function fn_replyReply(replyNo){
	    var form = document.form3;
	    var reply = document.getElementById("reply"+replyNo);
	    var replyDia = document.getElementById("replyDialog");
	    replyDia.style.display = "";
	   
	    if (updateReplyNo) {
	        fn_replyUpdateCancel();
	    }
	   
	    form.reContent.value = "";
	    form.replyNo.value=replyNo;
	    reply.appendChild(replyDia);
	    form.rewriter.focus();
	}
	
	
	function fn_replyReplyCancel(){
	    hideDiv("replyDialog");
	}
	
	function fn_replyReplySave(){
	    var form = document.form3;
	   
	    if (form.reContent.value=="") {
	        alert("글 내용을 입력해주세요.");
	        form.reContent.focus();
	        return;
	    }
	   
	    form.action="replyReply";
	    form.submit();   
	}
	
	$("#file").on('change',function(){
	  var fileName = $("#file").val();
	  $(".upload-name").val(fileName);
	});
	
	
	


	