package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Copy_Linkedlist_pointer.Node;

public class Copy_Linkedlist_pointer_2 {

	Node head;

	static class Node {
		int val;
		Node next;
		Node random;

		Node(int x) {
			val = x;
			next = null;
			random = null;
		}

		public Node getRandom() {
			return random;
		}

		public void setRandom(Node random) {
			this.random = random;
		}

	}

	public static Copy_Linkedlist_pointer_2 insert(Copy_Linkedlist_pointer_2 list, int data) {
		// Create a new node with given data
		Node new_node = new Node(data);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	public static Node copyRandomList(Node head) {
		Node iter = head;
		Node front = head;

		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			front = iter.next;

			Node copy = new Node(iter.val);
			iter.next = copy;
			copy.next = front;

			iter = front;
		}

		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}

		// Third round: restore the original list, and extract the copy list.
		iter = head;
		Node pseudoHead = new Node(0);
		Node copy = pseudoHead;

		while (iter != null) {
			front = iter.next.next;

			// extract the copy
			copy.next = iter.next;
			copy = copy.next;

			// restore the original list
			iter.next = front;

			iter = front;
		}

		return pseudoHead.next;
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Copy_Linkedlist_pointer_2 list = new Copy_Linkedlist_pointer_2();

		//
		// ******INSERTION******
		//

		// Insert the values

		list = insert(list, 7);
		list = insert(list, 13);
		list = insert(list, 11);
		list = insert(list, 10);
		list = insert(list, 1);
		Node cur = list.head;
		while (cur.val != 7) {
			cur = cur.next;
		}
		cur.random = null;
		Node cur1 = list.head;
		while (cur1.val != 13) {
			cur1 = cur1.next;
		}
		cur1.random = cur;
		Node cur2 = list.head;
		while (cur2.val != 1) {
			cur2 = cur2.next;
		}
		cur2.random = cur;
		Node cur3 = list.head;
		while (cur3.val != 11) {
			cur3 = cur3.next;
		}
		cur3.random = cur2;
		Node cur4 = list.head;
		while (cur4.val != 10) {
			cur4 = cur4.next;
		}
		cur4.random = cur3;

		Node new_node = copyRandomList(list.head);
		System.out.println(new_node);

	}
}
