package com.care.KorTravel.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.care.KorTravel.dto.PaymentDTO;
import com.care.KorTravel.service.IPaymentService;

@Mapper
public interface PaymentDAO {
	
	public ArrayList<PaymentDTO> payInfo();
}
