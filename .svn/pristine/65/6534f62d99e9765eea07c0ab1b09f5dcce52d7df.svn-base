package com.care.KorTravel.adminService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.KorTravel.adminDAO.AdminLoginDAO;
import com.care.KorTravel.dto.MemberDTO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired private AdminLoginDAO dao;
	@Autowired HttpSession session;
	
	@Override
	public String login(MemberDTO member) {
		String verifyPw = dao.login(member.getId());
		
		if (verifyPw == null)
			return "거부";
		
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		if (!pwEncoder.matches(member.getPw(), verifyPw))
			return "거부";
		
		session.setAttribute("verifyAdmin", 'y');
		return "허용";
	}
	
	
}
