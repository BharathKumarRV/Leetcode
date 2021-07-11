package com.example.Leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Linkedlist_intersection_bruteforce {

	static ListNode head1, head2;

	static class ListNode {

		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		for (ListNode a = headA; a != null; a = a.next) {
			for (ListNode b = headB; b != null; b = b.next) {
				if (a == b)
					return a;
			}
		}
		return null;
	}

	public static ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		ListNode node = headA;
		while (node != null) {
			set.add(node);
			node = node.next;
		}
		node = headB;
		while (node != null) {
			if (set.contains(node))
				return node;
			node = node.next;
		}
		return null;
	}

	public static void main(String[] args) {
		Linkedlist_intersection_bruteforce list = new Linkedlist_intersection_bruteforce();

		// creating first linked list
		list.head1 = new ListNode(4);
		list.head1.next = new ListNode(1);
		list.head1.next.next = new ListNode(8);
		list.head1.next.next.next = new ListNode(4);
		list.head1.next.next.next.next = new ListNode(5);

		// creating second linked list
		list.head2 = new ListNode(5);
		list.head2.next = new ListNode(0);
		list.head2.next.next = new ListNode(1);
		list.head2.next.next.next = new ListNode(8);
		list.head2.next.next.next.next = new ListNode(4);
		list.head2.next.next.next.next.next = new ListNode(5);

		System.out.println("The node of intersection is " + list.getIntersectionNode(list.head1, list.head2));
	}
}
