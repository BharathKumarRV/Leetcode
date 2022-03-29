package com.example.Leetcode.gragh;

import java.util.ArrayList;

class SpanNode {
	private int v;
	private int weight;

	SpanNode(int _v, int _w) {
		v = _v;
		weight = _w;
	}

	SpanNode() {
	}

	int getV() {
		return v;
	}

	int getWeight() {
		return weight;
	}
}

class Minimum_spanning_tree_prims_algo {
	void primsAlgo(ArrayList<ArrayList<SpanNode>> adj, int N) {
		int key[] = new int[N];
		int parent[] = new int[N];
		boolean mstSet[] = new boolean[N];
		for (int i = 0; i < N; i++) {
			key[i] = 100000000;
			mstSet[i] = false;
		}

		key[0] = 0;
		parent[0] = -1;

		for (int i = 0; i < N - 1; i++) {
			int mini = 100000000, u = 0;
			for (int v = 0; v < N; v++) {
				if (mstSet[v] == false && key[v] < mini) {
					mini = key[v];
					u = v;
				}
			}

			mstSet[u] = true;

			for (SpanNode it : adj.get(u)) {
				if (mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
					parent[it.getV()] = u;
					key[it.getV()] = it.getWeight();
				}
			}
		}

		for (int i = 1; i < N; i++) {
			System.out.println(parent[i] + " - " + i);
		}
	}

	public static void main(String args[]) {
		int n = 5;
		ArrayList<ArrayList<SpanNode>> adj = new ArrayList<ArrayList<SpanNode>>();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<SpanNode>());

		adj.get(0).add(new SpanNode(1, 2));
		adj.get(1).add(new SpanNode(0, 2));

		adj.get(1).add(new SpanNode(2, 3));
		adj.get(2).add(new SpanNode(1, 3));

		adj.get(0).add(new SpanNode(3, 6));
		adj.get(3).add(new SpanNode(0, 6));

		adj.get(1).add(new SpanNode(3, 8));
		adj.get(3).add(new SpanNode(1, 8));

		adj.get(1).add(new SpanNode(4, 5));
		adj.get(4).add(new SpanNode(1, 5));

		adj.get(2).add(new SpanNode(4, 7));
		adj.get(4).add(new SpanNode(2, 7));

		Minimum_spanning_tree_prims_algo obj = new Minimum_spanning_tree_prims_algo();
		obj.primsAlgo(adj, n);

	}
}
