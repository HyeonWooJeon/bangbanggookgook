package com.care.KorTravel.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.KorTravel.dao.SearchDAO;
import com.care.KorTravel.dto.CommunityDTO;
import com.care.KorTravel.dto.DBDTO;

@Service
public class SearchServiceImpl implements ISearchService{
	
	@Autowired SearchDAO searchDao;

	public String getData(String search) {
		
		ArrayList<DBDTO> list = searchDao.getData(search);
		
		if(list.isEmpty()) {
			return "";
		}
		String data = "{\"cd\" : [";
		
		for(DBDTO a : list) {

				data += "{ \"title\" : " + "\""+a.getTitle()+"\"";
				data += ", \"contentId\" : "+ "\""+a.getContentId()+"\""+" },";

		}
		
		data = data.substring(0, data.length()-1);
		data += "]}";
		
		return data;
	}

	public void search_onKeyProc(Model model, int currentPage, String title, String select, HttpServletRequest req) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("title", title);
		if(select==null || select=="") {
			select="A02";
		}
		map.put("select", select);			
		
		
		String totalCount;
		String stTotalCount = searchDao.searchCount(map);
		if(stTotalCount==null) {
			totalCount = "1";
			
		}
		else totalCount=searchDao.searchCount(map);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalCount", totalCount);
		
		int pageBlock = 10;
		int end = currentPage * pageBlock;
		int begin = end+1-pageBlock;
		
		ArrayList<DBDTO> searchList = searchDao.searchProc(begin, end, select, title);
		model.addAttribute("searchList", searchList);
		
		String url = req.getContextPath() +"/search_onKeyProc?";
		if(select==null || select=="") {
			select ="A02";
			url+="select="+select+"&";
			url+="title="+title+"&";				
		}
		else {
		url+="select="+select+"&";
		url+="title="+title+"&";}
			url+="currentPage=";
		model.addAttribute("page", PageService.getNavi(model ,url, currentPage, pageBlock, totalCount));
		
		
	}

	public void getAreaData(Model model, int currentPage, String areaCode, String select, HttpServletRequest req) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("areaCode", areaCode);
		if(select==null || select=="") {
			select="A02";
		}
		map.put("select", select);			
		
		
		String totalCount;
		String stTotalCount = searchDao.searchAreaCount(map);
		if(stTotalCount==null) {
			totalCount = "1";
			
		}
		else totalCount=searchDao.searchAreaCount(map);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalCount", totalCount);
		
		int pageBlock = 10;
		int end = currentPage * pageBlock;
		int begin = end+1-pageBlock;
		
		ArrayList<DBDTO> searchList = searchDao.searchAreaProc(begin, end, select, areaCode);
		model.addAttribute("searchList", searchList);
		
		String url = req.getContextPath() +"/areaSearch?";
		if(select==null || select=="") {
			select ="A02";
			url+="select="+select+"&";
			url+="areaCode="+areaCode+"&";				
		}
		else {
		url+="select="+select+"&";
		url+="areaCode="+areaCode+"&";}
			url+="currentPage=";
		model.addAttribute("page", PageService.getNavi(model ,url, currentPage, pageBlock, totalCount));
		
	}
	
	

}
