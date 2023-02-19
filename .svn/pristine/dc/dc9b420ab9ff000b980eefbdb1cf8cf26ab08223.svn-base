package com.care.KorTravel.adminController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.KorTravel.adminService.DataManageServiceImpl;
import com.care.KorTravel.dto.FacilityDTO;

@Controller
public class DataManageController {
	
	@Autowired private DataManageServiceImpl svc;

	// 데이터 관리 클릭시
	@GetMapping("admin/dataManage")
	public String dataManage() { return "admin/data/dataManage.admin"; }
	
	// 업체등록 클릭시
	@GetMapping("data/facilityRegist")
	public String facilityRegist() { return "admin/data/facility/facilityRegist.admin"; }
	
	// 업체 등록시
	@PostMapping("admin/facilityRegist")
	public String facilityRegist (
		FacilityDTO facility, MultipartFile[] uploadFile,
		String overview
	) throws IllegalStateException, IOException {
		System.out.println("recommend : " + facility.getRecommend());
		
		// overview등록
		facility.setOverview(overview);
		
		// contetnId 부여
		facility.setContentId(svc.createContentId());
		
		// 업체명이 중복된 경우를 위한 대표/썸네일 이미지 보관 폴더명에 areaCode추가
		String path = "C:\\javas\\project_workspace\\KorTravel\\src\\main\\"
				+ "resources\\static\\facilityImage\\" + "(" + facility.getAreaCode() + ")_" + facility.getTitle();
		File file = new File(path);
		
		if (!file.exists())
			file.mkdir();
		
		// 확장자명 추출
		String firstImageExtension[] = uploadFile[0].getContentType().split("image/");
		String firstImage2Extension[] = uploadFile[1].getContentType().split("image/");
		
		try {
			uploadFile[0].transferTo(new File(path + "/" + "firstImage." + firstImageExtension[1]));
			uploadFile[1].transferTo(new File(path + "/" + "firstImage2." + firstImage2Extension[1]));
			facility.setFirstImage(path + "\\" + "firstImage." + firstImageExtension[1]);
			facility.setFirstImage2(path + "\\" + "firstImage2." + firstImage2Extension[1]);
			System.out.println("firstImage1 : " + facility.getFirstImage());
			System.out.println("firstImage2 : " + facility.getFirstImage2());
		} catch (Exception e) {
			facility.setFirstImage("");
			facility.setFirstImage2("");
		}
		
		svc.registFacility(facility);
		
		return "redirect:/admin/facilityManage";
	}
	
	// 관광지/음식/숙박 클릭시
	@RequestMapping("admin/facilityManage")
	public String facilityManage(
		String index,String options,
		String searchText, String currentPage, Model model
	) {
		int dataViewCount = 11;

		if (index == null)
			index = "1";
		if (currentPage == null)
			currentPage = "0";
		
		System.out.println("options : " + options);
		if (options != null) {
			if (searchText.equals("음식점") || searchText.equals("음식"))
				searchText = "A05";
			else if (searchText.equals("관광") || searchText.equals("관광지"))
				searchText = "A02";
			else if (searchText.equals("숙박"))
				searchText = "B02";
		}
		
//		System.out.println("options : " + options + "\nsearchText : " + searchText);
		model.addAttribute("facilities", svc.getList(dataViewCount, index, options, searchText));
		model.addAttribute("currentPage", currentPage);
		setIndex(dataViewCount, model, options, searchText);

		return "admin/data/facility/facilityManage.admin";
		
	}
	
	// 추천업체 등록시
	@RequestMapping("admin/recommendReg")
	public String recommendReg(@RequestParam(required = true)String contentId, RedirectAttributes ra) {
		svc.recommendReg(contentId);
//		ra.addFlashAttribute("msg", "등록되었습니다.");
		return "redirect:/admin/facilityManage";
	}
	
