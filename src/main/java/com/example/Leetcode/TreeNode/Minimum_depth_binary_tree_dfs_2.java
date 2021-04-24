package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Balanced_binary_tree.TreeNode;

public class Minimum_depth_binary_tree_dfs_2 {
	
	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	 public static void main(String args[]) {

		 Minimum_depth_binary_tree_dfs_2 tree = new Minimum_depth_binary_tree_dfs_2();

			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			//tree.root.right = new TreeNode(2);
			//tree.root.left.left = new TreeNode(3);
			//tree.root.left.right = new TreeNode(3);
			//tree.root.left.left.left = new TreeNode(4);
			//tree.root.left.left.right = new TreeNode(4);
			
			int res=getMinDepth(tree.root);
			
			System.out.println(res);

		}
	

	private static int getMinDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		int leftDepth = root.left != null ? getMinDepth(root.left) : Integer.MAX_VALUE;
		int rightDepth = root.right != null ? getMinDepth(root.right) : Integer.MAX_VALUE;

		return 1 + Math.min(leftDepth, rightDepth);
	}
}
