package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Is_symmetric_tree_stack {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
	    Stack<TreeNode> stack = new Stack<>();
	    stack.push(root.left);
	    stack.push(root.right);
	    while (!stack.empty()) {
	        TreeNode n1 = stack.pop(), n2 = stack.pop();
	        if (n1 == null && n2 == null) continue;
	        if (n1 == null || n2 == null || n1.val != n2.val) return false;
	        stack.push(n1.left);
	        stack.push(n2.right);
	        stack.push(n1.right);
	        stack.push(n2.left);
	    }
	    return true;
	}

	public static void main(String args[]) {

		Is_symmetric_tree_stack tree = new Is_symmetric_tree_stack();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(2);
		tree.root.left.left=new TreeNode(3);
		tree.root.left.right=new TreeNode(4);
		tree.root.right.left=new TreeNode(4);
		tree.root.right.right=new TreeNode(3);

		boolean res = isSymmetric(tree.root);

		System.out.println(res);
	}
}
