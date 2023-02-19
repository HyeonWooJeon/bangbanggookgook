package com.care.KorTravel.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.care.KorTravel.dto.InquiryDTO;


@Mapper
public interface inquiryDAO {
	//문의 목록
	public ArrayList<InquiryDTO> inquiryList(String id);
	//문의 상세
	public InquiryDTO inquiryDetail(int num);
	//문의 페이지
	public InquiryDTO pageMove(int pageNum);
	//문의 등록
	public int inquiryWrite(InquiryDTO inquiryDto);
	public InquiryDTO insert(String num); 
	
	//총갯수 가져오기
	public String inquiryCount(String id);
	
	public ArrayList<InquiryDTO> inquiryProc(String id,int begin,int end);
	
	public int inquiryModifyProc(InquiryDTO inquiryDto);
	
	public int inquiryDeleteProc(int num);
	
}
