package com.example.Leetcode.gragh;

import java.util.ArrayList;
import java.util.List;

import com.example.Leetcode.gragh.Clone_graph.Node;

public class Courseschedule {

	public static void main(String args[]) {
		int prerrequisites[][] = { { 1, 0 }, { 0, 1 } };
		boolean res = canFinish(2, prerrequisites);
		System.out.println(res);

	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<Integer> adj[] = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			adj[i] = new ArrayList();

		for (int pre[] : prerequisites) {
			adj[pre[0]].add(pre[1]);
		}
		int[] visited = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0 && !dfs(adj, visited, i))
				return false;
		}
		return true;
	}

	private static boolean dfs(ArrayList<Integer>[] adj, int[] visited, int v) {
		if (visited[v] == 1)
			return false;
		visited[v] = 1;

		for (int ad : adj[v]) {
			if (!dfs(adj, visited, ad))
				return false;
		}
		visited[v] = 2;
		return true;
	}
}
