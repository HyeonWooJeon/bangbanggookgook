package com.care.KorTravel.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.KorTravel.adminService.InquiryManageServiceImpl;

@Controller
public class InquiryManageController {

	@Autowired private InquiryManageServiceImpl svc;
	
	@GetMapping("admin/inquiryManage")
	public String inquiryManage(
			String index, String options, 
			String searchText, String currentPage,
		Model model
	) {
		int dataViewCount = 11;
		
		if (index == null)
			index = "1";
		if (currentPage == null)
			currentPage = "0";
		
		model.addAttribute("inquiries", svc.getList(dataViewCount, index, options, searchText));
		model.addAttribute("currentPage", currentPage);
		setIndex(dataViewCount, model, options, searchText);
		
		return "admin/inquiry/inquiryManage.admin";
	}
	
	@GetMapping("admin/inquiryDetail")
	public String inquiryDetail(@RequestParam(required = false)String num, Model model) {
		model.addAttribute("inquiryContent", svc.getInquiryContent(num));
		return "admin/inquiry/inquiryDetail.admin";
	}

	@GetMapping("admin/inquiryAnswer")
	public String inquiryAnswer(@RequestParam(required = false)String num, Model model) {
		model.addAttribute("inquiryNum", num);
		return "admin/inquiry/inquiryAnswer.admin"; 
	}
	
	@PostMapping("admin/inquiryAnswer")
	public String inquiryAnswerRegist(String inquiryAnswerContent, 
			@RequestParam(required = false)String num,
			Model model) {
		System.out.println("inquiryAnswer : " + inquiryAnswerContent);
		System.out.println("num : " + num);
		svc.answerRegist(inquiryAnswerContent, num);
		model.addAttribute("msg", "????????? ?????????????????????.");
		return "redirect:/admin/inquiryManage";
	}
	
	// ?????? ??????
	@RequestMapping("admin/inquiryUpdate")
	public String inquiryUpdate(String num, String answer) {
		svc.update(num, answer);
		return "redirect:/admin/inquiryManage";
	}
	
	// ?????? ??????
	@RequestMapping("admin/inquiryDelete")
	public String inquiryDelete(@RequestParam(required = false)String num) {
		svc.delete(num);
		return "redirect:/admin/inquiryManage";
	}
	
	/** noticeManage??? index?????? method */
	public void setIndex(
			int dataViewCount, 
			Model model,
			@RequestParam(required = false)String options,
			@RequestParam(required = false)String searchText
	) {
		
		int dataCount;
		if (options == null || options.equals("") && searchText == null || searchText.equals(""))
			dataCount = svc.getDataCount();
		else
			dataCount = svc.getDataCount(options, searchText);
		
		if (dataCount == 0) {
			model.addAttribute("index_MAX", "0");
			return;
		}
		
		int index_MAX;
		if (dataCount % dataViewCount > 0)
			index_MAX = (dataCount / dataViewCount) + 1;
		else
			index_MAX = dataCount / dataViewCount;
		
		// ??? ????????? ????????? ????????? ??????
		int viewIndexSet = 4, maxPage;
		if (index_MAX % viewIndexSet == 0)
			maxPage = index_MAX / viewIndexSet;
		else
			maxPage = index_MAX / viewIndexSet + 1;
		
		model.addAttribute("index_MAX", index_MAX);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("viewIndexSet", viewIndexSet);
	}

}
