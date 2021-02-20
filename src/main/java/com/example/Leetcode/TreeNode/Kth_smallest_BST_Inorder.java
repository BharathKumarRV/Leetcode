package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Kth_smallest_BST_Inorder {

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
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0)
				break;
			root = root.right;
		}
		return root.val;
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Kth_smallest_BST_Inorder tree = new Kth_smallest_BST_Inorder();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(4);
		tree.root.left.right = new TreeNode(2);
		// tree.root.left.left = new TreeNode(2);
		// tree.root.left.right = new TreeNode(4);
		// tree.root.left.left.left = new TreeNode(1);
		int res = kthSmallest(tree.root, 3);
		System.out.println(res);
	}

}
