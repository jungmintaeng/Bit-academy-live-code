package lang;

public class PointTest {
	public static void main(String[] args) {
		Point point  = new Point();
		System.out.println(point.getClass());
		System.out.println(point.hashCode());
		
		System.out.println(point.toString());
		//toString : getClass().getName() + "@" + hashCode()
		System.out.println("------------");
		
		//----------------------------------//
		String s = new String("hello");
		System.out.println(s.getClass());
		System.out.println(s.hashCode());
		System.out.println(s.toString());
		
		String s1 = new String("hello");
		System.out.println(s1.getClass());
		System.out.println(s1.hashCode());
		System.out.println(s1.toString());
		
		/*
		 * 두 String 객체는 hashCode가 같다. 원래는 주소로 hashing할 경우
		 * hashCode는 달라야 하지만 String class는 hashCode method를 override하여
		 * 내용을 통해 hashing하도록 변경하였고, 따라서 equals에서 true가 return 될 것이다.
		 */
		//----------------------------------//
	}
}
