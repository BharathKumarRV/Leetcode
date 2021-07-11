package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Sort_linkedlist.ListNode;

public class Sort_linkedlist_BST {

	public static void main(String[] args) {
		/* Start with the empty list. */
		// LRU_cache list = new LRU_cache();
		Sort_linkedlist_BST list = new Sort_linkedlist_BST();
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		TreeNode res = sortedListToBST(list.head);
		System.out.println(res);

	}

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		ListNode mid = mid(head);
		TreeNode root = new TreeNode(mid.value);

		if (head == mid)
			return root;

		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}

	public static ListNode mid(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (prev != null)
			prev.next = null;

		return slow;
	}

	ListNode head;

	static class ListNode {
		ListNode prev, next;
		int value;

		ListNode(int _value) {
			value = _value;
		}
	}

	// Definition for a binary tree node.
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static Sort_linkedlist_BST insert(Sort_linkedlist_BST list, int data) {
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

}
