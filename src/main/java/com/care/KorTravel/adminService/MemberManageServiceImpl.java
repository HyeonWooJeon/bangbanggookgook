package com.care.KorTravel.adminService;

import java.util.ArrayList;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.KorTravel.adminDAO.MemberManageDAO;
import com.care.KorTravel.adminDAO.NoticeManageDAO;
import com.care.KorTravel.dto.MemberDTO;
import com.care.KorTravel.dto.NoticeDTO;

@Service
public class MemberManageServiceImpl implements MemberManageService {

	@Autowired private MemberManageDAO memberDao;
	@Autowired private JavaMailSender ms;

	@Override
	public ArrayList<MemberDTO> getList(int dataViewCount, String index, String options, String searchText) {
		int cursor_MIN, cursor_MAX;
		
		int idx = Integer.parseInt(index);
//		System.out.println("index : " + index);
		
		int dataCount;
		if (options == null || options.equals("") && searchText == null || searchText.equals(""))
			dataCount = getDataCount();
		else
			dataCount = getDataCount(options, searchText);
		
		cursor_MAX = dataCount - ((idx - 1) * dataViewCount);
		cursor_MIN = cursor_MAX - dataViewCount;
		if (cursor_MIN <= 0)
			cursor_MIN = 1;
		
//		System.out.printf("options : %s\nsearchText : %s\ndataCount : %d\n", options, searchText, dataCount);
//		System.out.println("cursor_MIN : " + cursor_MIN + "\ncursor_MAX : " + cursor_MAX);
		return memberDao.getList(cursor_MIN, cursor_MAX, options, searchText);
	}
	
	@Override
	public MemberDTO getNoticeContent(String num) {
		return null;
	}
	
	public int getDataCount() {
		try { return (int)memberDao.getDataCount("", ""); } 
		catch (Exception e) { return 0; }
	}
	
	public int getDataCount(String options, String searchText) {
		try { return (int)memberDao.getDataCount(options, searchText); } 
		catch (Exception e) { return 0; }
	}
	
	@Override
	// 단일회원정보
	public MemberDTO getMemberDetail(String id) { return memberDao.getMemberDetail(id); }

	@Override
	// 회원정보 수정
	public void memberUpdate(MemberDTO member) { memberDao.memberUpdate(member); }

	@Override
	// 임시비밀번호 지급
	public void memberPasswordUpdate(String id, String email) {
		// 랜덤문자열 생성(임시 비밀번호)
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit,rightLimit + 1)
		  .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		  .limit(targetStringLength)
		  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		  .toString();

		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPw(pwEncoder.encode(generatedString));
		
		// 임시 비밀번호 메일전송
		sendMail(email, generatedString);
		
		memberDao.memberPasswordUpdate(member); 
	}

	public void sendMail(String email, String pw) {
		MimeMessage message = ms.createMimeMessage();
		try {
			
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject("[ 대한민국 방방곡곡에서 임시 비밀번호를 보내드립니다. ]");
			messageHelper.setText("임시 비밀번호는 " + pw + "입니다.", true);
			messageHelper.setTo(email);
//			messageHelper.addInline("image2", new ClassPathResource("static/image/logologo.png"));
//			messageHelper.addInline("image1", new ClassPathResource("static/mainImages/image-1.png"));
			ms.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
