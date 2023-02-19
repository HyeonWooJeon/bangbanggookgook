package com.care.KorTravel.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.KorTravel.dao.RouteDAO;
import com.care.KorTravel.dto.CalendarDTO;
import com.care.KorTravel.dto.FacilityDTO;
import com.care.KorTravel.service.RouteServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
public class RouteController {
	
	@Autowired RouteDAO dao;
	@Autowired private RouteServiceImpl svc;
	@Autowired private HttpSession session;
	
	@RequestMapping("route")
	public String route(Model model) {
		// 저장된 일정이 있는지 없는지만 확인하는 코드로 변경해야함.
		ArrayList<CalendarDTO> tmp = svc.getCalendar(); 
		model.addAttribute("calendar", tmp.size());
		
		ArrayList<String> subject = new ArrayList<>();
		
		if (tmp.size() != 0) {
			subject.add(tmp.get(0).getSubject());
			for (int cnt = 1; cnt < tmp.size(); cnt++) {
				if (tmp.get(cnt).getSubject().equals(tmp.get(cnt - 1).getSubject())) {
					continue;
				}
				
				subject.add(tmp.get(cnt).getSubject());
			}
		}
		model.addAttribute("subject", subject);
		return "route/route";
	}
	
//	@Autowired
//	private IRouteService routeService;
	
	@ResponseBody
	@PostMapping(value = "getSpecPlace", produces = "application/json; charset = UTF-8")
	public String getAllPlace(@RequestBody(required = false)HashMap<String, String>datas) {
		// neLat, neLng, swLat, swLng
		if (datas.get("cat") == null)
			return "x";
		
		return svc.getSpecPlace(datas);
	}
	
	
	@ResponseBody
	@PostMapping("route/getFood")
	public String getFood(Model model) {
		model.addAttribute("Food", dao.getFood());
		return "route/route";
	}

	// 우측 검색결과
	@ResponseBody
	@PostMapping(value = "route/searchInDate", produces = "text/html; charset = UTF-8")
	public String search(@RequestBody(required = false)String searchText) throws ParseException {
		ArrayList<FacilityDTO> returnData = svc.getSearchResult(searchText);
		
		JSONObject obj = new JSONObject();
		JSONArray ja = new JSONArray();
		
		for (int cnt = 0; cnt < returnData.size(); cnt++) {
			JSONObject tmp = new JSONObject();
			tmp.put("title", returnData.get(cnt).getTitle());
			tmp.put("addr1", returnData.get(cnt).getAddr1());
			tmp.put("addr2", returnData.get(cnt).getAddr2());
			tmp.put("tel", returnData.get(cnt).getTel());
			tmp.put("cat1", returnData.get(cnt).getCat1());
			tmp.put("mapX", returnData.get(cnt).getMapX());
			tmp.put("mapY", returnData.get(cnt).getMapY());
			tmp.put("firstImage2", returnData.get(cnt).getFirstImage2());
			tmp.put("contentId", returnData.get(cnt).getContentId());
			tmp.put("recommend", returnData.get(cnt).getRecommend());
			ja.add(tmp);
		}
		
		
		obj.put("items", ja);
		return obj.toJSONString();
	}
	
	// 추천장소 클릭시
	@ResponseBody
	@PostMapping(value = "route/recommendFacility", produces = "text/html; charset = UTF-8")
	public String setRecommendFacilities() {
		ArrayList<FacilityDTO> returnData = svc.getRecommendFacilities();

		JSONObject obj = new JSONObject();
		JSONArray ja = new JSONArray();

		for (int cnt = 0; cnt < returnData.size(); cnt++) {
			JSONObject tmp = new JSONObject();
			tmp.put("title", returnData.get(cnt).getTitle());
			tmp.put("addr1", returnData.get(cnt).getAddr1());
			tmp.put("addr2", returnData.get(cnt).getAddr2());
			tmp.put("tel", returnData.get(cnt).getTel());
			tmp.put("cat1", returnData.get(cnt).getCat1());
			tmp.put("mapX", returnData.get(cnt).getMapX());
			tmp.put("mapY", returnData.get(cnt).getMapY());
			tmp.put("firstImage2", returnData.get(cnt).getFirstImage2());
			tmp.put("contentId", returnData.get(cnt).getContentId());
			tmp.put("recommend", returnData.get(cnt).getRecommend());
			ja.add(tmp);
		}

		obj.put("items", ja);
		return obj.toString();
	}
	
