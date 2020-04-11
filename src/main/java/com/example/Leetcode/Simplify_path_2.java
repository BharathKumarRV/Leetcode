package com.example.Leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Simplify_path_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); String res =
	 * simplifyPath("/a/../../b/../c//.//"); System.out.println(res); }
	 */

	public static String simplifyPath(String path) {
		 Deque<String> stack = new LinkedList<>();
		    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
		    for (String dir : path.split("/")) {
		        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
		        else if (!skip.contains(dir)) stack.push(dir);
		    }
		    String res = "";
		    for (String dir : stack) res = "/" + dir + res;
		    return res.isEmpty() ? "/" : res;
	}
}
