package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Kth_smallest_BST {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static int number = 0;
	private static int count = 0;
	private static List<Integer> arr=new ArrayList<>();

	public static int kthSmallest(TreeNode root, int k) {
		count = k;
		helper(root);
		return arr.get(k-1);
	}

	public static void helper(TreeNode n) {
		if (n.left != null)
			helper(n.left); //left traversal
		/*
		 * count--; //processing root if (count == 0) { number = n.val; return; }
		 */
		arr.add(n.val);
		
		if (n.right != null)
			helper(n.right); //right traversal
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		
		//For kth largest find N and get (N-k)th node.
		Kth_smallest_BST tree = new Kth_smallest_BST();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(4);
		tree.root.left.right = new TreeNode(2);
		//tree.root.left.left = new TreeNode(2);
		//tree.root.left.right = new TreeNode(4);
		//tree.root.left.left.left = new TreeNode(1);
		int res = kthSmallest(tree.root, 2);
		System.out.println(res);
	}
}
