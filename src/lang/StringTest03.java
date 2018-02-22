package lang;

public class StringTest03 {
	public static void main(String[] args) {
		String s = "abcAbcabcABC";
		
		//charAt
		char c = s.charAt(2);
		System.out.println(c);
		
		//indexOf
		System.out.println(s.indexOf("Abc"));
		System.out.println(s.indexOf("ab"));
		System.out.println(s.lastIndexOf("ab"));
		
		//replace
		System.out.println(s.replace("bc","12"));
		System.out.println(s.replaceAll("bc", "12"));
	}
}
