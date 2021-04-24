package com.example.Leetcode.TreeNode;

import com.example.Leetcode.LinkedList.Add_two_numbers;

public class SortedList_to_BST {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}
	
	public static SortedList_to_BST insert(SortedList_to_BST list, int data) {
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
	
	 public static TreeNode sortedListToBST(ListNode head) {
	        if(head == null)
	            return null;
	        
	        ListNode mid = mid(head);
	        TreeNode root = new TreeNode(mid.val);
	        
	        if(head == mid)
	            return root;
	        
	        root.left = sortedListToBST(head);
	        root.right = sortedListToBST(mid.next);
	        return root;
	    }
	    
	    public static ListNode mid(ListNode head) {
	        ListNode fast = head;
	        ListNode slow = head;
	        ListNode prev=head;
	        while(fast!=null && fast.next!=null){
	            prev=slow;
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        if(prev != null)
	            prev.next = null;
	        
	        return slow;
	    }
	    
	    public static void main(String args[]) {

	    	SortedList_to_BST tree = new SortedList_to_BST();
			SortedList_to_BST list=new SortedList_to_BST();
			list = insert(list, 2);
			list = insert(list, 4);
			list = insert(list, 3);
			list = insert(list, 5);
			list = insert(list, 6);
			
			tree.root=sortedListToBST(list.head);
			System.out.println(tree.root);

		}
}
