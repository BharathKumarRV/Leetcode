package com.example.Leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Binary_tree_preorder_traversal {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		if(root==null) return result;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return result;
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Binary_tree_preorder_traversal tree = new Binary_tree_preorder_traversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> res = preorderTraversal(tree.root);
		System.out.println(res);
	}
}
