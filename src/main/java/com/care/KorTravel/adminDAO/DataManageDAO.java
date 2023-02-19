package com.care.KorTravel.adminDAO;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.care.KorTravel.dto.FacilityDTO;

@Mapper
public interface DataManageDAO {

	public String createContentId();
	public void registFacility(FacilityDTO facility);
	public ArrayList<FacilityDTO> getList(int cursor_MIN, int cursor_MAX, String options, String searchText);
	public Object getDataCount(String options, String searchText);
	public void recommendReg(String contentId);
	public void recommendReset(String contentId);
	public FacilityDTO getFacilityDetail(String contentId);
	public FacilityDTO getImagePath(String contentId);
	public void updateFacility(FacilityDTO facility);
	public void deleteFacility(String contentId);
	public void restoreFacility(String contentId);
}
