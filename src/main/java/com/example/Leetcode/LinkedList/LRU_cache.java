package com.example.Leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRU_cache {

	static Node head = new Node(0, 0);
	static Node tail = new Node(0, 0);
	static Map<Integer, Node> map = new HashMap();
	static int capacity;

	public LRU_cache(int _capacity) {
		capacity = _capacity;
		head.next = tail;
		tail.prev = head;
	}

	public static int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			insert(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public static void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		if (map.size() == capacity) {
			remove(tail.prev);
		}
		insert(new Node(key, value));
	}

	private static void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private static void insert(Node node) {
		map.put(node.key, node);
		Node headNext = head.next;
		head.next = node;
		node.prev = head;
		headNext.prev = node;
		node.next = headNext;
	}

	static class Node {
		Node prev, next;
		int key, value;

		Node(int _key, int _value) {
			key = _key;
			value = _value;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		// LRU_cache list = new LRU_cache();
		LRU_cache cache=new LRU_cache(2);
		put(1, 100);
		put(2, 101);
		int res = get(2);
		System.out.println(res);
		put(3, 102);
		int res1 = get(1);
		System.out.println(res1);
		int res2 = get(3);
		System.out.println(res2);

	}
}
