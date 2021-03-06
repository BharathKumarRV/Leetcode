package com.example.Leetcode.gragh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.example.Leetcode.gragh.Clone_graph.Node;

public class Clone_graph_dfs {

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
	 private static HashMap<Integer, Node> map = new HashMap<>();
	 
	 public static Node cloneGraph(Node node) {
		 return clone(node);
	    }
	 
	 private static Node clone(Node node) {
	        if (node == null) return null;
	        
	        if (map.containsKey(node.val)) {
	            return map.get(node.val);
	        }
	        Node clone = new Node(node.val);
	        map.put(clone.val, clone);
	        for (Node neighbor : node.neighbors) {
	            clone.neighbors.add(clone(neighbor));
	        }
	        return clone;
	    }
	
	
	
	public static void main(String args[]) {
		Clone_graph_dfs cg=new Clone_graph_dfs();
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
