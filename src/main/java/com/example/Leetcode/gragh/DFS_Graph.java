package com.example.Leetcode.gragh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFS_Graph {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			String[] s = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < V; i++)
				adj.add(new ArrayList<Integer>());
			for (int i = 0; i < E; i++) {
				String[] S = br.readLine().trim().split(" ");
				int u = Integer.parseInt(S[0]);
				int v = Integer.parseInt(S[1]);
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			DFSSolution obj = new DFSSolution();
			ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
			for (int i = 0; i < ans.size(); i++)
				System.out.print(ans.get(i) + " ");
			System.out.println();
		}
	}
}
// } Driver Code Ends

class DFSSolution {
	public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs) {
		storeDfs.add(node);
		vis[node] = true;
		for (Integer it : adj.get(node)) {
			if (vis[it] == false) {
				dfs(it, vis, adj, storeDfs);
			}
		}
	}

	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> storeDfs = new ArrayList<>();
		boolean vis[] = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			if (!vis[i])
				dfs(i, vis, adj, storeDfs);
		}

		return storeDfs;
	}
}
