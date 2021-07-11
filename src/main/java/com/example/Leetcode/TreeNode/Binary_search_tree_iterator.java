package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_search_tree_iterator {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	TreeNode root;
	List<Integer> list = new ArrayList();
	int index = 0;

	public Binary_search_tree_iterator() {

	}

	public Binary_search_tree_iterator(TreeNode root) {
		inorder(root);

	}

	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return index < list.size();
	}

	/** @return the next smallest number */
	public int next() {
		return list.get(index++);
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Binary_search_tree_iterator tree = new Binary_search_tree_iterator();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		Binary_search_tree_iterator tree1 = new Binary_search_tree_iterator(tree.root);
		int res = tree1.next();
		System.out.println(res);
		int res1 = tree1.next();
		System.out.println(res1);
		int res2 = tree1.next();
		System.out.println(res2);
		boolean res3 = tree1.hasNext();
		System.out.println(res3);
		int res4 = tree1.next();
		System.out.println(res4);
		int res5 = tree1.next();
		System.out.println(res5);
		boolean res6 = tree1.hasNext();
		System.out.println(res6);

	}
}
