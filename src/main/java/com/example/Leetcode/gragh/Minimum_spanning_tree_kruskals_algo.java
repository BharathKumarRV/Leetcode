package com.example.Leetcode.gragh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class KruskalsNode {
	private int u;
	private int v;
	private int weight;

	KruskalsNode(int _u, int _v, int _w) {
		u = _u;
		v = _v;
		weight = _w;
	}

	KruskalsNode() {
	}

	int getV() {
		return v;
	}

	int getU() {
		return u;
	}

	int getWeight() {
		return weight;
	}

}

class SortComparator implements Comparator<KruskalsNode> {
	@Override
	public int compare(KruskalsNode node1, KruskalsNode node2) {
		if (node1.getWeight() < node2.getWeight())
			return -1;
		if (node1.getWeight() > node2.getWeight())
			return 1;
		return 0;

	}
}

class Minimum_spanning_tree_kruskals_algo {
	private int findPar(int u, int parent[]) {
		if (u == parent[u])
			return u;
		return parent[u] = findPar(parent[u], parent);
	}

	private void union(int u, int v, int parent[], int rank[]) {
		u = findPar(u, parent);
		v = findPar(v, parent);
		if (rank[u] < rank[v]) {
			parent[u] = v;
		} else if (rank[v] < rank[u]) {
			parent[v] = u;
		} else {
			parent[v] = u;
			rank[u]++;
		}
	}

	void KruskalAlgo(ArrayList<KruskalsNode> adj, int N) {
		Collections.sort(adj, new SortComparator());
		int parent[] = new int[N];
		int rank[] = new int[N];

		for (int i = 0; i < N; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		int costMst = 0;
		ArrayList<KruskalsNode> mst = new ArrayList<KruskalsNode>();
		for (KruskalsNode it : adj) {
			if (findPar(it.getU(), parent) != findPar(it.getV(), parent)) {
				costMst += it.getWeight();
				mst.add(it);
				union(it.getU(), it.getV(), parent, rank);
			}
		}
		System.out.println(costMst);
		for (KruskalsNode it : mst) {
			System.out.println(it.getU() + " " + it.getV());
		}
	}

	public static void main(String args[]) {
		int n = 5;
		ArrayList<KruskalsNode> adj = new ArrayList<KruskalsNode>();

		adj.add(new KruskalsNode(0, 1, 2));
		adj.add(new KruskalsNode(0, 3, 6));
		adj.add(new KruskalsNode(1, 3, 8));
		adj.add(new KruskalsNode(1, 2, 3));
		adj.add(new KruskalsNode(1, 4, 5));
		adj.add(new KruskalsNode(2, 4, 7));

		Minimum_spanning_tree_kruskals_algo obj = new Minimum_spanning_tree_kruskals_algo();
		obj.KruskalAlgo(adj, n);

	}
}
