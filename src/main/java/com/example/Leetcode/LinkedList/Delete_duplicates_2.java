package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Delete_duplicates_2.ListNode;

public class Delete_duplicates_2 {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}
	
	public static Delete_duplicates_2 insert(Delete_duplicates_2 list, int data) {
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
	
	public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }
	
	public static void printList(Delete_duplicates_2 list) {
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
	
	public static ListNode deleteDuplicates_recursive(ListNode head) {
	    if (head == null) return null;
	    
	    if (head.next != null && head.val == head.next.val) {
	        while (head.next != null && head.val == head.next.val) {
	            head = head.next;
	        }
	        return deleteDuplicates_recursive(head.next);
	    } else {
	        head.next = deleteDuplicates_recursive(head.next);
	    }
	    return head;
	}
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		Delete_duplicates_2 list = new Delete_duplicates_2();
		list = insert(list, 1);
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 3);
		list = insert(list, 4);
		printList(list);
		ListNode head = list.head;
		ListNode res = deleteDuplicates(head);
		list.head=res;
		printList(list);
	}
	
}
