package com.example.Leetcode.LinkedList;

import java.util.Stack;

import com.example.Leetcode.LinkedList.Reorder_list_recursive.ListNode;

public class Reorder_list_2 {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}
	
	public static Reorder_list_2 insert(Reorder_list_2 list, int data) {
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
	
	public static void reorderList(ListNode head) {
		Stack<ListNode> st=new Stack<ListNode>();
		ListNode cur=head;
		while(cur!=null) {
			st.push(cur);
		}
		
		int n=st.size();
		if(n<=2) {
			return;
		}
		
		cur=head;
		ListNode next;
		for(int i=0;i<n/2;i++) {
			next=cur.next;
			cur.next=st.pop();
			cur=cur.next;
			cur.next=next;
			cur=cur.next;
		}
		
		cur.next=null;
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		Reorder_list_2 list = new Reorder_list_2();

		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);

		reorderList(list.head);
	}
	
}
