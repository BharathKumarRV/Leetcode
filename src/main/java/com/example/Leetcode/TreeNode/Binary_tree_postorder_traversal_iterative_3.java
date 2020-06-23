package com.example.Leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Binary_tree_postorder_traversal_iterative_3 {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				results.add(root.val);
				root = root.right;
			} else {
				root = stack.pop().left;
			}
		}
		Collections.reverse(results);
		return results;
	}
	
	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 * pre-order traversal is root-left-right, 
		 * and post order is left-right-root. 
		 * modify the code for pre-order to make it root-right-left, 
		 * and then reverse the output so that we can get left-right-root .
		 */
		Binary_tree_postorder_traversal_iterative_3 tree = new Binary_tree_postorder_traversal_iterative_3();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> res=postorderTraversal(tree.root);
		System.out.println(res);
	}
	
	
}
