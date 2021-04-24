package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Minimum_depth_binary_tree_bfs.TreeNode;

public class Path_sum {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public static void main(String args[]) {

		Path_sum tree = new Path_sum();

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(2);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(3);
		tree.root.left.left.left = new TreeNode(4);
		tree.root.left.left.right = new TreeNode(5);

		boolean res = hasPathSum(tree.root, 11);

		System.out.println(res);

	}
}
