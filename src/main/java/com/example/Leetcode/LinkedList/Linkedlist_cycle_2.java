package com.example.Leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Linkedlist_cycle_2 {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}
	
	public static Linkedlist_cycle_2 insert(Linkedlist_cycle_2 list, int data) {
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
	
	public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow){
                ListNode start = head; 
                while (start != slow){
                    slow = slow.next;
                    start = start.next;
                }
                return slow;
            }
        }
        return null;
    }
	
	/*
	 * public static ListNode detectCycle(ListNode head) { // creating set for add
	 * the visited nodes while traversing Set<ListNode> set = new HashSet<>();
	 * 
	 * // pointer for traversing the Linked List ListNode ptr = head;
	 * 
	 * // traversing the linkedlist till the pointer is not null (if null, it means
	 * there is no cycle) and // the set does not contain the current pointer(if
	 * contains the current // pointer it means we came across the pointer while
	 * traversing before)
	 * 
	 * while(ptr!=null && !set.contains(ptr) ){ set.add(ptr); ptr=ptr.next; }
	 * 
	 * return ptr; }
	 */
	 
	//https://leetcode.com/problems/linked-list-cycle-ii/discuss/44893/My-two-cents-still-O(1)-memory-and-O(n)-time
	public static void main(String[] args) {
		/* Start with the empty list. */
		Linkedlist_cycle_2 list = new Linkedlist_cycle_2();

		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);

		ListNode cur = list.head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = list.head.next;

		ListNode begin = detectCycle(list.head);
		System.out.println(begin);
	}
}
