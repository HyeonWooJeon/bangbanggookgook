package com.care.KorTravel.service;


public interface IMailService {
	
	public void sendMail(String to, String subject, String content);
	
	public int checkEmail(String email);
	
	public String findIdByEmail(String email1);

}
