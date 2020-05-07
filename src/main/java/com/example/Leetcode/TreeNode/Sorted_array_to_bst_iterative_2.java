package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Sorted_array_to_bst_iterative_2 {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	private static class Node {
		TreeNode node;
		int left, right;

		public Node(TreeNode node, int left, int right) {
			this.node = node;
			this.left = left;
			this.right = right;
		}
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		TreeNode root = new TreeNode(0);
		Stack<Node> stack = new Stack<>();
		Node node = new Node(root, 0, nums.length - 1);
		stack.push(node);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			int mid = cur.left + (cur.right - cur.left) / 2;
			cur.node.val = nums[mid];
			if (cur.left < mid) {
				cur.node.left = new TreeNode(nums[cur.left+(mid-1-cur.left)/2]);
				stack.push(new Node(cur.node.left, cur.left, mid - 1));
			}
			if (cur.right > mid) {
				cur.node.right = new TreeNode(nums[mid+1+(cur.right-mid-1)/2]);
				stack.push(new Node(cur.node.right, mid + 1, cur.right));
			}
		}
		return root;
	}

	public static void main(String args[]) {

		Sorted_array_to_bst_iterative_2 tree = new Sorted_array_to_bst_iterative_2();
		int num[] = { -10, -3, 0, 5, 9 };

		tree.root = sortedArrayToBST(num);
		System.out.println(tree.root);

	}
}
