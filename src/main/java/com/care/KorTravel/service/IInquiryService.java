package com.care.KorTravel.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.KorTravel.dto.InquiryDTO;

public interface IInquiryService {
	public void inquiryProc(Model model, int currentPage,HttpServletRequest req);
	public int inquiryWrite(HttpServletRequest req);
	
	public void insert(Model model, String num);
	
	public void inquiryDetail(Model model, int num);

	public int inquiryModifyProc(HttpServletRequest req);
	
	public int inquiryDeleteProc(int num);
}
