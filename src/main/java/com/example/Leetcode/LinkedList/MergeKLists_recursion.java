package com.example.Leetcode.LinkedList;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class MergeKLists_recursion {

	public static Node mergeKLists(Node[] lists) {
		return partion(lists, 0, lists.length - 1);
	}

	public static Node partion(Node[] lists, int s, int e) {
		if (s == e)
			return lists[s];
		if (s < e) {
			int q = (s + e) / 2;
			Node l1 = partion(lists, s, q);
			Node l2 = partion(lists, q + 1, e);
			return merge(l1, l2);
		} else
			return null;
	}

	// This function is from Merge Two Sorted Lists.
	public static Node merge(Node l1, Node l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.data < l2.data) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}

	// function to print the singly linked list
	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	// Utility function to create a new node
	public Node push(int data) {
		Node newNode = new Node(data);
		newNode.next = null;
		return newNode;
	}

	public static void main(String args[]) {
		int k = 3; // Number of linked lists
		int n = 4; // Number of elements in each list

		// an array of pointers storing the head nodes
		// of the linked lists
		Node arr[] = new Node[4];

		arr[0] = new Node(1);
		arr[0].next = new Node(3);
		arr[0].next.next = new Node(5);
		arr[0].next.next.next = new Node(7);

		arr[1] = new Node(2);
		arr[1].next = new Node(4);
		arr[1].next.next = new Node(6);
		arr[1].next.next.next = new Node(8);

		arr[2] = new Node(0);
		arr[2].next = new Node(9);
		arr[2].next.next = new Node(10);
		arr[2].next.next.next = new Node(11);
		
		arr[3] = new Node(12);
		arr[3].next = new Node(14);
		arr[3].next.next = new Node(15);
		arr[3].next.next.next = new Node(17);

		// Merge all lists
		Node head = mergeKLists(arr);
		printList(head);
	}
}

// This code is contributed by Gaurav Tiwari
