package com.care.KorTravel.adminService;

import java.util.ArrayList;

import com.care.KorTravel.dto.CommunityDTO;

public interface CommunityManageService {

	public void regist(CommunityDTO community);
	public CommunityDTO getCommunityContent(String num);
	public ArrayList<CommunityDTO> getList(int dataViewCount, String index, String options, String searchText);
	public void delete(String num);
}
