package com.care.KorTravel.adminService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.KorTravel.adminDAO.CommunityManageDAO;
import com.care.KorTravel.dto.CommunityDTO;


@Service
public class CommunityManageServiceImpl implements CommunityManageService{

	@Autowired private CommunityManageDAO communityDao;

	// 게시판 공지등록
	@Override
	public void regist(CommunityDTO community) { communityDao.regist(community); }

	// 전체 게시글 목록 가져오기
	@Override
	public ArrayList<CommunityDTO> getList(int dataViewCount, String index, String options, String searchText) {
		int cursor_MIN, cursor_MAX;
		
		int idx = Integer.parseInt(index);
		
		int dataCount;
		if (options == null || options.equals("") && searchText == null || searchText.equals(""))
			dataCount = getDataCount();
		else {
			dataCount = getDataCount(options, searchText);
		}
		
		cursor_MAX = dataCount - ((idx - 1) * dataViewCount);
		cursor_MIN = cursor_MAX - dataViewCount;
		if (cursor_MIN < 0)
			cursor_MIN = 0;
		
		return communityDao.getList(cursor_MIN, cursor_MAX, options, searchText);
	}

	// 특정 게시글 클릭시
	@Override
	public CommunityDTO getCommunityContent(String num) { 
		return communityDao.getCommunityContent(Integer.parseInt(num)); 
	}
	
	public int getDataCount() {
		try { return (int)communityDao.getDataCount("", ""); } 
		catch (Exception e) { return 0; }
	}
	
	public int getDataCount(String options, String searchText) {
		Object tmp = communityDao.getDataCount(options, searchText);
		
		try { return (int)tmp;} 
		catch (Exception e) { return 0; }
	}

	// 게시글 업데이트
	// - 관리자는 별도 게시글 업데이트 진행x

	// 게시글 삭제
	public void delete(String num) { communityDao.delete(num); }
}
