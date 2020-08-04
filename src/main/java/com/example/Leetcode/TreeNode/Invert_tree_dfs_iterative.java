package com.example.Leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Invert_tree_dfs_iterative {

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

		final Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			final TreeNode node = stack.pop();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		return root;
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Invert_tree_dfs_iterative tree1 = new Invert_tree_dfs_iterative();
		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(2);
		tree1.root.left.left = new TreeNode(4);
		tree1.root.left.right = new TreeNode(5);
		tree1.root.right = new TreeNode(3);
		tree1.root.right.left = new TreeNode(6);
		tree1.root.right.right = new TreeNode(7);

		tree1.root = invertTree(tree1.root);

	}
}
