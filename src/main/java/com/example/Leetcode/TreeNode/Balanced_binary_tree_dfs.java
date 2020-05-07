package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Balanced_binary_tree.TreeNode;

public class Balanced_binary_tree_dfs {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static int dfsHeight (TreeNode root) {
		        if (root == null) return 0;
		        
		        int leftHeight = dfsHeight (root.left);
		        if (leftHeight == -1) return -1;
		        int rightHeight = dfsHeight (root.right);
		        if (rightHeight == -1) return -1;
		        
		        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
		        return Math.max(leftHeight, rightHeight) + 1;
		    }
	
		   public static boolean isBalanced(TreeNode root) {
		        return dfsHeight (root) != -1;
		    }
	
	 public static void main(String args[]) {

			Balanced_binary_tree_dfs tree = new Balanced_binary_tree_dfs();

			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(2);
			tree.root.left.left = new TreeNode(3);
			tree.root.left.right = new TreeNode(3);
			tree.root.left.left.left = new TreeNode(4);
			tree.root.left.left.right = new TreeNode(4);
			
			boolean res=isBalanced(tree.root);
			
			System.out.println(res);

		}
}
