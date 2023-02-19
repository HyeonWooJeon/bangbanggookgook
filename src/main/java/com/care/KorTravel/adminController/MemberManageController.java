package com.care.KorTravel.adminController;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.KorTravel.adminService.MemberManageServiceImpl;
import com.care.KorTravel.dto.MemberDTO;
import com.care.KorTravel.dto.NoticeDTO;

@Controller
public class MemberManageController {

	@Autowired private MemberManageServiceImpl svc;
	
	@GetMapping("admin/memberManage")
	public String noticeManage(
		@RequestParam(required = false)String index,
		@RequestParam(required = false)String options,
		@RequestParam(required = false)String searchText,
		@RequestParam(required = false)String currentPage,
		Model model
	) {
		int dataViewCount = 11;
		
		if (index == null)
			index = "1";
		if (currentPage == null)
			currentPage = "0";
		
		model.addAttribute("members", svc.getList(dataViewCount, index, options, searchText));
		model.addAttribute("currentPage", currentPage);
		setIndex(dataViewCount, model, options, searchText);
		
		return "admin/member/memberManage.admin";
	}
	
	@RequestMapping("admin/memberDetail")
	public String memberDetail(@RequestParam()String id, Model model) {
		model.addAttribute("member", svc.getMemberDetail(id));
		return "admin/member/memberDetail.admin";
	}
	
	//회원 수정
	@PostMapping("admin/memberUpdate")
	public String memberUpdate(MemberDTO member, RedirectAttributes ra) {
//		MemberDTO member = new MemberDTO();
//		member.setId(id);
//		member.setPhone(phone);
//		member.setGender(gender);
//		member.setAddr1(addr1);
//		member.setAddr2(addr2);
		
		svc.memberUpdate(member);
		ra.addFlashAttribute("msg", "수정되었습니다.");
		return "redirect:/admin/memberManage";
	}
	
	@RequestMapping("admin/memberPasswordUpdate")
	public String memberPasswordUpdate(String id, String email, RedirectAttributes ra) {		
		svc.memberPasswordUpdate(id, email);
		ra.addFlashAttribute("msg", "비밀번호가 변경되었습니다.");
		return "redirect:/admin/memberManage";
	}
	
	
	/** noticeManage에 index설정 method */
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
		
		// 한 화면에 보여질 인덱스 갯수
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
