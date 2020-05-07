package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Flatten_Binary_tree_Linkedlist_2.TreeNode;

public class Flatten_Binary_tree_Linkedlist_iterative {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	public static void flatten(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left != null) {
				TreeNode last = cur.left;
				while (last.right != null)
					last = last.right;
				last.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
	}

	public static void main(String args[]) {

		Flatten_Binary_tree_Linkedlist_iterative tree = new Flatten_Binary_tree_Linkedlist_iterative();

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(5);
		tree.root.right.right = new TreeNode(6);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(4);

		flatten(tree.root);

		System.out.println(tree.root);

	}
}
