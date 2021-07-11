package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_search_tree_2 {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<TreeNode> generateTrees(int n) {

		return genTrees(1, n);
	}

	public static List<TreeNode> genTrees(int start, int end) {

		List<TreeNode> list = new ArrayList<TreeNode>();

		if (start > end) {
			list.add(null);
			return list;
		}

		// Not needed
		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}

		List<TreeNode> left, right;
		for (int i = start; i <= end; i++) {

			left = genTrees(start, i - 1);
			right = genTrees(i + 1, end);

			for (TreeNode lnode : left) {
				for (TreeNode rnode : right) {
					TreeNode root = new TreeNode(i);
					root.left = lnode;
					root.right = rnode;
					list.add(root);
				}
			}

		}

		return list;
	}

	static void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val);
			if (root.left != null) {
				preorder(root.left);
			} else if (root.left == null && root.right != null) {
				System.out.print(root.left);
			}
			if (root.right != null) {
				preorder(root.right);
			} else if (root.left != null && root.right == null) {
				System.out.print(root.right);
			}
		}
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */

		/*
		 * Unique_Binary_search_tree_2 tree = new Unique_Binary_search_tree_2();
		 * tree.root = new TreeNode(1); tree.root.left = new TreeNode(2);
		 * tree.root.right = new TreeNode(3); tree.root.left.left = new TreeNode(4);
		 * tree.root.left.right = new TreeNode(5);
		 */

		List<TreeNode> res = generateTrees(3);
		for (int i = 0; i < res.size(); i++) {
			preorder(res.get(i));
			System.out.println();
		}
	}
}
