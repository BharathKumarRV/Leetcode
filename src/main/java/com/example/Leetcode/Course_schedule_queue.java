package com.example.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.boot.SpringApplication;

public class Course_schedule_queue {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 1, 2, 1, 2 };
		int[][] prerequisites = { { 1, 0 }, { 0, 2 }, { 2, 3 } };
		boolean res = canFinish(4, prerequisites);
		System.out.println(res);

	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0)
			return false;
		int count = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][0]]++;
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				stack.push(i);
		}
		while (!stack.isEmpty()) {
			int x = stack.pop();
			count++;
			for (int i = 0; i < prerequisites.length; i++) {
				if (x == prerequisites[i][1]) {
					inDegree[prerequisites[i][0]]--;
					if (inDegree[prerequisites[i][0]] == 0)
						stack.push(prerequisites[i][0]);
				}
			}
		}

		return count == numCourses;

	}
}
