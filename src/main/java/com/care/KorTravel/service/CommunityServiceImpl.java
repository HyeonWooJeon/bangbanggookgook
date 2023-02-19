package com.care.KorTravel.service;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.KorTravel.dao.CommunityDAO;
import com.care.KorTravel.dto.Commun_commentDTO;
import com.care.KorTravel.dto.CommunityDTO;




@Service
public class CommunityServiceImpl implements ICommunityService{
	
	@Autowired CommunityDAO communityDao;
	@Autowired HttpSession session;

	@Override
	public void communityProc(Model model, int currentPage, String search, String select, HttpServletRequest req) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("search", search);
		map.put("select", select);
		
		
		String totalCount;
		String stTotalCount = communityDao.communityCount(map);
		if(stTotalCount==null) {
			totalCount = "1";
			
		}
		else totalCount=communityDao.communityCount(map);
		
		
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalCount", totalCount);
		
		int pageBlock = 10;
		int end = currentPage * pageBlock;
		int begin = end+1-pageBlock;
		
		ArrayList<CommunityDTO> communityList = communityDao.communityProc(begin, end, select, search);
		model.addAttribute("communityList", communityList);
		ArrayList<CommunityDTO> adminList = new ArrayList<>();
		ArrayList<CommunityDTO> userList = new ArrayList<>();
		for(CommunityDTO c : communityList) {
			if(c.getId().equals("admin")) {
				adminList.add(c);
			}
			else userList.add(c);
		}
		model.addAttribute("adminList", adminList);
		model.addAttribute("userList", userList);
		
		
		String url = req.getContextPath() +"/community?";
		if(search==null) {
			search ="";
			url+="select="+select+"&";
			url+="search="+search+"&";				
		}
		else {
		url+="select="+select+"&";
		url+="search="+search+"&";}
			url+="currentPage=";
		model.addAttribute("page", PageService.getNavi(model ,url, currentPage, pageBlock, totalCount));
		
	}

	@Override
	public void hitIncrease(int num) {
		communityDao.hitIncrease(num);
		
	}

	public void communityDetail(Model model, int num1) {
		CommunityDTO communityDetailList = communityDao.communityDetail(num1);
		model.addAttribute("communityDetailList", communityDetailList);
		
	}

	public void movePage(Model model, int num1) {
		CommunityDTO communityDto = communityDao.movePage(num1);
		model.addAttribute("move", communityDto);
		
	}

	@Override
	//첫등록
	public void saveComment(Commun_commentDTO commentDTO) {
       
		//댓글 작성자
		String writer=(String)session.getAttribute("id");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		String now = sdf.format(date);
		
		commentDTO.setReWriter(writer);
		commentDTO.setReDate(now);
		
		if (commentDTO.getReplyNo()==null || commentDTO.getReplyNo().equals("")) {
			//댓글 등록 시 동작.
        	communityDao.insertReply(commentDTO);
        	String reorder = communityDao.last_insert_num();
        	communityDao.insertReorder(reorder);
        	communityDao.commentCount(commentDTO);
        } 
	}


	public void getComment(Model model, int num) {
		int totalCount = communityDao.countComment(num);
		ArrayList<Commun_commentDTO> comments = communityDao.getComment(num);
		model.addAttribute("comment",comments );
		model.addAttribute("countComment", totalCount);
		
	}
	
	public int commentCount(int num) {
		int totalCount = communityDao.countComment(num);
		return totalCount;
	}

	public void ReplyDelete(String replyNo, String writeNo) {
		communityDao.ReplyDelete(replyNo);
		communityDao.commentCountDelete(writeNo);
		
	}
	
	//마이페이지 활동내역
	@Override
	public void myLog(Model model, int currentPage,HttpServletRequest req) {
		String id = (String)session.getAttribute("id");
		
		int stTotalCount= 0;
		try {
			stTotalCount = Integer.parseInt(communityDao.myLogCount(id));
		}catch(Exception e){
			stTotalCount = 1;
		}
				
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("stTotalCount", stTotalCount);
		
		int pageBlock = 10;
		int end = currentPage * pageBlock;
		int begin = end+1-pageBlock;
		
		ArrayList<CommunityDTO> myLogList = communityDao.myLog(begin, end,id);
		model.addAttribute("myLogList", myLogList);
		
		String url = req.getContextPath() +"/myLog?"+id;
		
		model.addAttribute("myLogPage", PageService.getNavi(model ,url, currentPage, pageBlock, String.valueOf(stTotalCount)));
	}

	public void edit(Model model, String num) {
		CommunityDTO dto = communityDao.edit(num);
		model.addAttribute("edit", dto);
	}

	public int community_edit(MultipartHttpServletRequest multi) {
		CommunityDTO dto = new CommunityDTO();
		int num = Integer.parseInt(multi.getParameter("num"));
		dto.setNum(num);
		dto.setContent(multi.getParameter("content"));
		dto.setTitle(multi.getParameter("title"));

		MultipartFile file = multi.getFile("file");
		if(file.getSize() != 0) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			String fileName = sdf.format(cal.getTime()) + file.getOriginalFilename();
			dto.setFileName(fileName);
			File save = new File(ICommunityService.FILE_LOCATION + "\\"+session.getAttribute("id")+"\\" + fileName);
			if(save.exists()==false) {
				save.mkdirs();
			}
			try {
				file.transferTo(save);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else {
			dto.setFileName("파일 없음");
		}
		int result = communityDao.community_edit(dto);
		return result;
	}
	
	public int writeProc(MultipartHttpServletRequest req) {
		String id = (String)session.getAttribute("id");
		String title = req.getParameter("title");
		String content= req.getParameter("content");
		
		Date date2 = new Date();
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		
		String now = sdf2.format(date2);
		
		CommunityDTO communityDto = new CommunityDTO();
		communityDto.setId(id);		
		communityDto.setTitle(title);
		communityDto.setContent(content);		
		communityDto.setHit(0);
		communityDto.setWriteDate(now);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		communityDto.setWriteDate(sdf.format(date));
		
		MultipartFile file = req.getFile("file");
		if(file.getSize() != 0) {
			Calendar cal = Calendar.getInstance();
			sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			String fileName = sdf.format(cal.getTime()) + file.getOriginalFilename();
			communityDto.setFileName(fileName);
			File save = new File(ICommunityService.FILE_LOCATION + "\\"+session.getAttribute("id")+"\\" + fileName);
			if(save.exists()==false) {
				save.mkdirs();
			}
			try {
				file.transferTo(save);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else {
			communityDto.setFileName("파일 없음");
		}
		int result = communityDao.community_write(communityDto);
		return result;
	}
	
	@Override
	public int my_write_delete(String num) {
		int numm = Integer.parseInt(num);
		int result = communityDao.my_write_delete(numm);
		return result;
	}
	
	//대댓글
	@Override
	public void saveReplyReply(Commun_commentDTO commentDTO) {
		if(commentDTO.getReplyNo()==null) {
			return;
		}
		else {
			//댓글 작성자
			String writer=(String)session.getAttribute("id");
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			String now = sdf.format(date);
			
			commentDTO.setReWriter(writer);
			commentDTO.setReDate(now);
			
			Commun_commentDTO commentDto = communityDao.getCommentAll(commentDTO.getReplyNo());
			System.out.println("리패랜츠 : " +commentDto.getReparent()); 
			if(commentDto.getReparent().equals("없음")) {
				commentDTO.setReparent(commentDto.getReplyNo());
			}
			else {
				int reparent = Integer.parseInt(commentDto.getReparent());
				String plusReparent = Integer.toString(reparent+1);
				commentDTO.setReparent(plusReparent);
			}
			
			
			int reDepth = Integer.parseInt(commentDto.getRedepth());
			String plusReDepth = Integer.toString(reDepth+1);
			commentDTO.setRedepth(plusReDepth);
			communityDao.insertReply(commentDTO);
	      	String reorder = communityDao.last_insert_num();
        	communityDao.insertReorder2(commentDto.getReorder()+","+reorder, reorder);
        	communityDao.commentCount(commentDTO);			
			
		}
		
	}

	public void replyUpdate(Commun_commentDTO commentDTO) {
		communityDao.updateReply(commentDTO);
		
	}


}
