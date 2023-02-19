package com.care.KorTravel.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;


import com.care.KorTravel.dto.DBDTO;



@Mapper
public interface SearchDAO {

	ArrayList<DBDTO> getData(String search);

	ArrayList<DBDTO> searchProc(int begin, int end, String select, String title);

	String searchCount(HashMap<String, Object> map);

	ArrayList<DBDTO> getAreaData(String obj);

	String searchAreaCount(HashMap<String, Object> map);

	ArrayList<DBDTO> searchAreaProc(int begin, int end, String select, String areaCode);

}
