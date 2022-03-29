package com.example.Leetcode.LinkedList;

public class Insertion_sortlist {
	
	ListNode head;
	
	static class ListNode {
		ListNode prev, next;
		int val;

		ListNode(int _value) {
			val = _value;
		}
	}
	
	public static Insertion_sortlist insert(Insertion_sortlist list, int data) {
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

	public static ListNode insertionSortList(ListNode head) {
		 ListNode dummy = new ListNode(0);
	     ListNode prev = dummy;

	    while (head != null) {
	        ListNode temp = head.next;
	        
	        /* Before insert, the prev is at the last node of the sorted list.
	           Only the last node's value is larger than the current inserting node 
	           should we move the  back to the head*/
	        //whenever we find head less than prev pointer need scan elements from beginning
	        if (prev.val >= head.val) prev = dummy;

	        while (prev.next != null && head.val>prev.next.val) {
	            prev = prev.next;
	        }
	        
	        head.next = prev.next; // found an place for head 
	        prev.next = head; //prev.next shd have list of elements
	        // prev = dummy; // Don't set prev to the head of the list after insert
	        head = temp;
	    }
	    return dummy.next;
	}
	
	public static ListNode insertionSortList_2(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode curr = head, prev = start;
        while(curr != null){
            if(curr.next != null && (curr.next.val < curr.val)){
                // Insertion 
                while(prev.next != null && (prev.next.val < curr.next.val))
                    prev = prev.next;
                ListNode temp = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = temp;
                prev = start;
            } else
                curr = curr.next;
        }
        return start.next;
    }
	
	 public static ListNode insertionSortList_3(ListNode head) {
	        ListNode dummy=new ListNode(0);
	        ListNode cur=head;
	        
	        while(cur!=null){
	            ListNode prev=dummy;
	            ListNode next=dummy.next;
	            
	            while(next!=null){
	                if(cur.val<next.val){
	                    break;
	                }
	                prev=prev.next;
	                next=next.next;
	            }
	            
	            ListNode temp=cur.next;
	            cur.next=next;
	            prev.next=cur;
	            cur=temp;
	        }
	        
	        return dummy.next;
	    }
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		// LRU_cache list = new LRU_cache();
		Insertion_sortlist list=new Insertion_sortlist();
		list=insert(list,-1);
		list=insert(list,5);
		list=insert(list,3);
		list=insert(list,4);
		list=insert(list,0);
		ListNode res=insertionSortList_3(list.head);
		System.out.println(res);

	}
	
}
