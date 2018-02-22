package chapter03;

import java.io.IOException;

/**
 * 메소드를 작성할 때 Checked Exception을 발생시켜야 하는 경우
 */

public class MyClass{
	public void danger() throws IOException, MyException{
		System.out.println("some code 1");
		System.out.println("some code 2");
		System.out.println("some code 3");

		if(1 == 0)
			throw new IOException();
		
		if(1 == 0)
			throw new MyException();
		
		if(1 == 1)
			throw new MyException("hello exception!");
		
		System.out.println("some code 4");
		System.out.println("some code 5");
		System.out.println("some code 6");
	}
}
