package chapter03;
/**
 * 사용자 정의 Exception
 *
 */
public class MyException extends Exception{
	public MyException() {
		super("MyException occurs");
	}
	
	public MyException(String message) {
		super(message);
	}
}
