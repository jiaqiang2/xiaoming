package com.xiaoming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/test2")
public class Test2 {
	
	@RequestMapping(value="/test")
	@ResponseBody
	public Object test(){
		return 1 ;
	}

}
