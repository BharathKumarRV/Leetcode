package com.example.Leetcode.LinkedList;

import java.util.LinkedHashMap;

public class LRU_cache_2 {

	private static LinkedHashMap<Integer, Integer> map;
	private static int SIZE;
	public LRU_cache_2(int capacity) {
	    map = new LinkedHashMap<>();
	    SIZE = capacity;
	}

	public static int get(int key) {
	    if(map.containsKey(key)) {
	        int value = map.remove(key);
	        map.put(key, value);
	        return value;
	    }
	    return -1;
	}

	public static void put(int key, int value) {
	    if(map.containsKey(key)) {
	        map.remove(key);
	    }else if(map.size() == SIZE) {
	        map.remove(map.keySet().iterator().next());
	    }
	    map.put(key, value);
	}
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		// LRU_cache list = new LRU_cache();
		LRU_cache_2 cache=new LRU_cache_2(2);
		put(2, 0);
		put(3, 1);
		int res = get(2);
		System.out.println(res);
		put(4, 2);
		int res1 = get(3);
		System.out.println(res1);
		int res2 = get(4);
		System.out.println(res2);

	}
}
