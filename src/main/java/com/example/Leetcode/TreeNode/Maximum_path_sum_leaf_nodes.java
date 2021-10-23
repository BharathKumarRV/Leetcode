package com.example.Leetcode.TreeNode;

public class Maximum_path_sum_leaf_nodes {

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

		Maximum_path_sum_leaf_nodes tree = new Maximum_path_sum_leaf_nodes();

		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(0);
		tree.root.left.left = new TreeNode(5);
		tree.root.left.right = new TreeNode(1);

		res = maxPathSum_rec(tree.root);

		System.out.println(res);

	}

	public static int maxPathSum_rec(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = maxPathSum_rec(root.left);
		int right = maxPathSum_rec(root.right);

		int temp = Math.max(Math.max(left, right) + root.val, root.val);
		
		if(root.left==null && root.right==null) {
			temp=Math.max(temp, root.val);
		}

		int ans = Math.max(temp, left + right + root.val);
		res = Math.max(ans, res);
		return temp;
	}
}
