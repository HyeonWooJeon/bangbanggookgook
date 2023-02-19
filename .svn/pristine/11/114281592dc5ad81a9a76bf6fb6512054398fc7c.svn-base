package com.care.KorTravel.adminService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.KorTravel.adminDAO.NoticeManageDAO;
import com.care.KorTravel.dto.NoticeDTO;

@Service
public class NoticeManageServiceImpl implements NoticeManageService{

	@Autowired private NoticeManageDAO noticeDao;

	// 공지등록
	@Override
	public void regist(NoticeDTO notice) { noticeDao.regist(notice); }

	// 전체 공지사항 목록 가져오기
	@Override
	public ArrayList<NoticeDTO> getList(int dataViewCount, String index, String options, String searchText) {
		int cursor_MIN, cursor_MAX;
		
		int idx = Integer.parseInt(index);
		
		int dataCount;
		if (options == null || options.equals("") && searchText == null || searchText.equals(""))
			dataCount = getDataCount();
		else
			dataCount = getDataCount(options, searchText);
		
		cursor_MAX = dataCount - ((idx - 1) * dataViewCount);
		cursor_MIN = cursor_MAX - dataViewCount;
		if (cursor_MIN < 0)
			cursor_MIN = 0;
		
		return noticeDao.getList(cursor_MIN, cursor_MAX, options, searchText);
	}

	// 특정 공지사항 클릭시
	@Override
	public NoticeDTO getNoticeContent(String num) { return noticeDao.getNoticeContent(Integer.parseInt(num)); }
	
	public int getDataCount() {
		try { return (int)noticeDao.getDataCount("", ""); } 
		catch (Exception e) { return 0; }
	}
	
	public int getDataCount(String options, String searchText) {
		Object tmp = noticeDao.getDataCount(options, searchText);
		
		try { return (int)tmp; } 
		catch (Exception e) { return 0; }
	}

	// 공지 업데이트
	@Override
	public void update(String noticeTitle, String noticeContent, String num) { noticeDao.update(noticeTitle, noticeContent, num); }

	// 공지 삭제
	@Override
	public void delete(String num) { noticeDao.delete(num); }

	// 시퀀스 MaxValue 받기
	@Override
	public int getNumLastVal() { return noticeDao.getNumLastVal(); }

	// getFileName
	@Override
	public String getFileName(String num) { return noticeDao.getFileName(num); }
}