	// 일정저장
	@ResponseBody
	@PostMapping(value = "saveCalendar", produces = "application/json; charset=UTF-8")
	public String saveCalendar(@RequestBody(required = false)String obj, Model model) throws ParseException {
		System.out.println("obj : " + obj);
		Gson gson = new Gson();
		JsonObject jo = gson.fromJson(obj, JsonObject.class);
		
		String subject = jo.get("subject").getAsString();
		String calendar_start = jo.get("calendar_start").getAsString();
		String calendar_end = jo.get("calendar_end").getAsString();
		
		JsonElement je = jo.get("item");
		JsonArray ja = je.getAsJsonArray();
		
		ArrayList<CalendarDTO> saveCalendar = new ArrayList<>();
		for (int cnt = 0; cnt < ja.size(); cnt++) {
			CalendarDTO calendar = new CalendarDTO();
			JsonObject o = ja.get(cnt).getAsJsonObject();
			calendar.setTitle(o.get("title").getAsString());
			calendar.setAddr1(o.get("addr1").getAsString());
			calendar.setAddr2(o.get("addr2").getAsString());
			calendar.setFirstImage2(o.get("firstImage2").getAsString());
			calendar.setMapX(o.get("mapX").getAsString());
			calendar.setMapY(o.get("mapY").getAsString());
			calendar.setContentId(o.get("contentId").getAsString());
			calendar.setSubject(subject);
			calendar.setCalendar_start(calendar_start);
			calendar.setCalendar_end(calendar_end);
			
			saveCalendar.add(calendar);
		}
		
		String duplicateCheck = svc.saveCalendar(saveCalendar);
		if (duplicateCheck.equals("중복"))
			return "이미 존재하는 제목입니다. 다시 시도하세요.";
		else
			return "성공";
	}
	
	// 일정 불러오기
	@ResponseBody
	@PostMapping(value = "getCalendar", produces = "application/json; charset=UTF-8")
	public String getSavedCalendar(@RequestBody(required = false)String subject, Model model) {
		ArrayList<CalendarDTO> returnData = svc.getSavedCalendar(subject);
		
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray();
		
		for (int cnt = 0; cnt < returnData.size(); cnt++) {
			JSONObject tmp = new JSONObject();
			tmp.put("title", returnData.get(cnt).getTitle());
			tmp.put("addr1", returnData.get(cnt).getAddr1());
			tmp.put("addr2", returnData.get(cnt).getAddr2());
			tmp.put("mapX", returnData.get(cnt).getMapX());
			tmp.put("mapY", returnData.get(cnt).getMapY());
			tmp.put("firstImage2", returnData.get(cnt).getFirstImage2());
			tmp.put("contentId", returnData.get(cnt).getContentId());
			ja.add(tmp);
		}
		jo.put("items", ja);
		System.out.println("jo : " + jo);
		return jo.toString();
	}
	
	@ResponseBody
	@PostMapping(value = "updateCalendar", produces = "application/json; charset=utf-8")
	public String updateCalendar(@RequestBody String obj) {
		System.out.println("obj : " + obj);
		Gson gson = new Gson();
		JsonObject jo = gson.fromJson(obj, JsonObject.class);
		
		String subject = jo.get("subject").getAsString();
		String calendar_start = jo.get("calendar_start").getAsString();
		String calendar_end = jo.get("calendar_end").getAsString();
		
		JsonElement je = jo.get("item");
		JsonArray ja = je.getAsJsonArray();
		
		ArrayList<CalendarDTO> updateCalendar = new ArrayList<>();
		for (int cnt = 0; cnt < ja.size(); cnt++) {
			CalendarDTO calendar = new CalendarDTO();
			JsonObject o = ja.get(cnt).getAsJsonObject();
			
			calendar.setId((String)session.getAttribute("id"));
			calendar.setTitle(o.get("title").getAsString());
			calendar.setAddr1(o.get("addr1").getAsString());
			calendar.setAddr2(o.get("addr2").getAsString());
			calendar.setFirstImage2(o.get("firstImage2").getAsString());
			calendar.setMapX(o.get("mapX").getAsString());
			calendar.setMapY(o.get("mapY").getAsString());
			calendar.setContentId(o.get("contentId").getAsString());
			calendar.setSubject(subject);
			calendar.setCalendar_start(calendar_start);
			calendar.setCalendar_end(calendar_end);
			
			updateCalendar.add(calendar);
		}
		
		svc.updateCalendar(updateCalendar);
		return null;
	}
}
