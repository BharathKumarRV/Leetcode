package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Is_same_tree.TreeNode;

public class Is_same_tree {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		if (p == null && q != null || p != null && q == null)
			return false;
		if (p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Is_same_tree tree1 = new Is_same_tree();
		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(2);
		tree1.root.right = new TreeNode(3);

		Is_same_tree tree2 = new Is_same_tree();
		tree2.root = new TreeNode(1);
		tree2.root.left = new TreeNode(2);
		tree2.root.right = new TreeNode(3);

		boolean res = isSameTree(tree1.root, tree2.root);

		System.out.println(res);
	}
}
