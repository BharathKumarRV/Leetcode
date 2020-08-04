package com.example.Leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Lowest_common_ancestor_BT_recursive {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	/*
	 * To find the lowest common ancestor, we need to find where is p and q and a
	 * way to track their ancestors. A parent pointer for each node found is good
	 * for the job. After we found both p and q, we create a set of p's ancestors.
	 * Then we travel through q's ancestors, the first one appears in p's is our
	 * answer.
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    Map<TreeNode, TreeNode> parent = new HashMap<>();
	    Queue<TreeNode> queue = new LinkedList<>();
	    parent.put(root, null);
	    queue.add(root);
	    while (!parent.containsKey(p) || !parent.containsKey(q)) {
	        TreeNode node = queue.poll();
	        if (node != null) {
	            parent.put(node.left, node);
	            parent.put(node.right, node);
	            queue.add(node.left);
	            queue.add(node.right);
	        }
	    }
	    Set<TreeNode> set = new HashSet<>();
	    while (p != null) {
	        set.add(p);
	        p = parent.get(p);
	    }
	    while (!set.contains(q)) {
	        q = parent.get(q);
	    }
	    return q;
	}
	
	
	
	public static void main(String args[]) {

		Lowest_common_ancestor_BT_recursive tree = new Lowest_common_ancestor_BT_recursive();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(5);
		tree.root.left.left = new TreeNode(6);
		tree.root.left.right = new TreeNode(2);
		tree.root.left.right.left = new TreeNode(7);
		tree.root.left.right.right = new TreeNode(4);
		tree.root.right = new TreeNode(1);
		tree.root.right.left = new TreeNode(0);
		tree.root.right.right = new TreeNode(8);
		TreeNode res = lowestCommonAncestor(tree.root, tree.root.left.right.left, tree.root.left.right.right);
		System.out.println(res);
	}
}
