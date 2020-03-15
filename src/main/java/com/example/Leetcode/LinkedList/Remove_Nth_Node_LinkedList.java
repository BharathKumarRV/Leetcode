/*
 * package com.example.Leetcode.LinkedList;
 * 
 * import java.util.List;
 * 
 * import org.springframework.boot.SpringApplication;
 * 
 * import com.example.Leetcode.LeetcodeApplication;
 * 
 * // Definition for singly-linked list.
 * 
 * public class Remove_Nth_Node_LinkedList {
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(LeetcodeApplication.class, args);
 * Remove_Nth_Node_LinkedList la = new Remove_Nth_Node_LinkedList();
 * 
 * ListNode obj=new ListNode(); obj.add ListNode res =
 * la.removeNthFromEnd(head,2); System.out.println(res);
 * 
 * }
 * 
 * public ListNode removeNthFromEnd(ListNode head, int n) {
 * 
 * ListNode start = new ListNode(0); ListNode slow = start, fast = start;
 * slow.next = head;
 * 
 * //Move fast in front so that the gap between slow and fast becomes n for(int
 * i=1; i<=n+1; i++) { fast = fast.next; } //Move fast to the end, maintaining
 * the gap while(fast != null) { slow = slow.next; fast = fast.next; } //Skip
 * the desired node slow.next = slow.next.next; return start.next; }
 * 
 * }
 */