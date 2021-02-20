package com.example.Leetcode.LinkedList;

// Java implementation to merge
// k sorted linked lists
// Using MIN HEAP method
import java.util.PriorityQueue;

class ListNode {
	int data;
	ListNode next;

	ListNode(int data) {
		this.data = data;
		next = null;
	}
}

public class MergeKLists {

	// function to merge k
	// sorted linked lists
	public static ListNode mergeKSortedLists(ListNode arr[], int k) {
		  if (arr==null || arr.length==0) return null;
	        
	        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(arr.length, (a,b)-> a.data-b.data);
	        
	        ListNode dummy = new ListNode(0);
	        ListNode tail=dummy;
	        
	        for (ListNode node:arr)
	            if (node!=null)
	                queue.add(node);
	            
	        while (!queue.isEmpty()){
	            tail.next=queue.poll();
	            tail=tail.next;
	            
	            if (tail.next!=null)
	                queue.add(tail.next);
	        }
	        return dummy.next;
	}

	// function to print the singly linked list
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	// Utility function to create a new node
	public ListNode push(int data) {
		ListNode newListNode = new ListNode(data);
		newListNode.next = null;
		return newListNode;
	}

	public static void main(String args[]) {
		int k = 3; // Number of linked lists
		int n = 4; // Number of elements in each list

		// an array of pointers storing the head nodes
		// of the linked lists
		ListNode arr[] = new ListNode[k];

		arr[0] = new ListNode(1);
		arr[0].next = new ListNode(3);
		arr[0].next.next = new ListNode(5);
		arr[0].next.next.next = new ListNode(7);

		arr[1] = new ListNode(2);
		arr[1].next = new ListNode(4);
		arr[1].next.next = new ListNode(6);
		arr[1].next.next.next = new ListNode(8);

		arr[2] = new ListNode(0);
		arr[2].next = new ListNode(9);
		arr[2].next.next = new ListNode(10);
		arr[2].next.next.next = new ListNode(11);

		// Merge all lists
		ListNode head = mergeKSortedLists(arr, k);
		printList(head);
	}
}


// This code is contributed by Gaurav Tiwari
