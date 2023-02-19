package com.care.KorTravel.dao;

import org.apache.ibatis.annotations.Mapper;


import com.care.KorTravel.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	public MemberDTO userInfo(String id);

	public int isExistId(MemberDTO id);

	public void member_register(MemberDTO member);

	public MemberDTO loginCheck(MemberDTO member);

	public int checkEmail(String email);

	public void saveProfile(MemberDTO user);

	public int edit_Pw(MemberDTO member);

	public MemberDTO showImg(String id);

	public int userUpdate(MemberDTO member);
	
	public void userDelete(String id);

	public String getLastAccess(String id);
	public MemberDTO getLogin(String id);

	public void lastAccess(String nowdate, String nowip, String nowcode, String nowcountry, String id);

	public MemberDTO userPassword(String id);

	public String findIdByEmail(String email1);

	public String getIp(String id);

	public String getCode(String id);

	public String getCountry(String id);
	
	public String getIpAddress(String id);

	
}
