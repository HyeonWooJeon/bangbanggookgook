package com.care.KorTravel.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.KorTravel.service.SearchServiceImpl;

@Controller
public class SearchController {
	
	@Autowired SearchServiceImpl searchService;
	
	@RequestMapping(value="search")
	public String search(String search) {
		return "searchView/search.user";
	}
	
	@ResponseBody
	@PostMapping(value="searchProc", produces = "application/json; charset=UTF-8")
	public String searchProc(@RequestBody (required = false) Map<String,String> map) {
		if(map.get("search")==null || map.get("search")=="") {
			return "";
		}
		else {
			
			String result = searchService.getData(map.get("search"));
			return result;
		}
	}
	
	@RequestMapping(value="search_onKeyProc")
	public String search_onKeyProc(Model model, @RequestParam(value="currentPage", required=false, defaultValue="1")int currentPage,
			String title, String select, HttpServletRequest req) {
		searchService.search_onKeyProc(model,currentPage, title, select, req);
		
		return "searchView/search.user";
	}
	

	
	
	@RequestMapping(value="areaSearch")
	public String selectArea(Model model, @RequestParam(value="currentPage", required=false, defaultValue="1")int currentPage,
			String areaCode, String select, HttpServletRequest req) {
		searchService.getAreaData(model, currentPage, areaCode, select, req);
		
		return "searchView/areaSearch.user";
	}

}
