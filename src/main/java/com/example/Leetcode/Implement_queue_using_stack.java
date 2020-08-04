package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

import com.example.Leetcode.Implement_stack_using_queue.MyStack;

public class Implement_queue_using_stack {

	Stack<Integer> s1 = new Stack<>();
	  Stack<Integer> s2 = new Stack<>();
	  
	  // Push element x to the back of queue.
	  public void push(int x) {
	    s1.push(x);
	  }
	  
	  // Removes the element from in front of queue.
	  public void pop() {
	    peek();
	    s2.pop();
	  }
	  
	  // Get the front element.
	  public int peek() {
	    if (s2.isEmpty()) {
	      while (!s1.isEmpty()) {
	        s2.push(s1.pop());
	      }
	    }
	    
	    return s2.peek();
	  }
	  
	  // Return whether the queue is empty.
	  public boolean empty() {
	    return s1.isEmpty() && s2.isEmpty();
	  }
	  
	  public static void main(String[] args) {
			SpringApplication.run(LeetcodeApplication.class, args);
			Implement_queue_using_stack stack=new Implement_queue_using_stack();
			stack.push(1);
			stack.push(2);
			//System.out.println(stack.peek()); // returns 2
			stack.pop(); // returns 2
			System.out.println(stack.empty()); // returns false

		}
}
