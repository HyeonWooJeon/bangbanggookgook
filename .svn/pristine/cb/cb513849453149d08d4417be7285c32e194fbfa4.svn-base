package com.care.KorTravel.adminDAO;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.care.KorTravel.adminService.CommunityManageService;
import com.care.KorTravel.dto.CommunityDTO;

@Mapper
public interface CommunityManageDAO {
	
	public void regist(CommunityDTO community);
	public ArrayList<CommunityDTO> getList(int cursor_MIN, int cursor_MAX, String options, String searchText);
	public Object getDataCount(String options, String searchText);
	public void delete(String num);
	public CommunityDTO getCommunityContent(int num);
	public void update(String communityTitle, String communityContent, String num);
}