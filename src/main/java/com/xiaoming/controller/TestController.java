package com.xiaoming.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoming.entity.User;

@Controller
@RequestMapping(value="/test")
public class TestController {

	@Value("${jwt.secret}")
	private String secret ;
	
	@RequestMapping(value="/test1")
	@ResponseBody
		public Object test1(){
			User u = new User() ;
			u.setId(2);
			u.setName("张三");
			u.setPassword(secret);
			System.out.println("密码："+secret);
			System.out.println("name:"+u.getName());
			System.out.println("修改代码："+u.getSex());
			return u  ;
		}
}
