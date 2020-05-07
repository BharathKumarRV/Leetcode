package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Binary_tree_maximum_sum_path.TreeNode;

public class Binary_tree_maximum_sum_path {


	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	private static int maxValue;
	
	 public static int maxPathSum(TreeNode root) {
	        maxValue = Integer.MIN_VALUE;
	        maxPathDown(root);
	        return maxValue;
	    }
	    
	    private static int maxPathDown(TreeNode node) {
	        if (node == null) return 0;
	        int left = Math.max(0, maxPathDown(node.left));
	        int right = Math.max(0, maxPathDown(node.right));
	        maxValue = Math.max(maxValue, left + right + node.val);
	        return Math.max(left, right) + node.val;
	    }
	
	 public static void main(String args[]) {

			Binary_tree_maximum_sum_path tree = new Binary_tree_maximum_sum_path();

			tree.root = new TreeNode(-10);
			tree.root.left = new TreeNode(9);
			tree.root.right = new TreeNode(20);
			tree.root.right.left = new TreeNode(15);
			tree.root.right.right = new TreeNode(7);
			
			
			int res=maxPathSum(tree.root);
			
			System.out.println(res);

		}
}
