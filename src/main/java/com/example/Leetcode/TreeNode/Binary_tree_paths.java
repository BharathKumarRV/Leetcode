package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Binary_tree_paths {

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
		List<String> answer = new ArrayList<String>();
		if (root != null)
			searchBT(root, "", answer);
		return answer;
	}

	private static void searchBT(TreeNode root, String path, List<String> answer) {
		if (root.left == null && root.right == null)
			answer.add(path + root.val);
		if (root.left != null)
			searchBT(root.left, path + root.val + "->", answer);
		if (root.right != null)
			searchBT(root.right, path + root.val + "->", answer);
	}

	public static void main(String args[]) {

		Binary_tree_paths tree = new Binary_tree_paths();

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);

		List<String> res = binaryTreePaths(tree.root);

		System.out.println(res);

	}
}
