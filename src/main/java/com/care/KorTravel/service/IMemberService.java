
package com.care.KorTravel.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.care.KorTravel.dto.CalendarDTO;
import com.care.KorTravel.dto.MemberDTO;

public interface IMemberService {
	
	public MemberDTO userInfo(String id);

	public int login(MemberDTO id);
	
	public String member_register(MemberDTO member);
	
	public String loginCheck(MemberDTO member);
	
	public int edit_Pw(MemberDTO member);
	
	public void imgUpdate(String id, String profilePhoto);
	
	public void saveProfile(MemberDTO user);
	
	public String userUpdate(MemberDTO user);
	
	public boolean userDelete(MemberDTO check);
	
	public void lastAccess(String ip, String code, String country);
	
	public void getLogin(Model model,String id);
	
	public void myRouteDelete(String id);

	public boolean userUpdateCheck(MemberDTO check);
	
	public String getIPProc(String id);
	
	public ArrayList<CalendarDTO> getMyRouteDetail(String subject);
	
	public ArrayList<CalendarDTO> getMyRoute();

	public int routeSubjectUpdate(String subject, String memo, String preSubject);

	public String checkSubject(String subject);
}
