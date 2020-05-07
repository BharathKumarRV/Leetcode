package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Binary_tree_construct_postorder_inorder_iterative {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
	    if (inorder.length == 0 || postorder.length == 0) return null;
	    int ip = inorder.length - 1;
	    int pp = postorder.length - 1;
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode prev = null;
	    TreeNode root = new TreeNode(postorder[pp]);
	    stack.push(root);
	    pp--;
	    
	    while (pp >= 0) {
	        while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
	            prev = stack.pop();
	            ip--;
	        }
	        TreeNode newNode = new TreeNode(postorder[pp]);
	        if (prev != null) {
	            prev.left = newNode;
	        } else if (!stack.isEmpty()) {
	            TreeNode currTop = stack.peek();
	            currTop.right = newNode;
	        }
	        stack.push(newNode);
	        prev = null;
	        pp--;
	    }
	    
	    return root;
	}
	
	 public static void main(String args[]) {

			Binary_tree_construct_postorder_inorder_iterative tree = new Binary_tree_construct_postorder_inorder_iterative();
			
			int []postorder = {9,15,7,20,3};
		    int []inorder = {9,3,15,20,7};

		    tree.root = buildTree(inorder,postorder);
         System.out.println(tree.root);
		}
}
