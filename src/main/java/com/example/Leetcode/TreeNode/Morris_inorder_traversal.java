package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

import com.example.Leetcode.TreeNode.Inorder_traversal.TreeNode;

public class Morris_inorder_traversal {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();

		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				inorder.add(cur.val);
				cur = cur.right;
			} else {
				TreeNode prev = cur.left;
				while (prev.right != null && prev.right != cur) {
					prev = prev.right;
				}

				if (prev.right == null) {
					prev.right = cur;
					cur = cur.left;
				} else {
					prev.right = null;
					inorder.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return inorder;
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Morris_inorder_traversal tree = new Morris_inorder_traversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> res = inorderTraversal(tree.root);
		System.out.println(res);
	}
}
