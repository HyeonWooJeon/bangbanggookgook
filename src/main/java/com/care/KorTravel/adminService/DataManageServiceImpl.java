package com.care.KorTravel.adminService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.KorTravel.adminDAO.DataManageDAO;
import com.care.KorTravel.dto.FacilityDTO;

@Service
public class DataManageServiceImpl implements DataManageService {

	@Autowired private DataManageDAO dao;
	
	// contentId중 가장 큰 수 + 1로 contentId 부여
	@Override
	public String createContentId() { return dao.createContentId(); }

	// 업체등록
	@Override
	public void registFacility(FacilityDTO facility) { dao.registFacility(facility); }

	// 전체/검색 업체목록 목록 가져오기
	@Override
	public ArrayList<FacilityDTO> getList(int dataViewCount, String index, String options, String searchText) {
		int cursor_MIN, cursor_MAX;
		
		int idx = Integer.parseInt(index);
		
		int dataCount;
//		System.out.println("서비스\noptions : " + options + "\nsearchText : " + searchText);
//		System.out.println(false && true);
		if ( (options == null || options.equals("")) && (searchText == null || searchText.equals("")) ) {
//			System.out.println("코드1");
			dataCount = getDataCount();
		}
		else {
//			System.out.println("코드2");
			dataCount = getDataCount(options, searchText);
		}
		
		System.out.println("dataCount : " + dataCount);
		cursor_MAX = dataCount - ((idx - 1) * dataViewCount);
		cursor_MIN = cursor_MAX - dataViewCount;
		if (cursor_MIN < 0)
			cursor_MIN = 0;
		
		System.out.println("dataCount : " + dataCount);
		System.out.println("max : " + cursor_MAX + "\nmin : " + cursor_MIN);
		return dao.getList(cursor_MIN, cursor_MAX, options, searchText);
	}
	
	public int getDataCount() {
		try { return (int)dao.getDataCount("", ""); } 
		catch (Exception e) { return 0; }
	}
	
	public int getDataCount(String options, String searchText) {
		Object tmp = dao.getDataCount(options, searchText);
		
		try { return (int)tmp; } 
		catch (Exception e) { return 0; }
	}
	
	// 추천하기 클릭시
	@Override
	public void recommendReg(String contentId) { dao.recommendReg(contentId); }

	// 추천해제 클릭시
	@Override
	public void recommendReset(String contentId) { dao.recommendReset(contentId); }

	// 업체 상세정보 수입
	@Override
	public FacilityDTO getFacilityDetail(String contentId) { return dao.getFacilityDetail(contentId); }

	// 업체 수정시 이미지 경로 불러오기
	// 기존 파일 삭제 후 재등록
	@Override
	public FacilityDTO getImagePath(String contentId) { return dao.getImagePath(contentId); }

	// 업체정보 수정
	@Override
	public void updateFacility(FacilityDTO facility) { dao.updateFacility(facility); }

	// 업체 삭제
	@Override
	public void deleteFacility(String contentId) { dao.deleteFacility(contentId); }

	// 업체 삭제->복구
	@Override
	public void restoreFacility(String contentId) { dao.restoreFacility(contentId); }
}
