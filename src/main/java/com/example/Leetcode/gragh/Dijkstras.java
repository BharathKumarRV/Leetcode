package com.example.Leetcode.gragh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class GraphNode implements Comparator<GraphNode> {
	private int v;
	private int weight;

	GraphNode(int _v, int _w) {
		v = _v;
		weight = _w;
	}

	GraphNode() {
	}

	int getV() {
		return v;
	}

	int getWeight() {
		return weight;
	}

	@Override
	public int compare(GraphNode node1, GraphNode node2) {
		if (node1.weight < node2.weight)
			return -1;
		if (node1.weight > node2.weight)
			return 1;
		return 0;
	}
}

class Main {
	void shortestPath(int s, ArrayList<ArrayList<GraphNode>> adj, int N) {
		int dist[] = new int[N];

		for (int i = 0; i < N; i++)
			dist[i] = 100000000;
		dist[s] = 0;

		PriorityQueue<GraphNode> pq = new PriorityQueue<GraphNode>(N, new GraphNode());
		pq.add(new GraphNode(s, 0));

		while (pq.size() > 0) {
			GraphNode node = pq.poll();

			for (GraphNode it : adj.get(node.getV())) {
				if (dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
					dist[it.getV()] = dist[node.getV()] + it.getWeight();
					pq.add(new GraphNode(it.getV(), dist[it.getV()]));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(dist[i] + " ");
		}
	}

	public static void main(String args[]) {
		int n = 5;
		ArrayList<ArrayList<GraphNode>> adj = new ArrayList<ArrayList<GraphNode>>();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<GraphNode>());

		adj.get(0).add(new GraphNode(1, 2));
		adj.get(1).add(new GraphNode(0, 2));

		adj.get(1).add(new GraphNode(2, 4));
		adj.get(2).add(new GraphNode(1, 4));

		adj.get(0).add(new GraphNode(3, 1));
		adj.get(3).add(new GraphNode(0, 1));

		adj.get(3).add(new GraphNode(2, 3));
		adj.get(2).add(new GraphNode(3, 3));

		adj.get(1).add(new GraphNode(4, 5));
		adj.get(4).add(new GraphNode(1, 5));

		adj.get(2).add(new GraphNode(4, 1));
		adj.get(4).add(new GraphNode(2, 1));

		Main obj = new Main();
		obj.shortestPath(0, adj, n);

	}
}