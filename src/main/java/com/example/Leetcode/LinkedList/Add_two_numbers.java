package com.example.Leetcode.LinkedList;

public class Add_two_numbers {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	// Method to insert a new node
	public static Add_two_numbers insert(Add_two_numbers list, int data) {
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

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy_head = new ListNode(0);
		ListNode l3 = dummy_head;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int l1_val = ((l1 == null) ? 0 : l1.val);
			int l2_val = ((l2 == null) ? 0 : l2.val);
			int cur_sum = l1_val + l2_val + carry;
			int cur_val = cur_sum % 10;
			carry = cur_sum / 10;
			ListNode new_node = new ListNode(cur_val);
			l3.next = new_node;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
			l3 = l3.next;
		}
		return dummy_head.next;
	}

	public static void printList(Add_two_numbers list) {
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
		Add_two_numbers list = new Add_two_numbers();
		Add_two_numbers list2 = new Add_two_numbers();
		Add_two_numbers list3 = new Add_two_numbers();

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
