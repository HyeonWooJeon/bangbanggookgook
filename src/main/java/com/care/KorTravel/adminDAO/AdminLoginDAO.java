package com.care.KorTravel.adminDAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminLoginDAO {

	public String login(String id);
}
