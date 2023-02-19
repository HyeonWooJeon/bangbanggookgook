package com.care.KorTravel.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.care.KorTravel.dao.MemberDAO;



@Service
public class MailServiceImpl implements IMailService{

	@Autowired JavaMailSender mailSender;
	@Autowired MemberDAO memberDao;
	@Override
	public void sendMail(String to, String subject, String content) {
		
			MimeMessage message = mailSender.createMimeMessage();

			try {
				
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setSubject(subject); // 이메일의 제목
				messageHelper.setText(content, true);// 이메일의 본문
				messageHelper.setTo(to); // 수신자
				messageHelper.addInline("image2", new ClassPathResource("static/image/logologo.png"));
				messageHelper.addInline("image1", new ClassPathResource("static/mainImages/image-1.png"));
				mailSender.send(message);
				
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
		}
	@Override
	public int checkEmail(String email) {
		int result = memberDao.checkEmail(email);
		return result;
	}

	@Override
	public String findIdByEmail(String email1) {
		String id = memberDao.findIdByEmail(email1);
		return id;
	}
		
	}
