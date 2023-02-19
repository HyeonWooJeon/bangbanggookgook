package com.care.KorTravel.service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.KorTravel.dao.ConceptDAO;
import com.care.KorTravel.dto.FacilityDTO;


@Service
public class ConceptServiceImpl implements IConceptService {
	  @Autowired  private ConceptDAO conceptDao;
	     
	
	  @Override
	  public String selectRecom(){
		  FacilityDTO facilityDto = conceptDao.selectRecom();
	          if(facilityDto==null){
	          return"등록된 장소가 없습니다";
	      }
	      return"facilitiesDto";

	  }
	  @Override
	  public String selectRandom(String cat1){
		  ArrayList<FacilityDTO> facilityDto = conceptDao.selectRandom(cat1);
		  System.out.println("size : " + facilityDto.size());
		  JSONObject obj = new JSONObject();
		  JSONArray ja = new JSONArray();
		  
		  for(int i = 0; i<facilityDto.size(); i++) {
			  System.out.println("i : " + i);
			  JSONObject tmp = new JSONObject();
			  tmp.put("title", facilityDto.get(i).getTitle());
			  tmp.put("contentId", facilityDto.get(i).getContentId());
			  tmp.put("firstImage",facilityDto.get(i).getFirstImage());
			  ja.add(tmp);
		  }
		  
		  obj.put("item", ja);
		  return obj.toString();
		 
}
	public void selectDetail(Model model, String contentId) {
		FacilityDTO facilityDto = conceptDao.selectDetail(contentId);
		System.out.println(contentId);
		model.addAttribute("detail", facilityDto);
	
	}

	
}
