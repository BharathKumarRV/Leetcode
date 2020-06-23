package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.LinkedList.ListNode;

public class Linkedlist_intersection {

	ListNode head1, head2;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		 int lenA = length(headA), lenB = length(headB);
		    // move headA and headB to the same start point
		    while (lenA > lenB) {
		        headA = headA.next;
		        lenA--;
		    }
		    while (lenA < lenB) {
		        headB = headB.next;
		        lenB--;
		    }
		/*
		 * while (headA != headB) { headA = headA.next; headB = headB.next; } return
		 * headA;
		 */
		    // find the intersection until end
		    while (headA !=null && headB!=null) {
		    	if(headA.val==headB.val) {
		    		return headA;
		    	}
		        headA = headA.next;
		        headB = headB.next;
		    }
		    return headA;
	}
	
	private static int length(ListNode node) {
	    int length = 0;
	    while (node != null) {
	        node = node.next;
	        length++;
	    }
	    return length;
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Linkedlist_intersection list = new Linkedlist_intersection();
		// Linkedlist_intersection list1 = new Linkedlist_intersection();

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

		// Print the LinkedList
		ListNode res = getIntersectionNode(list.head1, list.head2);
		System.out.println(res.val);

	}

}
