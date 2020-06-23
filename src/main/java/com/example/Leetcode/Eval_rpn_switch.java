package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Eval_rpn_switch {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		// int[] nums= {4,1,2,1,2};
		String s[] = { "4", "13", "5", "/", "+" };
		int res = evalRPN(s);
		System.out.println(res);

	}

	public static int evalRPN(String[] tokens) {
		int first, second;
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			 switch (token) {
             case "+":
                 stack.push(stack.pop() + stack.pop());
                 break;

             case "-":
                 first = stack.pop();
                 second = stack.pop();

                 stack.push(second - first);
                 break;

             case "*":
                 stack.push(stack.pop() * stack.pop());
                 break;

             case "/":
                 first = stack.pop();
                 second = stack.pop();

                 stack.push(second / first);
                 break;

             default:
                 stack.push(Integer.parseInt(token));
                 break;
		}
		
	}
		return stack.pop();
	}
}
