package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Is_same_tree.TreeNode;

public class Invert_tree {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		final TreeNode left = root.left, right = root.right;
		root.left = invertTree(right);
		root.right = invertTree(left);
		return root;
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Invert_tree tree1 = new Invert_tree();
		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(2);
		tree1.root.right = new TreeNode(3);

		tree1.root = invertTree(tree1.root);

	}
}
