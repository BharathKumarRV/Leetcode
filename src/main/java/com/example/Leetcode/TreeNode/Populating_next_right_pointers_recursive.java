package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Populating_next_right_pointers.TreeLinkNode;

public class Populating_next_right_pointers_recursive {

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

	public static void connect(TreeLinkNode root) {
		if (root == null || root.left == null || root.right==null)
			return;
		root.left.next = root.right;
		if (root.next != null)
			root.right.next = root.next.left==null ? root.next.right:root.next.left;
		connect(root.left);
		connect(root.right);
	}

	
	public static TreeLinkNode connect_2(TreeLinkNode root) {
		if (root == null || root.left == null || root.right==null)
			return root;
		root.left.next = root.right;
		if (root.next != null)
			root.right.next = root.next.left;
		connect(root.left);
		connect(root.right);
		return root;
	}
	
	public static void main(String args[]) {

		Populating_next_right_pointers_recursive tree = new Populating_next_right_pointers_recursive();

		tree.root = new TreeLinkNode(1);
		tree.root.left = new TreeLinkNode(2);
		tree.root.right = new TreeLinkNode(3);
		tree.root.left.left = new TreeLinkNode(4);
		tree.root.left.right = new TreeLinkNode(5);
		tree.root.right.left = new TreeLinkNode(6);
		tree.root.right.right = new TreeLinkNode(7);

		connect(tree.root);

		System.out.println(tree.root);

	}
}
