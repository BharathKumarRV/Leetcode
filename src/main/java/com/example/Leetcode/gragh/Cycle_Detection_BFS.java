package com.example.Leetcode.gragh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle_Detection_BFS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			String[] s = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for (int i = 0; i < V; i++)
				adj.add(i, new ArrayList<Integer>());
			for (int i = 0; i < E; i++) {
				String[] S = br.readLine().trim().split(" ");
				int u = Integer.parseInt(S[0]);
				int v = Integer.parseInt(S[1]);
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			CycleDetectionSolution obj = new CycleDetectionSolution();
			boolean ans = obj.isCycle(V, adj);
			if (ans)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}// } Driver Code Ends

class Node {
	int first;
	int second;

	public Node(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

class CycleDetectionSolution {
	static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[]) {
		Queue<Node> q = new LinkedList<>(); // BFS
		q.add(new Node(s, -1));
		vis[s] = true;

		while (!q.isEmpty()) {
			int node = q.peek().first;
			int par = q.peek().second;
			q.remove();

			for (Integer it : adj.get(node)) {
				if (vis[it] == false) {
					q.add(new Node(it, node));
					vis[it] = true;
				}

				else if (par != it)
					return true;
			}
		}

		return false;
	}

	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean vis[] = new boolean[V];
		Arrays.fill(vis, false);

		for (int i = 0; i < V; i++)
			if (vis[i] == false)
				if (checkForCycle(adj, i, vis))
					return true;

		return false;
	}
}
