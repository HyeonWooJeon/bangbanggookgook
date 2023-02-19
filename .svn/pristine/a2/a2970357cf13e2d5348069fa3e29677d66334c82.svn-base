package com.care.KorTravel.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.KorTravel.dao.NoticeDAO;

import com.care.KorTravel.dto.NoticeDTO;


@Service
public class NoticeServiceImpl implements INoticeService{
	
	@Autowired NoticeDAO noticeDao;

	@Override
	public void noticeProc(Model model, int currentPage, String search, String select, HttpServletRequest req) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("search", search);
		
		
		String totalCount;
		String stTotalCount = noticeDao.noticeCount(map);
		if(stTotalCount==null) {
			totalCount = "1";
			
		}
		else totalCount=noticeDao.noticeCount(map);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalCount", totalCount);
		
		int pageBlock = 10;
		int end = currentPage * pageBlock;
		int begin = end+1-pageBlock;
		
		ArrayList<NoticeDTO> noticeList = noticeDao.noticeProc(begin, end, select, search);
		model.addAttribute("noticeList", noticeList);
		
		String url = req.getContextPath() +"/notice?";
		if(search==null) {
			search ="";
			url+="search="+search+"&";				
		}
		else {
		url+="search="+search+"&";}
			url+="currentPage=";
		model.addAttribute("page", PageService.getNavi(model ,url, currentPage, pageBlock, totalCount));
	}

	@Override
	public void noticeDetail(Model model, int num) {
		NoticeDTO noticeDetailList = noticeDao.noticeDetail(num);
		model.addAttribute("noticeDetailList", noticeDetailList);
	}

	@Override
	public void hitIncrease(int num) {
		noticeDao.hitIncrease(num);
		
	}

	@Override
	public void movePage(Model model, int num) {
		NoticeDTO noticeDto = noticeDao.movePage(num);
		model.addAttribute("move", noticeDto);
		
	}

}
