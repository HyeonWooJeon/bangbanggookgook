package com.care.KorTravel.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.KorTravel.dao.RouteDAO;
import com.care.KorTravel.dto.CalendarDTO;
import com.care.KorTravel.dto.FacilityDTO;

@Service
public class RouteServiceImpl implements IRouteService {

	@Autowired private RouteDAO dao;
	@Autowired private HttpSession session;
	
	@Override
	public ArrayList<FacilityDTO> getSearchResult(String searchText) { return dao.getSearchResult(searchText); }
	
	@Override
	public ArrayList<FacilityDTO> getRecommendFacilities() { return dao.getRecommendFacilities(); }

	@Override
	public String saveCalendar(ArrayList<CalendarDTO> saveCalendar) {
		String id = (String)session.getAttribute("id");
		
		// 제목 중복체크
		int	duplicateCheck = dao.subjectDuplicateCheck(saveCalendar.get(0).getSubject(), id);
		
		if (duplicateCheck != 0)
			return "중복";
		
		dao.saveCalendar(saveCalendar, id);
		return "성공";
	}
	
	@Override
	public ArrayList<CalendarDTO> getCalendar() {
		String id = (String)session.getAttribute("id"); 
		return dao.getCalendar(id);
	}
	
	// 일정만들기에서 선택된 제목의 일정 가져오기
	@Override
	public ArrayList<CalendarDTO> getSavedCalendar(String subject) {
		String id = (String)session.getAttribute("id");
		return dao.getSavedCalendar(id, subject);
	}	

	@Override
	public String getSpecPlace(HashMap<String, String> datas) {
		String neLat = datas.get("neLat"), 
			   neLng = datas.get("neLng"),
			   swLat = datas.get("swLat"),
			   swLng = datas.get("swLng");
		String cat = "";
//		switch(datas.get("cat")) {
//			case "관광지" :
//				cat = "A02";
//			case "음식점" : 
//				cat = "A05";
//			case "숙소" :
//				cat = "B02";
//			default :
//				break;
//		}
		System.out.println("datas.get('cat1') : " + datas.get("cat"));
		if (datas.get("cat").equals("관광지"))
			cat = "A02";
		else if (datas.get("cat").equals("음식점"))
			cat = "A05";
		else
			cat = "B02";
		
		System.out.println("cat : " + cat);
		
		ArrayList<FacilityDTO> allPlace = dao.getSpecPlace(neLat, neLng, swLat, swLng, cat);
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray();
		
		for (int cnt = 0; cnt < allPlace.size(); cnt++) {
			JSONObject tmp = new JSONObject();
			tmp.put("addr1", allPlace.get(cnt).getAddr1());
			tmp.put("addr2", allPlace.get(cnt).getAddr2());
//			tmp.put("areaCode", allPlace.get(cnt).getAreaCode());
//			tmp.put("cat1", allPlace.get(cnt).getCat1());
			tmp.put("contentId", allPlace.get(cnt).getContentId());
//			tmp.put("firstImage", allPlace.get(cnt).getFirstImage());
			tmp.put("firstImage2", allPlace.get(cnt).getFirstImage2());
			tmp.put("mapX", allPlace.get(cnt).getMapX());
			tmp.put("mapY", allPlace.get(cnt).getMapY());
			tmp.put("tel", allPlace.get(cnt).getTel());
			tmp.put("title", allPlace.get(cnt).getTitle());
			
			ja.add(tmp);
		}
		jo.put("items", ja);
		System.out.println("jo : " + jo);
		return jo.toJSONString(); 
	}
	
	// 일정 수정하기
	@Override
	public void updateCalendar(ArrayList<CalendarDTO> updateCalendar) {
		String id = updateCalendar.get(0).getId(),
			   subject = updateCalendar.get(0).getSubject();
					   
		dao.deleteSpecCalendar(id, subject);
		dao.updateCalendar(updateCalendar); 
	}

}
