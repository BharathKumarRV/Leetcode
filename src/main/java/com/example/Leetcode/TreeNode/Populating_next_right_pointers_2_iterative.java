package com.example.Leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import com.example.Leetcode.TreeNode.Populating_next_right_pointers_stack.TreeLinkNode;

public class Populating_next_right_pointers_2_iterative {

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
		helper_2(root);
		return root;
	}

	public static void helper(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode curP = root;
		TreeLinkNode nextDummyHead = new TreeLinkNode(0);
		TreeLinkNode p = nextDummyHead;
		while (curP != null) {
			if (curP.left != null) {
				p.next = curP.left;
				p = p.next;
			}
			if (curP.right != null) {
				p.next = curP.right;
				p = p.next;
			}
			if (curP.next != null) {
				curP = curP.next;
			} else {
				curP = nextDummyHead.next;
				nextDummyHead.next = null;
				p = nextDummyHead;
			}
		}
	}

	public static void helper_2(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode head = root;
		while (head != null) {
			TreeLinkNode nextDummyHead = new TreeLinkNode(0);
			TreeLinkNode temp = nextDummyHead;
			while (head != null) {
				if (head.left != null) {
					temp.next = head.left;
					temp = temp.next;
				}
				if (head.right != null) {
					temp.next = head.right;
					temp = temp.next;
				}
				head = head.next;
			}

			head = nextDummyHead.next;
		}
	}

	public static void main(String args[]) {

		Populating_next_right_pointers_2_iterative tree = new Populating_next_right_pointers_2_iterative();

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
