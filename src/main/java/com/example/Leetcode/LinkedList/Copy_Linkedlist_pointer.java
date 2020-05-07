package com.example.Leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Copy_Linkedlist_pointer {

	Node head;

	static class Node {
		int val;
		Node next;
		Node random;

		Node(int x) {
			val = x;
			next=null;
			random=null;
		}

		public Node getRandom() {
			return random;
		}

		public void setRandom(Node random) {
			this.random = random;
		}
		
		

	}
	
	public static Copy_Linkedlist_pointer insert(Copy_Linkedlist_pointer list, int data) {
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
		  if (head == null) return null;
		  
		  Map<Node, Node> map = new HashMap<Node, Node>();
		  
		  // loop 1. copy all the nodes
		  Node node = head;
		  while (node != null) {
		    map.put(node, new Node(node.val));
		    node = node.next;
		  }
		  
		  // loop 2. assign next and random pointers
		  node = head;
		  while (node != null) {
		    map.get(node).next = map.get(node.next);
		    map.get(node).random = map.get(node.random);
		    node = node.next;
		  }
		  
		  return map.get(head);
		}
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		Copy_Linkedlist_pointer list = new Copy_Linkedlist_pointer();

		//
		// ******INSERTION******
		//

		// Insert the values

		list = insert(list, 7);
		list = insert(list, 13);
		list = insert(list, 11);
		list = insert(list, 10);
		list = insert(list, 1);
		Node cur=list.head;
		while(cur.val!=7) {
			cur=cur.next;
		}
		cur.random=null;
		Node cur1=list.head;
		while(cur1.val!=13) {
			cur1=cur1.next;
		}
		cur1.random=cur;
		Node cur2=list.head;
		while(cur2.val!=1) {
			cur2=cur2.next;
		}
		cur2.random=cur;
		Node cur3=list.head;
		while(cur3.val!=11) {
			cur3=cur3.next;
		}
		cur3.random=cur2;
		Node cur4=list.head;
		while(cur4.val!=10) {
			cur4=cur4.next;
		}
		cur4.random=cur3;
		
		
		Node new_node=copyRandomList(list.head);
		System.out.println(new_node);

		/*
		 * insert(list, 1); insert(list, 2); insert(list, 3); insert(list, 4);
		 * insert(list, 5); insert(list, 6); insert(list, 7); insert(list, 8);
		 */

		// Print the LinkedList
	}
	
}
