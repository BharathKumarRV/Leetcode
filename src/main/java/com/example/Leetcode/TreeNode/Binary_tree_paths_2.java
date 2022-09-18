package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

import com.example.Leetcode.TreeNode.Binary_tree_paths.TreeNode;

public class Binary_tree_paths_2 {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		helper(res, root, sb);
		return res;
	}

	private static void helper(List<String> res, TreeNode root, StringBuilder sb) {

		if (root == null) {
			return;
		}

		int len = sb.length();
		sb.append(root.val);
		if (root.left == null && root.right == null) {
			res.add(sb.toString());
		} else {
			sb.append("->");
			helper(res, root.left, sb);
			helper(res, root.right, sb);
		}
		sb.setLength(len);
	}

	private static void helper_2(List<String> res, TreeNode root, StringBuilder sb) {
		sb.append(root.val);
		if (root.left == null && root.right == null) {
			res.add(sb.toString());
			return;
		}

		int len = sb.length();

		if (root.left != null) {
			sb.append("->");
			helper_2(res, root.left, sb);
			sb.setLength(len);
		}
		if (root.right != null) {
			sb.append("->");
			helper_2(res, root.right, sb);
			sb.setLength(len);
		}
		sb.setLength(len);
	}

	public static void main(String args[]) {

		Binary_tree_paths_2 tree = new Binary_tree_paths_2();

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);

		List<String> res = binaryTreePaths(tree.root);

		System.out.println(res);

	}
}
