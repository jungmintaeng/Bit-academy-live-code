package com.cafe24.exception;

public class ExceptionTest {
	public static void main(String[] args) {
		int a = 0;
		try {
			double b = 100/a;
		}catch(ArithmeticException aex) {
			//1. 사과
			System.out.println("죄송합니다. 오류가 발생하여 해당 요청을 처리하지 못했습니다.");
			//2. 로그 남기기
			aex.printStackTrace();
			//3. 정상 종료
			return;
		}
		
		System.out.println("Some more codes");//실행되지 않음
	}
}
