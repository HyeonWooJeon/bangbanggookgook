package com.care.KorTravel.adminService;

import java.util.ArrayList;

import com.care.KorTravel.dto.MemberDTO;
import com.care.KorTravel.dto.NoticeDTO;

public interface MemberManageService {

	public MemberDTO getNoticeContent(String num);
	public ArrayList<MemberDTO> getList(int dataViewCount, String index, String options, String searchText);
	public MemberDTO getMemberDetail(String id);
	public void memberUpdate(MemberDTO member);
	public void memberPasswordUpdate(String id, String email);
}
