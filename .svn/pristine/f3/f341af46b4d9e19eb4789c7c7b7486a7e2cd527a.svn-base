package com.care.KorTravel.adminDAO;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.care.KorTravel.dto.MemberDTO;
import com.care.KorTravel.dto.NoticeDTO;

@Mapper
public interface MemberManageDAO {

	public ArrayList<MemberDTO> getList(int cursor_MIN, int cursor_MAX, String options, String searchText);
	public NoticeDTO getMemberContent(int num);
	public Object getDataCount(String options, String searchText);
	public MemberDTO getMemberDetail(String id);
	public void memberUpdate(MemberDTO member);
	public void memberPasswordUpdate(MemberDTO member);
}
