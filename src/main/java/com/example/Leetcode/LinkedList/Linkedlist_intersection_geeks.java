package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Linkedlist_intersection.ListNode;

public class Linkedlist_intersection_geeks {

	 static ListNode head1, head2; 
	  
	    static class ListNode { 
	  
	        int data; 
	        ListNode next; 
	  
	        ListNode(int d) 
	        { 
	            data = d; 
	            next = null; 
	        } 
	    } 
	  
	    /*function to get the intersection point of two linked 
	    lists head1 and head2 */
	    static int getNode() 
	    { 
	        int c1 = getCount(head1); 
	        int c2 = getCount(head2); 
	        int d; 
	  
	        if (c1 > c2) { 
	            d = c1 - c2; 
	            return _getIntesectionNode(d, head1, head2); 
	        } 
	        else { 
	            d = c2 - c1; 
	            return _getIntesectionNode(d, head2, head1); 
	        } 
	    } 
	  
	    /* function to get the intersection point of two linked 
	     lists head1 and head2 where head1 has d more nodes than 
	     head2 */
	    static int _getIntesectionNode(int d, ListNode node1, ListNode node2) 
	    { 
	        int i; 
	        ListNode current1 = node1; 
	        ListNode current2 = node2; 
	        for (i = 0; i < d; i++) { 
	            if (current1 == null) { 
	                return -1; 
	            } 
	            current1 = current1.next; 
	        } 
	        while (current1 != null && current2 != null) { 
	            if (current1.data == current2.data) { 
	                return current1.data; 
	            } 
	            current1 = current1.next; 
	            current2 = current2.next; 
	        } 
	  
	        return -1; 
	    } 
	  
	    /*Takes head pointer of the linked list and 
	    returns the count of nodes in the list */
	    static int getCount(ListNode node) 
	    { 
	        ListNode current = node; 
	        int count = 0; 
	  
	        while (current != null) { 
	            count++; 
	            current = current.next; 
	        } 
	  
	        return count; 
	    } 
	  
	    public static void main(String[] args) 
	    { 
	    	Linkedlist_intersection_geeks list = new Linkedlist_intersection_geeks(); 
	  
	        // creating first linked list 
	    	list.head1 = new ListNode(4);
			list.head1.next = new ListNode(1);
			list.head1.next.next = new ListNode(8);
			list.head1.next.next.next = new ListNode(4);
			list.head1.next.next.next.next = new ListNode(5);

			// creating second linked list
			list.head2 = new ListNode(5);
			list.head2.next = new ListNode(0);
			list.head2.next.next = new ListNode(1);
			list.head2.next.next.next = new ListNode(8);
			list.head2.next.next.next.next = new ListNode(4);
			list.head2.next.next.next.next.next = new ListNode(5);
	  
	        System.out.println("The node of intersection is " + list.getNode()); 
	    } 
}
