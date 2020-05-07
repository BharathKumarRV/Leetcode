package com.example.Leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Copy_Linkedlist_pointer_dfs {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;
		ListNode random;

		ListNode(int x) {
			val = x;
			next=null;
			random=null;
		}

		public ListNode getRandom() {
			return random;
		}

		public void setRandom(ListNode random) {
			this.random = random;
		}
		
		

	}
	
	public static Copy_Linkedlist_pointer_dfs insert(Copy_Linkedlist_pointer_dfs list, int data) {
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
	
	 public static ListNode copyRandomList(ListNode head) {
	        Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
	        return copyRandomList(head, map);
	    }
	    private static ListNode copyRandomList(ListNode head, Map<ListNode, ListNode> map) {
	        if (head == null) {
	            return null;
	        }
	        if (map.containsKey(head)) {
	            return map.get(head);
	        }
	        ListNode newHead = new ListNode(head.val);
	        map.put(head, newHead);
	        newHead.next = copyRandomList(head.next, map);
	        newHead.random = copyRandomList(head.random, map);
	        
	        return newHead;
	        
	    }
	    
	public static void main(String[] args) {
		/* Start with the empty list. */
		Copy_Linkedlist_pointer_dfs list = new Copy_Linkedlist_pointer_dfs();

		//
		// ******INSERTION******
		//

		// Insert the values

		list = insert(list, 7);
		list = insert(list, 13);
		list = insert(list, 11);
		list = insert(list, 10);
		list = insert(list, 1);
		ListNode cur=list.head;
		while(cur.val!=7) {
			cur=cur.next;
		}
		cur.random=null;
		ListNode cur1=list.head;
		while(cur1.val!=13) {
			cur1=cur1.next;
		}
		cur1.random=cur;
		ListNode cur2=list.head;
		while(cur2.val!=1) {
			cur2=cur2.next;
		}
		cur2.random=cur;
		ListNode cur3=list.head;
		while(cur3.val!=11) {
			cur3=cur3.next;
		}
		cur3.random=cur2;
		ListNode cur4=list.head;
		while(cur4.val!=10) {
			cur4=cur4.next;
		}
		cur4.random=cur3;
		
		
		ListNode new_node=copyRandomList(list.head);
		System.out.println(new_node);

		/*
		 * insert(list, 1); insert(list, 2); insert(list, 3); insert(list, 4);
		 * insert(list, 5); insert(list, 6); insert(list, 7); insert(list, 8);
		 */

		// Print the LinkedList
	}
}
