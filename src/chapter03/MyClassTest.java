package chapter03;

import java.io.IOException;

public class MyClassTest {
	public static void main(String[] args) {
		MyClass my = new MyClass();
		
		try {
			my.danger();
		} catch (IOException e) {
			//IOException handler
			e.printStackTrace();
		} catch(MyException e) {
			//MyException handler
			e.printStackTrace();
		}
	}
	
	public static void test() throws MyException, IOException{
		MyClass myclass = new MyClass();
		myclass.danger();
	}
}
