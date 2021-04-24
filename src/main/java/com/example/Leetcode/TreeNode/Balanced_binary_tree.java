package com.example.Leetcode.TreeNode;

public class Balanced_binary_tree {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static int depth (TreeNode root) {
	        if (root == null) return 0;
	        return Math.max(depth(root.left), depth (root.right)) + 1;
	    }

	   public static boolean isBalanced (TreeNode root) {
	        if (root == null) return true;
	        
	        int left=depth(root.left);
	        int right=depth(root.right);
	        
	        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	    }
	
	
	 public static void main(String args[]) {

			Balanced_binary_tree tree = new Balanced_binary_tree();

			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(3);
			tree.root.right.left = new TreeNode(6);
			tree.root.right.right = new TreeNode(7);
			
			boolean res=isBalanced(tree.root);
			
			System.out.println(res);

		}
}
