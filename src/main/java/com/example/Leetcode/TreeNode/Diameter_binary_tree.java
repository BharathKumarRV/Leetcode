package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Sum_root_to_leaf.TreeNode;

public class Diameter_binary_tree {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	static int res = Integer.MIN_VALUE;

	public static void main(String args[]) {

		Diameter_binary_tree tree = new Diameter_binary_tree();

		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(0);
		tree.root.left.left = new TreeNode(5);
		tree.root.left.right = new TreeNode(1);

		diameter_tree(tree.root);

		System.out.println(res-1); //gives numbeer of edges

	}

	public static int diameter_tree(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = diameter_tree(root.left);
		int right = diameter_tree(root.right);

		int temp = 1 + Math.max(left, right);

		int ans = Math.max(temp, 1 + left + right);
		res = Math.max(ans, res);
		return temp;
	}
}
