package com.care.KorTravel.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.KorTravel.adminService.CommunityManageServiceImpl;
import com.care.KorTravel.dto.CommunityDTO;

@Controller
public class CommunityManageController {

	@Autowired private CommunityManageServiceImpl svc;
	
	@GetMapping("admin/communityManage")
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
		
		model.addAttribute("communitys", svc.getList(dataViewCount, index, options, searchText));
		model.addAttribute("currentPage", currentPage);
		setIndex(dataViewCount, model, options, searchText);
		
		return "admin/community/communityManage.admin";
	}
	
	@GetMapping("admin/communityDetail")
	public String noticeDetail(@RequestParam(required = false)String num, Model model) {
		// 게시물에 이미지tag 존재시 경로 재지정
		CommunityDTO tmp = svc.getCommunityContent(num);
		System.out.println("content원본 : " + tmp.getContent());
		String content = tmp.getContent();
		try {
			for (int cnt2 = 0; cnt2 < content.length(); cnt2++) {
				if (content.charAt(cnt2) == '<') {
					if (content.charAt(cnt2 + 1) == 'i' &&
						content.charAt(cnt2 + 2) == 'm' &&
						content.charAt(cnt2 + 3) == 'g'
					) {
						content =
								content.substring(0, cnt2 + 9) + 
								"\"../../.." + 
								content.substring(cnt2 + 11, content.length());
					}
				}
			}
		} catch (Exception e) {}
		
		tmp.setContent(content);
		model.addAttribute("communityContent", tmp);
		return "admin/community/communityDetail.admin";
	}
	
	@RequestMapping("admin/communityDelete")
	public String communityDelete(@RequestParam(required = true)String num, RedirectAttributes ra) {
		svc.delete(num);
		ra.addFlashAttribute("msg", "삭제되었습니다.");
		return "redirect:/admin/communityManage";
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
