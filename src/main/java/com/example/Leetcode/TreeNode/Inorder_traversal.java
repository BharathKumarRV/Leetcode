package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Inorder_traversal {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	//Time complexity
	//https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/31213/Iterative-solution-in-Java-simple-and-readable/119490

	public static void inorder(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode curr = root;

		// traverse the tree
		while (curr != null || s.size() > 0) {

			/*
			 * Reach the left most TreeNode of the curr TreeNode
			 */
			while (curr != null) {
				/*
				 * place pointer to a tree node on the stack before traversing the node's left
				 * subtree
				 */
				s.push(curr);
				curr = curr.left;
			}

			/* Current must be NULL at this point */
			curr = s.pop();

			System.out.print(curr.val + " ");

			/*
			 * we have visited the node and its left subtree. Now, it's right subtree's turn
			 */
			curr = curr.right;
		}
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Inorder_traversal tree = new Inorder_traversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		inorder(tree.root);
	}
}
