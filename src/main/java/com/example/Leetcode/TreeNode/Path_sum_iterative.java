package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Path_sum_iterative {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
	    Stack <TreeNode> stack = new Stack<> ();	    
	    stack.push(root) ;	    
	    while (!stack.isEmpty() && root != null){
	    	TreeNode cur = stack.pop() ;	
	    	if (cur.left == null && cur.right == null){	    		
	    		if (cur.val == sum ) return true ;
	    	}
	    	if (cur.right != null) {
	    		cur.right.val = cur.val + cur.right.val ;
	    		stack.push(cur.right) ;
	    	}
	    	if (cur.left != null) {
	    		cur.left.val = cur.val + cur.left.val;
	    		stack.push(cur.left);
	    	}
	    }	    
	    return false ;
	 }
	
	
	
	 public static void main(String args[]) {

			Path_sum_iterative tree = new Path_sum_iterative();

			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(2);
			tree.root.left.left = new TreeNode(3);
			tree.root.left.right = new TreeNode(3);
			tree.root.left.left.left = new TreeNode(4);
			tree.root.left.left.right = new TreeNode(5);
			
			boolean res=hasPathSum(tree.root,11);
			
			System.out.println(res);

		}
}
