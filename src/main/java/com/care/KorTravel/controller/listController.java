package com.care.KorTravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class listController {
	
	@RequestMapping("list")
	public String route() {
		return "route/list.user";
	}

}
