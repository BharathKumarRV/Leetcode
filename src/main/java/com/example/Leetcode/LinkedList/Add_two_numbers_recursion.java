package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Add_two_numbers.ListNode;

public class Add_two_numbers_recursion {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return helper(l1, l2, 0);
	}

	private static ListNode helper(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null) {
			if (carry == 1)
				return new ListNode(1);
			else
				return null;
		}

		int l1_val = ((l1 == null) ? 0 : l1.val);
		int l2_val = ((l2 == null) ? 0 : l2.val);
		int cur_sum = l1_val + l2_val + carry;
		carry = cur_sum / 10;
		cur_sum = cur_sum % 10;

		ListNode node = new ListNode(cur_sum);
		if (l1 == null)
			node.next = helper(l1, l2.next, carry);
		else if (l2 == null)
			node.next = helper(l1.next, l2, carry);
		else
			node.next = helper(l1.next, l2.next, carry);
		return node;

	}

	public static Add_two_numbers_recursion insert(Add_two_numbers_recursion list, int data) {
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

	public static void printList(Add_two_numbers_recursion list) {
		ListNode currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.val + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Add_two_numbers_recursion list = new Add_two_numbers_recursion();
		Add_two_numbers_recursion list2 = new Add_two_numbers_recursion();
		Add_two_numbers_recursion list3 = new Add_two_numbers_recursion();

		//
		// ******INSERTION******
		//

		// Insert the values

		list = insert(list, 2);
		list = insert(list, 4);
		list = insert(list, 3);
		list2 = insert(list2, 5);
		list2 = insert(list2, 6);
		list2 = insert(list2, 6);

		/*
		 * insert(list, 1); insert(list, 2); insert(list, 3); insert(list, 4);
		 * insert(list, 5); insert(list, 6); insert(list, 7); insert(list, 8);
		 */

		// Print the LinkedList
		printList(list);
		printList(list2);
		ListNode head = addTwoNumbers(list.head, list2.head);
		list3.head = head;
		printList(list3);

	}
}
