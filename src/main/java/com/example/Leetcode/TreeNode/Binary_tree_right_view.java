package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_tree_right_view {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	public static List<Integer> rightSideView(TreeNode root) {
		if (root == null)
			return new ArrayList();
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);
		List<Integer> res = new ArrayList();

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				TreeNode cur = queue.poll();
				if (size == 0)
					res.add(cur.val);
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)  // Interchange these for left side view
					queue.offer(cur.right);		
			}
		}

		return res;
	}

	public static void main(String args[]) {
		Binary_tree_right_view tree = new Binary_tree_right_view();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> res = rightSideView(tree.root);
		System.out.println(res);
	}
}
