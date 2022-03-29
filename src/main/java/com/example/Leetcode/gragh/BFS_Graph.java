package com.example.Leetcode.gragh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Graph {

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
				// adj.get(v).add(u);
			}
			Solution obj = new Solution();
			ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
			for (int i = 0; i < ans.size(); i++)
				System.out.print(ans.get(i) + " ");
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Solution {
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		ArrayList<Integer> bfs = new ArrayList<>();
		boolean vis[] = new boolean[V];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= V; i++) {
			if (!vis[i]) {
				q.add(i);
				vis[i] = true;

				while (!q.isEmpty()) {
					Integer node = q.poll();
					bfs.add(node);

					// Get all adjacent vertices of the dequeued vertex s
					// If a adjacent has not been visited, then mark it
					// visited and enqueue it
					for (Integer it : adj.get(node)) {
						if (vis[it] == false) {
							vis[it] = true;
							q.add(it);
						}
					}
				}

				// Code here
			}
		}
		return bfs;
	}
}
