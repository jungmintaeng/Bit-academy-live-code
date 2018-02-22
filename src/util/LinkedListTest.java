package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		
		//순회1
		int count = list.size();
		for(int i = 0 ; i < count; i++) {
			System.out.println(list.get(i));
		}
		
		list.remove(1);
		
		//순회2
		Iterator<String> it= list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//순회3
		for(String s : list) {
			System.out.println(s);
		}
	}
}
