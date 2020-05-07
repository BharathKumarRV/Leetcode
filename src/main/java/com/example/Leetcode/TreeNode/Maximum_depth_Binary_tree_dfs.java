package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Maximum_depth_Binary_tree_dfs {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static int maxDepth(TreeNode root) {
	    if(root == null) {
	        return 0;
	    }
	    
	    Stack<TreeNode> stack = new Stack<>();
	    Stack<Integer> value = new Stack<>();
	    stack.push(root);
	    value.push(1);
	    int max = 1;
	    while(!stack.isEmpty()) {
	        TreeNode node = stack.pop();
	        int temp = value.pop();
	        max = Math.min(temp, max);
	        if(node.left != null) {
	            stack.push(node.left);
	            value.push(temp+1);
	        }
	        if(node.right != null) {
	            stack.push(node.right);
	            value.push(temp+1);
	        }
	    }
	    return max;
	}
	
	 public static void main(String args[]) {

			Maximum_depth_Binary_tree_dfs tree = new Maximum_depth_Binary_tree_dfs();
			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(3);
			tree.root.right.left = new TreeNode(6);
			tree.root.right.right = new TreeNode(7);

			int res = maxDepth(tree.root);

			System.out.println(res);
		}
}
