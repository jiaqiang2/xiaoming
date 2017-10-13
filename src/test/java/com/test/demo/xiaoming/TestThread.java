package com.test.demo.xiaoming;

import java.util.Scanner;

public class TestThread extends Thread {

	private static Scanner input = new Scanner(System.in) ;
	
	@Override
	public void run() {
		Boolean result = true ;
		int num = 1 ;
		while(result){
			try {
				Thread.sleep(3000);
//				System.out.print("请输入你的姓名：");
//				String name = input.next() ;
//				if("admin".equals(name)){
//					result = false ;
//				}
				System.out.println("你好，这是第"+num+"次请求");
				num++ ;
				if(num==5){
					result = false ;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		String name = input.next() ;
		System.out.println("name:"+name);
		TestThread td = new TestThread() ;
		td.start() ;
	}
	
	

}
