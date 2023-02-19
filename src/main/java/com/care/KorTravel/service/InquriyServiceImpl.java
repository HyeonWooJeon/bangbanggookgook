package com.care.KorTravel.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.KorTravel.dao.inquiryDAO;
import com.care.KorTravel.dto.InquiryDTO;
import com.care.KorTravel.dto.inquiryCommentDTO;

@Service
public class InquriyServiceImpl implements IInquiryService{
	@Autowired inquiryDAO inquiryDao;
	@Autowired HttpSession session;
	
	@Override
	 public void inquiryProc(Model model, int currentPage,HttpServletRequest req){
//			String totalCount;
			String id =(String)session.getAttribute("id");
			
			int inTotalCount = 0;
			try {
				inTotalCount = Integer.parseInt(inquiryDao.inquiryCount(id));
			} catch (Exception e) {
				inTotalCount = 1;
			}
			
//			if(inTotalCount==null) {
//				totalCount="1";
//			}else
//				totalCount=inquiryDao.inquiryCount((String)session.getAttribute("id"));
			
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("totalCount",inTotalCount);
			
			int pageBlock = 10;
			int end = currentPage * pageBlock;
			int begin = end+1-pageBlock;
			
			ArrayList<InquiryDTO> inquiryList = inquiryDao.inquiryProc(id,begin,end);
			model.addAttribute("inquiryList",inquiryList);
			
			String url = req.getContextPath()+"/myInquiry?currentPage=";
//			url+="currentPage=";
			model.addAttribute("inquiryPage",PageService.getNavi(model, url, currentPage, pageBlock, String.valueOf(inTotalCount)));
			
	    }
	@Override
	public int inquiryWrite(HttpServletRequest req) {
		String id = (String) session.getAttribute("id");
		InquiryDTO inquiryDto = new InquiryDTO();
		inquiryDto.setId(id);
		inquiryDto.setTitle(req.getParameter("title"));
		inquiryDto.setType(req.getParameter("type"));
		inquiryDto.setInquiryContent(req.getParameter("inquiryContent"));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		inquiryDto.setInquiryDate(sdf.format(date));
		int result =inquiryDao.inquiryWrite(inquiryDto);
		return result;
	}
	@Override
	public void insert(Model model, String num) {
//		InquiryDTO dto = inquiryDao.insert(num);
//		model.addAttribute("insert",dto);
//		System.out.println("insert"+dto);
	}
	@Override
	public void inquiryDetail(Model model, int num) {
		InquiryDTO inquiryList = inquiryDao.inquiryDetail(num);
		model.addAttribute("inquiryList",inquiryList);
	}
//	수정
	@Override
	public int inquiryModifyProc(HttpServletRequest req) {
		InquiryDTO inquDto = new InquiryDTO();
		int num = Integer.parseInt(req.getParameter("num"));
		inquDto.setNum(num);
		inquDto.setType(req.getParameter("type"));
		inquDto.setTitle(req.getParameter("title"));
		inquDto.setInquiryContent(req.getParameter("inquiryContent"));
		
		int result = inquiryDao.inquiryModifyProc(inquDto);
		return result;
	}
	
	@Override
	public int inquiryDeleteProc(int num) {
		int result = inquiryDao.inquiryDeleteProc(num);
		
		return result;
	}
	
}
