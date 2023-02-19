package com.care.KorTravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.KorTravel.service.IPaymentService;

@Controller
public class PaymentController {
@Autowired private IPaymentService service;
	
	
	@RequestMapping("payment")
	public String payment(){
		return "payment/payment.user";
	}
	
	@RequestMapping("payment_receipt")
	public String payment_receipt() {
		return "payment/payment_receipt.user";
	}
	
}
