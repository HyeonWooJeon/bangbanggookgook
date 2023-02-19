package com.care.KorTravel.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.care.KorTravel.dao.MemberDAO;

@Service
public class CheckDoubleLoginService {
	
	@Autowired MemberDAO memberDao;
	@Autowired HttpServletRequest req;
	
	public String CheckDoubleLogin(String id) throws UnknownHostException {
		String ip = memberDao.getIpAddress(id);
		String[] ipList = ip.split(",");
		
		System.out.println("아이피리스트 : "+ipList[ipList.length-1]);
		String ipAddress=req.getRemoteAddr();
			if(ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
		     InetAddress inetAddress=InetAddress.getLocalHost();
		     ipAddress=inetAddress.getHostAddress();
		 }
			
		if(ipAddress.equals(ipList[ipList.length-1])==false) {
			return "다른 곳에서 로그인되었습니다";
		}
		else return "이상 무";
	}

}
