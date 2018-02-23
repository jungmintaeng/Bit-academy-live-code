package util;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		stack.push("둘리");
		stack.push("마이콜");
		stack.push("도우너");
		stack.push("길동");
		
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());//길동
		System.out.println(stack.pop());//도우너
		System.out.println(stack.peek());//마이콜. pop되지 않는다
		System.out.println(stack.pop());//마이콜
		
		//stack은 비어 있는 경우 pop() 호출 시 예외가 발생한다.
/*		while(!stack.isEmpty())
			stack.pop();
		stack.pop();*/
	}
}
