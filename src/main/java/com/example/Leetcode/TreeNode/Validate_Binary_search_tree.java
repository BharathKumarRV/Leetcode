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
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && root.val <= pre.val)
				return false;
			pre = root;
			root = root.right;
		}
		return true;
	}

	static TreeNode prev;

	public static boolean isValidBST_recursive(TreeNode root) {
		if (root == null)
			return true;

		if (!isValidBST_recursive(root.left))
			return false;

		if (prev != null && root.val <= prev.val)
			return false;

		prev = root;

		if (!isValidBST_recursive(root.right))
			return false;

		return true;

	}
	
	private static boolean checkBST(TreeNode node, long min, long max) {
        if(node == null) return true; 
        if(node.val <= min || node.val >= max) return false; 
        
        if(checkBST(node.left, min, node.val) && checkBST(node.right, node.val, max)) {
            return true; 
        }
        return false; 
    }
    public static boolean isValidBST2(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE); 
    }

	public static void main(String args[]) {

		Validate_Binary_search_tree tree = new Validate_Binary_search_tree();
		tree.root = new TreeNode(2);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(3);
		// tree.root.left.left = new TreeNode(4);
		// tree.root.left.right = new TreeNode(5);
		//boolean res = isValidBST(tree.root);
		boolean res = isValidBST2(tree.root);
		System.out.println(res);
	}
}
