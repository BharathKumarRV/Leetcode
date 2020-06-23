package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Insertion_sortlist_recursive.ListNode;

public class Sort_linkedlist {

	ListNode head;

	static class ListNode {
		ListNode prev, next;
		int value;

		ListNode(int _value) {
			value = _value;
		}
	}
	

	public static Sort_linkedlist insert(Sort_linkedlist list, int data) {
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
	
	 public static ListNode sortList(ListNode head) {
		    if (head == null || head.next == null)
		      return head;
		        
		    // step 1. cut the list to two halves
		    ListNode prev = null, slow = head, fast = head;
		    
		    while (fast != null && fast.next != null) {
		      prev = slow;
		      slow = slow.next;
		      fast = fast.next.next;
		    }
		    
		    prev.next = null;
		    
		    // step 2. sort each half
		    ListNode l1 = sortList(head);
		    ListNode l2 = sortList(slow);
		    
		    // step 3. merge l1 and l2
		    return merge(l1, l2);
		  }
		  
		 static  ListNode merge(ListNode l1, ListNode l2) {
		    ListNode l = new ListNode(0), p = l;
		    
		    while (l1 != null && l2 != null) {
		      if (l1.value < l2.value) {
		        p.next = l1;
		        l1 = l1.next;
		      } else {
		        p.next = l2;
		        l2 = l2.next;
		      }
		      p = p.next;
		    }
		    
		    if (l1 != null)
		      p.next = l1;
		    
		    if (l2 != null)
		      p.next = l2;
		    
		    return l.next;
		  }
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		// LRU_cache list = new LRU_cache();
		Sort_linkedlist list=new Sort_linkedlist();
		list=insert(list,4);
		list=insert(list,2);
		list=insert(list,1);
		list=insert(list,3);
		ListNode res=sortList(list.head);
		System.out.println(res);

	}
}
