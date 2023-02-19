package com.care.KorTravel.adminService;

import java.util.ArrayList;

import com.care.KorTravel.dto.NoticeDTO;

public interface NoticeManageService {

	public void regist(NoticeDTO notice);
	public NoticeDTO getNoticeContent(String num);
	public ArrayList<NoticeDTO> getList(int dataViewCount, String index, String options, String searchText);
	public void update(String noticeTitle, String noticeContent, String num);
	public void delete(String num);
	public int getNumLastVal();
	public String getFileName(String num);
}
