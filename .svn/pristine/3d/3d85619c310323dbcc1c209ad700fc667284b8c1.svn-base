package com.care.KorTravel.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.KorTravel.dao.MainDAO;
import com.care.KorTravel.dto.DBDTO;
import com.care.KorTravel.dto.NoticeDTO;

@Service
public class MainServiceImpl implements IMainService{
	
	@Autowired MainDAO mainDao;

	public void recommendSights(Model model) {

		ArrayList<DBDTO> mainList = mainDao.recommendSights();
		ArrayList<DBDTO> mainList2 = mainDao.recommendFood();
		
		model.addAttribute("recommendSights", mainList);
		model.addAttribute("recommendFood", mainList2);
		
	}

	public void getNotice(Model model) {
		ArrayList<NoticeDTO> noticeList = mainDao.getNotice();
		model.addAttribute("noticeList", noticeList);
		
	}

}
