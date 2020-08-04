package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Validate_Binary_search_tree.TreeNode;

public class Lowest_common_ancestor_BST {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}

	/*
	 * public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
	 * TreeNode q) { while (true) { if (root.val > p.val && root.val > q.val) root =
	 * root.left; else if (root.val < p.val && root.val < q.val) root = root.right;
	 * else return root; } }
	 */

	public static void main(String args[]) {

		Lowest_common_ancestor_BST tree = new Lowest_common_ancestor_BST();
		tree.root = new TreeNode(6);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(8);
		tree.root.right.left = new TreeNode(7);
		tree.root.right.right = new TreeNode(9);
		// tree.root.left.left = new TreeNode(4);
		// tree.root.left.right = new TreeNode(5);
		TreeNode res = lowestCommonAncestor(tree.root, tree.root.right.left, tree.root.right.right);
		System.out.println(res);
	}

}