	// 추천업체 해제시
	@RequestMapping("admin/recommendReset")
	public String recommendReset(@RequestParam(required = true)String contentId, RedirectAttributes ra) {
		svc.recommendReset(contentId);
//		ra.addFlashAttribute("msg", "해제되었습니다.");
		return "redirect:/admin/facilityManage";
	}

	// 업체관리 -> 업체클릭시
	@GetMapping("admin/facilityDetail")
	public String facilityDetail(String contentId, Model model) {
		model.addAttribute("facility", svc.getFacilityDetail(contentId));
		return "admin/data/facility/facilityDetail.admin";
	}
	
	// 업체 수정시
	@PostMapping("admin/facilityDetail")
	public String facilityUpdate (
		FacilityDTO facility, MultipartFile[] uploadFile,
		String overview,
		@RequestParam String prevTitle, 
		@RequestParam String prevAreaCode
	) throws IllegalStateException, IOException {
		// DTO에 overview 세팅
		facility.setOverview(overview);
		
		String prevPath = "C:\\javas\\project_workspace\\KorTravel\\src\\main\\"
				+ "resources\\static\\facilityImage\\" + "(" + prevAreaCode + ")_" + prevTitle;
		
		String updatePath = "C:\\javas\\project_workspace\\KorTravel\\src\\main\\"
				+ "resources\\static\\facilityImage\\" + "(" + facility.getAreaCode() + ")_" + facility.getTitle();
		
		// 업체 이미지 경로 불러오기
		// 기존 파일 삭제 후 재등록
		if (uploadFile != null) {
			FacilityDTO imagePath = svc.getImagePath(facility.getContentId());
			try {
				File firstImage = new File(imagePath.getFirstImage());
				File firstImage2 = new File(imagePath.getFirstImage2());
				firstImage.delete();
				firstImage2.delete();
				
				File dir = new File(prevPath);
				dir.delete();
				
				File file = new File(updatePath);
				if (!file.exists())
					file.mkdir();
				
			} catch (Exception e) {
				System.out.println("오류발생");
			}
		}
		
		try {
			// 확장자명 추출
			String firstImageExtension[] = uploadFile[0].getContentType().split("image/");
			String firstImage2Extension[] = uploadFile[1].getContentType().split("image/");
			
			uploadFile[0].transferTo(new File(updatePath + "/" + "firstImage." + firstImageExtension[1]));
			uploadFile[1].transferTo(new File(updatePath + "/" + "firstImage2." + firstImage2Extension[1]));
			facility.setFirstImage(updatePath + "\\" + "firstImage." + firstImageExtension[1]);
			facility.setFirstImage2(updatePath + "\\" + "firstImage2." + firstImage2Extension[1]);
		} catch (Exception e) {
			facility.setFirstImage("");
			facility.setFirstImage2("");
		}
		
		svc.updateFacility(facility);
		
		return "redirect:/admin/facilityManage";
	}

	// 삭제 클릭시
	@ResponseBody
	@PostMapping(value = "admin/facilityDelete", produces = "text/html; charset=UTF-8")
	public String facilityDelete(@RequestBody(required = true)String contentId) {
		svc.deleteFacility(contentId);
		return "";
	}
	
	// 복구 클릭시
	@ResponseBody
	@PostMapping(value = "admin/facilityRestore", produces = "text/html; charset=UTF-8")
	public String facilityRestore(@RequestBody(required = true)String contentId) {
		System.out.println("contentId : " + contentId);
		svc.restoreFacility(contentId);
		return "";
	}
	
	@GetMapping("admin/dataRenewal")
	public String dataRenewal() { return "admin/data/dataRenewal.admin"; }
	
	
	/** noticeManage에 index설정 method */
	public void setIndex(
			int dataViewCount, 
			Model model,
			@RequestParam(required = false)String options,
			@RequestParam(required = false)String searchText
	) {
		
		int dataCount;
		if ( (options == null || options.equals("")) && (searchText == null || searchText.equals("")) )
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
