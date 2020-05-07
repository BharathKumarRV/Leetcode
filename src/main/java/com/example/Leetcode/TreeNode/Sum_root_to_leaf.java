package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Balanced_binary_tree.TreeNode;

public class Sum_root_to_leaf {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	static int total;

	public static int sumNumbers(TreeNode root) {
		total = 0;
		helper(root, 0);
		return total;
	}

	public static void helper(TreeNode root, int sum) {
		if (root == null)
			return;

		sum = sum * 10 + root.val;

		if (root.left == null && root.right == null) {
			total += sum;
			return;
		}

		helper(root.left, sum);
		helper(root.right, sum);
	}

	public static void main(String args[]) {

		Sum_root_to_leaf tree = new Sum_root_to_leaf();

		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(0);
		tree.root.left.left = new TreeNode(5);
		tree.root.left.right = new TreeNode(1);

		int res = sumNumbers(tree.root);

		System.out.println(res);

	}
}
