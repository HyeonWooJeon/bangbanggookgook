package com.care.KorTravel.adminDAO;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.care.KorTravel.dto.NoticeDTO;

@Mapper
public interface NoticeManageDAO {

	public void regist(NoticeDTO notice);
	public ArrayList<NoticeDTO> getList(int cursor_MIN, int cursor_MAX, String options, String searchText);
	public NoticeDTO getNoticeContent(int num);
	public Object getDataCount(String options, String searchText);
	public void update(String noticeTitle, String noticeContent, String num);
	public void delete(String num);
	public int getNumLastVal();
	public String getFileName(String num);
}
