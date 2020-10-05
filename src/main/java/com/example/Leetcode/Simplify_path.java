package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Simplify_path {

	
	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = simplifyPath("/a/../../b/../c//.//");
		System.out.println(res);
	}
	 

	public static String simplifyPath(String path) {
	    Stack<String> stack = new Stack();
	    String[] dirs= path.split("/");
	    for (String dir :dirs) {
	        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
	        else if (!dir.equals(".") && !dir.equals("") && !dir.equals("..")) {
	        	stack.push(dir);
	        }
	    }
	   List<String> res=new ArrayList<>(stack);
	   return "/"+String.join("/",res);
	}
}
