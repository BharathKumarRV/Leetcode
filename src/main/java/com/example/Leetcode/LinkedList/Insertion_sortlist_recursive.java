package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Insertion_sortlist.ListNode;

public class Insertion_sortlist_recursive {

	ListNode head;

	static class ListNode {
		ListNode prev, next;
		int value;

		ListNode(int _value) {
			value = _value;
		}
	}
	

	public static Insertion_sortlist_recursive insert(Insertion_sortlist_recursive list, int data) {
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
	
	public static ListNode insertionSortList(ListNode head) {
	    if (head == null || head.next == null) {
	        return head;
	    }
	    ListNode p = insertionSortList(head.next);
	    if (head.value <= p.value) {  // already sorted
	        head.next = p;
	        return head;
	    }
	    ListNode ret = p;
	    while (p.next != null && p.next.value < head.value) {
	        p = p.next;
	    }
	    head.next = p.next;
	    p.next = head;
	    return ret;
	}
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		// LRU_cache list = new LRU_cache();
		Insertion_sortlist_recursive list=new Insertion_sortlist_recursive();
		list=insert(list,-1);
		list=insert(list,5);
		list=insert(list,3);
		list=insert(list,4);
		list=insert(list,0);
		ListNode res=insertionSortList(list.head);
		System.out.println(res);

	}

}
