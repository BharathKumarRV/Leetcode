package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Reorder_list.ListNode;

public class Reorder_list_recursive {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	public static Reorder_list_recursive insert(Reorder_list_recursive list, int data) {
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
	        if (head == null) {
	            return;
	        }
	        
	        tail(head, head);  
	        System.out.println();
	    }
	    
	    // Performs tail end recursion. Starts inserting nodes into the first half once we find the end. 
	    private static ListNode tail(ListNode head, ListNode curr) {
	        // Recurse until we find the tail
	        if (curr.next != null) {
	            head = tail(head, curr.next);
	        }
	        
	        // Insertions complete. Stop
	        if (head == null) {
	            return null;
	        }

	        ListNode second = head.next;
	        
	        // Check to see if we've reached the end of the new merged linked list
	        if (head == curr || curr == second) {
	            // Make sure to terminate the linked list
	            curr.next = null;
	            return null;
	        }
	        //1 2 3 - 6 5 4 // 1 6 2 5 3 4
	        // Insert node from end (curr) between head and second
	        // head -> curr -> second
	        head.next = curr; 
	        curr.next = second;
	        
	        // Return where the next insertion should begin
	        return second;
	    }
	
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		Reorder_list_recursive list = new Reorder_list_recursive();

		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);

		reorderList(list.head);
	}
}
