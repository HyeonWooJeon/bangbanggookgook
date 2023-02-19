package com.care.KorTravel.service;



import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.KorTravel.dto.Commun_commentDTO;

public interface ICommunityService {
	
	String FILE_LOCATION = "C:\\javas\\project_workspace\\KorTravel\\src\\main\\resources\\static\\upload";
	
	public void communityProc(Model model, int currentPage, String search, String select, HttpServletRequest req);

	public void hitIncrease(int num);
	
	public void communityDetail(Model model, int num);
	
	public void movePage(Model model, int num);
	
	public void saveComment(Commun_commentDTO commentDTO);
	
	public void getComment(Model model,int num);
	
	public void ReplyDelete(String replyNo, String writeNo);

	
	public void myLog(Model model, int currentPage, HttpServletRequest req);

	public void edit(Model model, String num);
	
	public int community_edit(MultipartHttpServletRequest req);
	
	public int writeProc(MultipartHttpServletRequest req);
	
	public int my_write_delete(String num);
	
	public int commentCount(int num);
	
	public void saveReplyReply(Commun_commentDTO commentDTO);
	
	public void replyUpdate(Commun_commentDTO commentDTO);
}
