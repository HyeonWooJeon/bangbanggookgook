package com.care.KorTravel.controller;



import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.KorTravel.service.ICommunityService;
import com.care.KorTravel.service.NoticeServiceImpl;

@Controller
public class NoticeController {
	
	@Autowired HttpSession session;
	@Autowired NoticeServiceImpl noticeService;
	@Autowired HttpServletRequest request;
	@Autowired HttpServletResponse response;

	@RequestMapping("notice")
	public String notice(Model model,@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage,
			String search, String select, HttpServletRequest req) {
			noticeService.noticeProc(model, currentPage, search, select,req);
			
		return "noticeView/notice.user";
	
	}
	@RequestMapping("noticeDetail")
	public String noticeDetail(Model model,String num, String hit) {
		int num1 = Integer.parseInt(num);
		
		if(hit.equals("1")) {
			noticeService.hitIncrease(num1);
			hit="0";
		}
		else{
			hit="0";
		}
		return "redirect:noticeDetailNoHit?num="+num+"&hit="+hit;
	}
	
	@RequestMapping(value="noticeDetailNoHit")
	public String noticeDetail1(Model model, String num, String hit) {
		
		int num1 = Integer.parseInt(num);
		noticeService.noticeDetail(model,num1);
		noticeService.movePage(model, num1);

		return "noticeView/noticeDetail.user";
	}
	
	@RequestMapping(value = "noticedownload")
	public void download(String fileName,String writer, HttpServletResponse res) throws Exception {
		if(fileName == "" || fileName.equals("파일 없음"))
			return ;
			
		res.addHeader("Content-disposition", "attachment; filename="+fileName);
		File file = new File(ICommunityService.FILE_LOCATION + "\\" + fileName);
		FileInputStream input = new FileInputStream(file);
		FileCopyUtils.copy(input, res.getOutputStream());
		input.close();
		
	}

}