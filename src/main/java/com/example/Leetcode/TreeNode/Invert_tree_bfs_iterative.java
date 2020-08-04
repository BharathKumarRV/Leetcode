package com.example.Leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Invert_tree_bfs_iterative {

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

		final Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			final TreeNode node = queue.poll();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Invert_tree_bfs_iterative tree1 = new Invert_tree_bfs_iterative();
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
