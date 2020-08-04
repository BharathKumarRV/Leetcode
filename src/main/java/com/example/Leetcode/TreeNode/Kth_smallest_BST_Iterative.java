package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Kth_smallest_BST_Iterative {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<>();

		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (k != 0) {
			TreeNode n = st.pop();
			k--;
			if (k == 0)
				return n.val;
			TreeNode right = n.right;
			while (right != null) {
				st.push(right);
				right = right.left;
			}
		}

		return -1; // never hit if k is valid
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Kth_smallest_BST_Iterative tree = new Kth_smallest_BST_Iterative();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(4);
		tree.root.left.right = new TreeNode(2);
		// tree.root.left.left = new TreeNode(2);
		// tree.root.left.right = new TreeNode(4);
		// tree.root.left.left.left = new TreeNode(1);
		int res = kthSmallest(tree.root, 1);
		System.out.println(res);
	}
}
