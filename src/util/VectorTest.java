package util;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		v.add("둘리");
		v.add("마이콜");
		v.add("도우너");
		
		/*
		 * Vector 순회
		 */
		
		System.out.println("===VECTOR 순회===");
		
		//1.
		int count = v.size();
		for(int i = 0; i  < count; i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		System.out.println("================");
		
		v.remove(1);
		
		//2.
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
}
