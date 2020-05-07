package com.example.Leetcode.gragh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Clone_graph {

	Node node;
	
	static class Node {
	    public int val;
	    public List<Node> neighbors;
	    
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	 public static Node cloneGraph(Node node) {
	        if (node == null) return null;
	        
	        Map<Integer, Node> map = new HashMap(); // origin node : copied node
	        Node myNode = new Node(node.val); // copy
	        
	        map.put(node.val, myNode);
	        
	        Queue<Node> q = new ArrayDeque(); // origin nodes
	        q.add(node);
	        
	        // bfs traverse graph
	        while (!q.isEmpty()) {
	            Node cur = q.poll();
	            // all neighbors of current origin node
	            for (Node neighbor : cur.neighbors) {
	                // if the origin node is not visited
	                if (!map.containsKey(neighbor.val)) {
	                    map.put(neighbor.val, new Node(neighbor.val));
	                    // to avoid loop, we just add the unvisited node to queue
	                    q.offer(neighbor);
	                }
	                // add neighbors to the copied node
	                // copied node: map.get(cur) -> copied node of cur
	                // neighbors: map.get(neighbor) -> copied node of neighbor
	                map.get(cur.val).neighbors.add(map.get(neighbor.val));
	            }
	        }
	        return myNode;
	    }
	
	
	
	public static void main(String args[]) {
		Clone_graph cg=new Clone_graph();
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		List<Node> neighbors1=new ArrayList<>();
		neighbors1.add(node2);
		neighbors1.add(node4);
		node1.neighbors=neighbors1;
		List<Node> neighbors2=new ArrayList<>();
		neighbors2.add(node1);
		neighbors2.add(node3);
		node2.neighbors=neighbors2;
		List<Node> neighbors3=new ArrayList<>();
		neighbors3.add(node2);
		neighbors3.add(node4);
		node3.neighbors=neighbors3;
		List<Node> neighbors4=new ArrayList<>();
		neighbors4.add(node1);
		neighbors4.add(node3);
		node4.neighbors=neighbors4;
		
		Node res=cloneGraph(node1);
		System.out.println(res);
		
	}
}
