package lang;

public class WrapperClassTest2 {
	public static void main(String[] args) {
		System.out.println(Character.toLowerCase('C'));
		System.out.println(Character.isDigit('1'));
		
		String s = "1234";
/*		try {
			int i = Integer.parseInt(s);
		}catch(NumberFormatException nfex) {
			nfex.printStackTrace();
		}
		//이러한 코드는 좋지 않을 수 있다. 프로그램 로직상으로 해결할 수 있는 문제는 try catch를
		//쓰지 않는 것이 좋다.
		*/
		
		//-? : -가 있을 수 있고 없을 수 있다 + (소수점)이 있거나 없거나
		if(s.matches("-?\\d+(\\.\\d+)?") == false)
			System.out.println("숫자가 아닙니다.");
		else {
			int i = Integer.parseInt(s);
			System.out.println(i);
		}
		
		System.out.println(Integer.parseInt("10", 10));
		System.out.println(Integer.parseInt("A", 16));
		System.out.println(Integer.toBinaryString(255));
		System.out.println(Integer.toHexString(255));
		System.out.println(Double.parseDouble("44.56"));
		System.out.println(Long.parseLong("12412515"));
		System.out.println(String.valueOf(12345));
	}
}
