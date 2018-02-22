package lang;

public class WrapperClassTest {
	public static void main(String[] args) {
		/*
		 * 이렇게 쓰지 말자
		 */
		Integer i = new Integer(10);
		Character c = new Character('c');
		Float f = new Float(3.14);
		Boolean b = new Boolean(true);
		
		Integer j = 10; // Auto Boxing --> JVM이 관리
		//int k = 20 + j.intValue();
		int k = 20 + j; // Auto UnBoxing
		System.out.println(k);
	}
	
	public static void swap(Integer a, Integer b) {
		/*
		 * Wrapper Class는 객체지만 내부를 변경할 수 없다.
		 * 따라서 Integer 타입을 통해 swap을 할 수는 없다.
		 */
	}
}
