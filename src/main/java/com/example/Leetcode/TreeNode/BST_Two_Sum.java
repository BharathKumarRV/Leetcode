package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class BST_Two_Sum {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static class BSTIterator {
		private Stack<TreeNode> stack = new Stack<TreeNode>();
		boolean reverse = true;

		public BSTIterator(TreeNode root, boolean isReverse) {
			reverse = isReverse;
			pushAll(root);
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode tmpNode = stack.pop();
			if (reverse == false)
				pushAll(tmpNode.right);
			else
				pushAll(tmpNode.left);
			return tmpNode.val;
		}

		private void pushAll(TreeNode node) {
			while (node != null) {
				stack.push(node);
				if (reverse == true) {
					node = node.right;
				} else {
					node = node.left;
				}
			}
		}
	}

	public static boolean findTarget(TreeNode root, int k) {
		if (root == null)
			return false;
		BSTIterator l = new BSTIterator(root, false);
		BSTIterator r = new BSTIterator(root, true);

		int i = l.next();
		int j = r.next();
		while (i < j) {
			if (i + j == k)
				return true;
			else if (i + j < k)
				i = l.next();
			else
				j = r.next();
		}
		return false;
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */

		// For kth largest find N and get (N-k)th node.
		BST_Two_Sum tree = new BST_Two_Sum();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(4);
		tree.root.left.right = new TreeNode(2);
		// tree.root.left.left = new TreeNode(2);
		// tree.root.left.right = new TreeNode(4);
		// tree.root.left.left.left = new TreeNode(1);
		boolean res = findTarget(tree.root, 1);
		System.out.println(res);
	}

}
