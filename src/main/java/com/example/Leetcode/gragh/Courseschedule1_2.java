package com.example.Leetcode.gragh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Courseschedule1_2 {

	public static void main(String args[]) {
		int prerrequisites[][] = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } };
		boolean res = canFinish(5, prerrequisites);
		System.out.println(res);

	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<Integer> adj[] = new ArrayList[numCourses];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < numCourses; i++)
			adj[i] = new ArrayList();

		for (int pre[] : prerequisites) {
			adj[pre[0]].add(pre[1]);
		}

		for (int i = 0; i < numCourses; i++) {
			map.put(i, adj[i]);
		}
		Set<Integer> visit = new HashSet<Integer>();

		for (int i = 0; i < numCourses; i++) {
			if (!dfs(map, visit, i))
				return false;
		}
		return true;
	}

	private static boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> visit, int v) {
		if (visit.contains(v))
			return false;
		if (map.get(v).isEmpty())
			return true;
		visit.add(v);
		for (Integer ad : map.get(v)) {
			if (!dfs(map, visit, ad))
				return false;
		}
		visit.remove(v);
		map.remove(v);
		return true;
	}
}
