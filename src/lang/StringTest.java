package lang;

public class StringTest {
	public static void main(String[] args) {
		String s = "I say \"hello\"";
		System.out.println(s);
		
		//문자 ' escape
		char c = '\'';
		
		// 문자 \ escape
		String path = "d:\\cafe24";
		System.out.println(path);
		
		// \t \n \r \b ....
		System.out.println("\n");
		System.out.println("");
		
		String s1 = "hello";
		String s2 = " ";
		String s3 = "world";
		
		System.out.println(s1+s2+s3);
	}
}
