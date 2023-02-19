package com.care.KorTravel.service;

import org.springframework.ui.Model;

public interface IConceptService {
	 public String selectRecom();
	 public String selectRandom(String cat1);
	 public void selectDetail(Model model, String contentId);
	
}
