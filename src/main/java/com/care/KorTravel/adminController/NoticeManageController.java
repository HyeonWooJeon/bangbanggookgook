package com.care.KorTravel.adminController;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.care.KorTravel.adminService.NoticeManageServiceImpl;
import com.care.KorTravel.dto.NoticeDTO;

@Controller
public class NoticeManageController {

	@Autowired private NoticeManageServiceImpl svc;
	
	@GetMapping("admin/noticeManage")
	public String noticeManage(
		@RequestParam(required = false)String index,
		@RequestParam(required = false)String options,
		String searchText,
		@RequestParam(required = false)String currentPage,
		Model model
	) {
		int dataViewCount = 11;
		
		if (index == null)
			index = "1";
		if (currentPage == null)
			currentPage = "0";
		
		model.addAttribute("notices", svc.getList(dataViewCount, index, options, searchText));
		model.addAttribute("currentPage", currentPage);
		setIndex(dataViewCount, model, options, searchText);
		
		return "admin/notice/noticeManage.admin";
	}
	
//	@RequestMapping("admin/notice/getList")
//	public void getList(Model model) { model.addAttribute("notices", svc.getList()); }
	
	@GetMapping("admin/noticeWrite")
	public String noticeWrite(Model model) { return "admin/notice/noticeWrite.admin"; }
	
	@PostMapping("admin/noticeWrite")
	public String noticeRegist(MultipartFile uploadFile, NoticeDTO notice, Model model) throws IllegalStateException, IOException {
		int dataViewCount = 11;
		String index = "1";
		
		if (notice.getTitle() == null || notice.getTitle().isEmpty()) {
			model.addAttribute("msg", "비정상적인 접근입니다.");
			return "admin/notice/noticeManage.admin";
		} else if (notice.getContent() == null || notice.getContent().isEmpty()) {
			model.addAttribute("msg", "비정상적인 접근입니다.");
			return "admin/notice/noticeManage.admin";
		}
		
		int lastVal = svc.getNumLastVal() + 1;
		String path = "C:\\javas\\project_workspace\\KorTravel\\src\\main\\"
				+ "resources\\static\\noticeUploadFile\\" + lastVal + "_noticeFile";
		File file = new File(path);
		
		if (!file.exists())
			file.mkdir();
		
		try {
			uploadFile.transferTo(new File(path + "/" + uploadFile.getOriginalFilename()));
		} catch (Exception e) {
			notice.setFileName("파일없음");
		}
		// 등재될 공지사항의 번호 받기
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date nowDate = new Date();
		
		notice.setWriteDate(sdf.format(nowDate));
		notice.setHit(0);
		notice.setNum(lastVal);
		notice.setFileName(uploadFile.getOriginalFilename());
		svc.regist(notice);
		
		return "redirect:/admin/noticeManage";
	}
	
	@GetMapping("admin/noticeDetail")
	public String noticeDetail(@RequestParam(required = false)String num, Model model) {
		model.addAttribute("noticeContent", svc.getNoticeContent(num));
		return "admin/notice/noticeDetail.admin";
	}
	
	@PostMapping("admin/noticeUpdate")
	public String noticeUpdate(String noticeTitle, String noticeContent, String num, RedirectAttributes ra) {
		svc.update(noticeTitle, noticeContent, num);
		ra.addFlashAttribute("msg", "수정되었습니다.");
		return "redirect:/admin/noticeManage";
	}
	
	@RequestMapping("admin/delete")
	public String noticeDelete(@RequestParam(required = false)String num) {
		svc.delete(num);
		return "redirect:/admin/noticeManage";
	}
	
	@GetMapping(value = "admin/noticeFileDownload")
	public void fileDownload(@RequestParam(required = false)String num, HttpServletResponse response) throws IOException {
		
		String fileName = svc.getFileName(num);
		String path = "C:\\javas\\project_workspace\\KorTravel\\src\\main\\"
				+ "resources\\static\\noticeUploadFile\\" + num + "_noticeFile//" + fileName;
		
		byte[] fileByte = FileUtils.readFileToByteArray(new File(path));
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
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
