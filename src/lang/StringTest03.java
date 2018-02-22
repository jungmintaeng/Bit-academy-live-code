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
		
		//substring
		System.out.println(s.substring(3,7));
		
		//trim
		String str1 = "    ab    cd     ";
		System.out.println("-----" + str1 + "----");
		System.out.println("-----" + str1.trim() + "----");
		
		//case
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		
		//split
		String[] tokens = str1.trim().split(" ");
		for(String str  : tokens) {
			System.out.println(str);
		}
		
		tokens = "asdasd".split(" ");
		for(String str  : tokens) {
			System.out.println(str);
		}
	}
}
