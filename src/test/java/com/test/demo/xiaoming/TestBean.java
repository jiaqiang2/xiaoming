package com.test.demo.xiaoming;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiaoming.entity.User;

public class TestBean {
		private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml") ;
		
		@Test
		public void test1(){
			User u = (User) ac.getBean("user") ;
			System.out.println("******name:"+u.getName());
			System.out.println("name******:"+u.getName());
			System.out.println("name******:"+u.getName());
		}
}
