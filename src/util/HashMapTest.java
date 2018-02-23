package util;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("둘리", 100);
		map.put("마이콜", 50);
		map.put("도우너", 80);
		map.put("길동", 90);
		System.out.println("===========");
		//중복 테스트
		System.out.println(map.get("둘리"));
		map.put("둘리", 54);
		System.out.println(map.get("둘리"));
		System.out.println("===========");
		map.remove("둘리");
		for(String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
		System.out.println("===========");
		//평균 구하기
		int sum = 0;
		for(String key : map.keySet()) {
			sum += map.get(key);
		}
		System.out.println((double)sum / map.keySet().size());
	}
}