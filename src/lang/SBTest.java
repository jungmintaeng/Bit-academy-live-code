package lang;

public class SBTest {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("this"); // BufferSize 잡아주려면 생성자에 숫자 입력
		/*
		 * length : 문자열의 길이
		 * capacity : 실제 버퍼의 사이즈
		 */
		System.out.println(sb.length() + ":" + sb.capacity());
		
		//문자열 추가
		sb.append("is pencil");
		System.out.println(sb);
		
		//삽입
		sb.insert(7, "ㅁㄴㅇ");
		System.out.println(sb);
		
		//치환
		sb.replace(7, 9, "헿");
		System.out.println(sb);
		
		//버퍼 크기 조정
		sb.setLength(0);
		System.out.println(sb + "길이0");
		
		String s1 = "Hello" + "world" + 10 + true;
		String s2 = new StringBuffer("Hello").append("world").append(10).append(true).toString();
		//내부적으로 s1은 s2처럼 돌아간다.
	}
}
