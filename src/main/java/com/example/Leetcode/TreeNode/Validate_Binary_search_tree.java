package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Validate_Binary_search_tree {
	
	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isValidBST(TreeNode root) {
		   if (root == null) return true;
		   Stack<TreeNode> stack = new Stack<>();
		   TreeNode pre = null;
		   while (root != null || !stack.isEmpty()) {
		      while (root != null) {
		         stack.push(root);
		         root = root.left;
		      }
		      root = stack.pop();
		      if(pre != null && root.val <= pre.val) return false;
		      pre = root;
		      root = root.right;
		   }
		   return true;
		}
	
	public static void main(String args[]) {
		
		Validate_Binary_search_tree tree = new Validate_Binary_search_tree();
		tree.root = new TreeNode(2);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(3);
		//tree.root.left.left = new TreeNode(4);
		//tree.root.left.right = new TreeNode(5);
        boolean res=isValidBST(tree.root);
        System.out.println(res);
	}
}
