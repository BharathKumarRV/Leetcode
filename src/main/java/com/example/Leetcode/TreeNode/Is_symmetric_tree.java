package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Is_symmetric_tree.TreeNode;

public class Is_symmetric_tree {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isSymmetricHelp(root.left, root.right);
	}

	private static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		return (left.val == right.val) && isSymmetricHelp(left.left, right.right)
				&& isSymmetricHelp(left.right, right.left);
	}

	public static void main(String args[]) {

		Is_symmetric_tree tree = new Is_symmetric_tree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(2);
		tree.root.left.left=new TreeNode(3);
		tree.root.left.right=new TreeNode(4);
		tree.root.right.left=new TreeNode(4);
		tree.root.right.right=new TreeNode(3);

		boolean res = isSymmetric(tree.root);

		System.out.println(res);
	}
}
