package util;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		Set<Value> set = new HashSet<>();
		
		Value v1 = new Value(10);
		Value v2 = new Value(20);
		Value v3 = new Value(30);
		Value v4 = new Value(30);
		
		
		set.add(v1);
		set.add(v2);
		set.add(v3);
		set.add(v4);
		
		System.out.println(set.contains(new Value(10)));
		
		set.remove(new Value(10));
		
		Iterator<Value> it = set.iterator();
		while(it.hasNext()) {
			Value v = it.next();
			System.out.println(v);
		}
	}
}
