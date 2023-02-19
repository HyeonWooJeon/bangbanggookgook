package com.care.KorTravel.adminService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.KorTravel.adminDAO.CSDAO;
import com.care.KorTravel.adminDAO.NoticeManageDAO;
import com.care.KorTravel.dto.InquiryDTO;
import com.care.KorTravel.dto.NoticeDTO;

@Service
public class InquiryManageServiceImpl implements InquiryManageService{

	@Autowired private CSDAO dao;

	// 전체 문의사항 목록 가져오기
	@Override
	public ArrayList<InquiryDTO> getList(int dataViewCount, String index, String options, String searchText) {
		int cursor_MIN, cursor_MAX;
		
		int idx = Integer.parseInt(index);
		
		int dataCount;
		System.out.println("서비스\noptions : " + options + "\nsearchText : " + searchText);
		if (options == null || options.equals("") && searchText == null || searchText.equals(""))
			dataCount = getDataCount();
		else
			dataCount = getDataCount(options, searchText);
		
		cursor_MAX = dataCount - ((idx - 1) * dataViewCount);
		cursor_MIN = cursor_MAX - dataViewCount;
		if (cursor_MIN < 0)
			cursor_MIN = 0;
		
//		System.out.println("max : " + cursor_MAX);
//		System.out.println("min : " + cursor_MIN);
//		System.out.println("options : " + options);
//		System.out.println("searchText : " + searchText);
		return dao.getList(cursor_MIN, cursor_MAX, options, searchText);
	}

	// 특정 문의사항 클릭시
	@Override
	public InquiryDTO getInquiryContent(String num) { return dao.getInquiryContent(Integer.parseInt(num)); }
	
	public int getDataCount() {
		try { return (int)dao.getDataCount("", ""); } 
		catch (Exception e) { return 0; }
	}
	
	public int getDataCount(String options, String searchText) {
		Object tmp = dao.getDataCount(options, searchText);
		try { return (int)tmp; } 
		catch (Exception e) { return 0; }
	}
	
	// 문의내역 삭제
	@Override
	public void delete(String num) { dao.delete(num); }
	
	// 문의 답변
	@Override
	public void answerRegist(String answer, String num) { dao.answerRegist(answer, num); }

	// 문의 수정
	@Override
	public void update(String num, String answer) { dao.update(num, answer); }
}
