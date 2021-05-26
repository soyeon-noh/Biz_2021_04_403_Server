package com.callor.todo.exec;

import java.util.HashMap;
import java.util.Map;

public class Map_01 {
	
	/*
	 * Map<K, V>
	 * List 데이터와 함께
	 * Java에서 매우 많이 사용되는 자료구조
	 * 
	 * Key, Value 형식으로 데이터를 저장하고
	 * 읽을 수 있는 자료구조
	 * 
	 * List Type 인 경우
	 * list.add(값) : List에 저장할 때
	 * list.get(index) : List에서 값 읽을 때
	 * 
	 * Map Type 인 경우
	 * map.put(key,값) : Map에 저장할 때
	 * map.get(key) : Map에서 값 읽을 때
	 */
	
	public static void main(String[] args) {
		// key값은 보통 String
		
		// Map interface로 선언하고
		// HashMap으로 생성하기 // VO 없어도 되게 만든대
		Map<String, String> maps
			= new HashMap<String, String>();

		maps.put("이름", "홍길동");
		maps.put("나이", "30");
		maps.put("직업", "IT 개발자");
		
		System.out.println(maps.get("이름"));
		System.out.println(maps.get("나이"));
		System.out.println(maps.get("직업"));
	}
}
