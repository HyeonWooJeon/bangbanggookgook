package com.care.KorTravel.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.KorTravel.service.ConceptServiceImpl;

@Controller
public class ConceptController {
	@Autowired private ConceptServiceImpl service;
	
	
	@RequestMapping(value="concept")
	public String conceptMain(Model model){
	   
	    return "concept/concept.user";
	}
	
	@ResponseBody
	@PostMapping(value="conceptInfo", produces="text/html; charset=UTF-8")
	public String conceptInfo(@RequestBody(required=false)String cat1) {
		System.out.println("cat1 : " + cat1);
		String result = service.selectRandom(cat1);
		System.out.println("result : " + result);
		return result;
	}

	
	@RequestMapping(value="concept_detail")
	public String concept_detail(Model model, String contentId) {
		System.out.println("번호 :"+ contentId);
		
		service.selectDetail(model, contentId);
		return "concept/concept_detail.user";
	}
@RequestMapping(value="concept" ,produces = "application/json; charset=UTF-8")
public String RecomFood(String data) {
	
	return data;
}
}
