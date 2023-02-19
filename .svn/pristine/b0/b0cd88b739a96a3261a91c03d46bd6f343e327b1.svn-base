package com.care.KorTravel.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.KorTravel.dto.NoticeDTO;




@Mapper
public interface NoticeDAO {

	public String noticeCount(HashMap<String, Object> map);

	public ArrayList<NoticeDTO> noticeProc(@Param("begin")int begin, @Param("end")int end, @Param("select")String select, @Param("search")String search);

	public NoticeDTO noticeDetail(int num);

	public void hitIncrease(int num);

	public NoticeDTO movePage(int num1);



}
