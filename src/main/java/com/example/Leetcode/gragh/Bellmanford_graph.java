package com.example.Leetcode.gragh;

import java.util.ArrayList;

class BellmanNode {
	private int u;
	private int v;
	private int weight;

	BellmanNode(int _u, int _v, int _w) {
		u = _u;
		v = _v;
		weight = _w;
	}

	BellmanNode() {
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

class Bellmanford_graph {
	void bellmanFord(ArrayList<BellmanNode> edges, int N, int src) {
		int dist[] = new int[N];
		for (int i = 0; i < N; i++)
			dist[i] = 10000000;

		dist[src] = 0;

		for (int i = 1; i <= N - 1; i++) {
			for (BellmanNode node : edges) {
				if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
					dist[node.getV()] = dist[node.getU()] + node.getWeight();
				}
			}
		}

		int fl = 0;
		for (BellmanNode node : edges) {
			if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
				fl = 1;
				System.out.println("Negative Cycle");
				break;
			}
		}

		if (fl == 0) {
			for (int i = 0; i < N; i++) {
				System.out.println(i + " " + dist[i]);
			}
		}
	}

	public static void main(String args[]) {
		int n = 6;
		ArrayList<BellmanNode> adj = new ArrayList<BellmanNode>();

		adj.add(new BellmanNode(3, 2, 6));
		adj.add(new BellmanNode(5, 3, 1));
		adj.add(new BellmanNode(0, 1, 5));
		adj.add(new BellmanNode(1, 5, -3));
		adj.add(new BellmanNode(1, 2, -2));
		adj.add(new BellmanNode(3, 4, -2));
		adj.add(new BellmanNode(2, 4, 3));

		Bellmanford_graph obj = new Bellmanford_graph();
		obj.bellmanFord(adj, n, 0);

	}
}