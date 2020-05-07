package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Minimum_depth_binary_tree_dfs.TreeNode;

public class Minimum_depth_binary_tree_dfs {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static int minDepth(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }

	    int left = minDepth(root.left);
	    int right = minDepth(root.right);
	    if (left == 0 || right == 0) {
	        return Math.max(left, right) + 1;
	    }
	    else {
	        return Math.min(left, right) + 1;
	    }
	}


	
	
	 public static void main(String args[]) {

			Minimum_depth_binary_tree_dfs tree = new Minimum_depth_binary_tree_dfs();

			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(2);
			tree.root.left.left = new TreeNode(3);
			tree.root.left.right = new TreeNode(3);
			tree.root.left.left.left = new TreeNode(4);
			tree.root.left.left.right = new TreeNode(4);
			
			int res=minDepth(tree.root);
			
			System.out.println(res);

		}
}
