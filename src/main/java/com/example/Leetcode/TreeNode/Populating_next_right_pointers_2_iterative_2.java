package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Populating_next_right_pointers_2_iterative_2while.TreeLinkNode;

public class Populating_next_right_pointers_2_iterative_2 {

	TreeLinkNode root;

	static class TreeLinkNode {
		public int val;
		public TreeLinkNode left;
		public TreeLinkNode right;
		public TreeLinkNode next;

		public TreeLinkNode() {
		}

		public TreeLinkNode(int _val) {
			val = _val;
		}

		public TreeLinkNode(int _val, TreeLinkNode _left, TreeLinkNode _right, TreeLinkNode _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

	public static TreeLinkNode connect(TreeLinkNode root) {
		helper(root);
		return root;
	}

	public static void helper(TreeLinkNode root) {
		TreeLinkNode tempChild = new TreeLinkNode(0);
		while (root != null) {
			TreeLinkNode currentChild = tempChild;
			while (root != null) {
				if (root.left != null) {
					currentChild.next = root.left;
					currentChild = currentChild.next;
				}
				if (root.right != null) {
					currentChild.next = root.right;
					currentChild = currentChild.next;
				}
				root = root.next;
			}
			root = tempChild.next;
			tempChild.next = null;
		}
	}

	public static void main(String args[]) {

		Populating_next_right_pointers_2_iterative_2 tree = new Populating_next_right_pointers_2_iterative_2();

		tree.root = new TreeLinkNode(1);
		tree.root.left = new TreeLinkNode(2);
		tree.root.right = new TreeLinkNode(3);
		tree.root.left.left = new TreeLinkNode(4);
		tree.root.left.right = new TreeLinkNode(5);
		tree.root.right.right = new TreeLinkNode(7);

		connect(tree.root);

		System.out.println(tree.root);

	}
}
