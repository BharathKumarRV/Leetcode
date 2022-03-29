package com.example.Leetcode.gragh;

import java.util.ArrayList;

public class BipartiteGraphDFS {

	static boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int color[]) {
		if (color[node] == -1) {
			color[node] = 1;
		}
		for (Integer it : adj.get(node)) {
			if (color[it] == -1) {
				color[it] = 1 - color[node];

				if (!dfsCheck(adj, it, color))
					return false;
			} else if (color[it] == color[node]) {
				return false;
			}
		}
		return true;
	}

	static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
		int color[] = new int[n];
		for (int i = 0; i < n; i++) {
			color[i] = -1;
		}
		for (int i = 0; i < n; i++) {
			if (color[i] == -1) {
				if (!dfsCheck(adj, i, color)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String args[]) {
		int n = 8;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(2).add(3);
		adj.get(3).add(2);

		adj.get(4).add(3);
		adj.get(3).add(4);

		adj.get(4).add(5);
		adj.get(5).add(4);

		adj.get(4).add(6);
		adj.get(6).add(4);
		
		adj.get(6).add(7);
		adj.get(7).add(6);

		adj.get(1).add(7);
		adj.get(7).add(1);

		if (checkBipartite(adj, n) == true)
			System.out.println("Yes Bipartite");
		else
			System.out.println("Not Bipartite");

	}
}
