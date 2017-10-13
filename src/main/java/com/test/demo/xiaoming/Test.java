package com.test.demo.xiaoming;

public class Test {
	
		public static void test1(){
			try {
				throw new TestException("字符串解析失败") ;
			}catch(TestException e) {
				e.printStackTrace();
			}
		}
	
		public static void main(String[] args) {
			test1() ;
			System.out.println("nihaoa ");
		}
}
