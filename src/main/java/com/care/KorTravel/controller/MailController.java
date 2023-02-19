package com.care.KorTravel.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.care.KorTravel.service.MailForm;
import com.care.KorTravel.service.MailServiceImpl;

@Controller
public class MailController {
	@Autowired private MailServiceImpl mailService;
	@Autowired private HttpSession session;
	
	@ResponseBody
	@PostMapping(value="sendAuth", produces = "application/json; charset=UTF-8")
	public String sendAuth(@RequestBody(required = false) String email1) {
		if(email1 != null) {
			if(mailService.checkEmail(email1)==0) {
				int random = (int)(Math.random()*100000)+100000;
				String number =Integer.toString(random);
				session.setAttribute("authNumber", number);
				
				System.out.println("인증번호 : 	" + number);
				String mailForm = new MailForm().mailForm(number);
				
				mailService.sendMail(email1, "[대한민국 방방곡곡에서 보낸 인증번호입니다]",mailForm);
				
				return "기입하신 이메일로 인증번호가 전송되었습니다";
				
			}
			else { return "이미 가입된 이메일이 존재합니다";}
		}
		else {return "이메일을 입력하세요";}
	}
	

	@ResponseBody
	@PostMapping(value="checkAuth", produces = "application/json; charset=UTF-8")
	public String checkAuth(@RequestBody(required = false) Map<String,String> map) {
		System.out.println("고객이 입력한 인증 번호 : " + map.get("authNumber"));
		
		// sendAuth 메소드에서 생성한 인증번호와 고객이 입력한 인증번호를 비교
		String sessionAuthNumber = (String)session.getAttribute("authNumber");
		String clientAuthNumber = map.get("authNumber");
		if(sessionAuthNumber == null ) {
			return "인증 번호를 생성하세요.";
		}
		if(clientAuthNumber.isEmpty()) {
			return "인증 번호를 입력하세요.";
		}
		
		session.setAttribute("authStatus", false);
		if(sessionAuthNumber.equals(clientAuthNumber)) {
			session.setAttribute("authStatus", true);
			return "인증되었습니다";
		}
		
		return "인증번호가 맞지 않습니다";
	}


		@ResponseBody
		@PostMapping(value="sendEmail", produces = "application/json; charset=UTF-8")
		public String sendEmail(@RequestBody(required=false) String email) {
			
			if(email != null) {
				int result = mailService.checkEmail(email);
				if(result==1) {
					int random = (int)(Math.random()*100000)+100000;
					String number =Integer.toString(random);
					session.setAttribute("authNumber", number);
					session.setAttribute("email", email);
					System.out.println("인증번호 : 	" + number);
					String id = mailService.findIdByEmail(email);
					String mailForm = new MailForm().mailForm2(number,id);
					
					mailService.sendMail(email, "[대한민국 방방곡곡에서 보낸 인증번호입니다]",mailForm);
					
					return "기입하신 이메일로 인증번호가 전송되었습니다";
					
				}
				else return "해당 이메일로 가입된 정보가 없습니다";
			}
			else {return "이메일을 입력하세요";}
		}
}
