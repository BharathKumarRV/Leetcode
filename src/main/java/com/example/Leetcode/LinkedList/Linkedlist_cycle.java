package com.example.Leetcode.LinkedList;

import java.util.HashSet;

public class Linkedlist_cycle {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	public static Linkedlist_cycle insert(Linkedlist_cycle list, int data) {
		// Create a new node with given data
		ListNode new_node = new ListNode(data);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			ListNode last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	public static boolean hasCycle_1(ListNode head) {
		ListNode walker = head;
		ListNode runner = head;
		while (runner != null && runner.next != null) {
			walker = walker.next;
			runner = runner.next.next;
			if (walker == runner)
				return true;
		}
		return false;
	}

	public static boolean hasCycle_2(ListNode head) {
		if (head == null || head.next == null)
			return false;
		HashSet<ListNode> nodeSet = new HashSet<>();
		while (head != null) {
			if (nodeSet.contains(head))
				return true;
			nodeSet.add(head);
			head = head.next;
		}
		return false;
	}

	private static HashSet<ListNode> nodeSet = new HashSet<>();

	public static boolean hasCycle_3(ListNode head) {
		if (head == null || head.next == null)
			return false;
		if (nodeSet.contains(head))
			return true;
		nodeSet.add(head);
		boolean res = hasCycle_3(head.next);
		return res;
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Linkedlist_cycle list = new Linkedlist_cycle();

		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);

		ListNode cur = list.head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = list.head.next;

		boolean res = hasCycle_1(list.head);
		System.out.println(res);

	}
}
