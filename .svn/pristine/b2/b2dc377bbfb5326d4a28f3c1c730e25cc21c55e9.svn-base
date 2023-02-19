package com.care.KorTravel.adminDAO;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.care.KorTravel.dto.InquiryDTO;

@Mapper
public interface CSDAO {
	public ArrayList<InquiryDTO> getList(int cursor_MIN, int cursor_MAX, String options, String searchText);
	public Object getDataCount(String options, String searchText);
	public void delete(String num);
	public InquiryDTO getInquiryContent(int num);
	public void answerRegist(String answer, String num);
	public void update(String num, String answer);

}
