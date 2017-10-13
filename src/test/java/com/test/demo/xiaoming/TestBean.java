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
			System.out.println("names******:"+u.getName());
		}
		
		public void test2(){
			System.out.println("你好ssssss");
			System.out.println("你好ssssss");
		}
		
		public void test3(){
			System.out.println("测试bug");
			System.out.println("测试bug");
		}
		
		
}
