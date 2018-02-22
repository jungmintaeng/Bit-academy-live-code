package lang;

public class EqualsTest {
	public static void main(String[] args) {
		Point point1 = new Point(10,20);
		Point point2 = new Point(10,20);
		Point point3 = point2;
		/*
		 * ==연산자에서 두 개의 항이 참조 변수인 경우
		 * 두 객체의 동일 여부를 판단(동일성)
		 */
		System.out.println(point1 == point2);
		System.out.println(point2 == point3);
		
		/*
		 * 두 객체의 동질성(내용) 비교를 할 경우
		 * equals()를 사용한다.
		 */
		System.out.println(point1.equals(point2));
		System.out.println(point2.equals(point3));
		
		//literal
		
		String str1 = "hello";
		String str2 = "hello";
		String str3 = str2;
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
	}
}
