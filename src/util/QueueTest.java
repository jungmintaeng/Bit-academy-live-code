package util;

import java.util.Queue;
import java.util.LinkedList;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("둘리");
		queue.offer("마이콜");
		queue.offer("도우너");
		queue.offer("길동");
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		//비어있는 상태
		System.out.println(queue.isEmpty());
		System.out.println(queue.poll());	
	}
}
