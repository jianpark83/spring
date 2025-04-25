package com.kr.mbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Hello")
public class MainController {

	@RequestMapping(method=RequestMethod.GET, value = "/")
	public String test() {
		return "hello";
	}
	
}
