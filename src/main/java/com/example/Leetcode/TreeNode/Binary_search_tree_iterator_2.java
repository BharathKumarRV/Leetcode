package com.example.Leetcode.TreeNode;

import java.util.Stack;

import com.example.Leetcode.TreeNode.Binary_search_tree_iterator.TreeNode;

public class Binary_search_tree_iterator_2 {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	TreeNode root;
	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public Binary_search_tree_iterator_2(TreeNode root) {
		partialInorder(root);
	}

	public Binary_search_tree_iterator_2() {
		// TODO Auto-generated constructor stub
	}

	public void partialInorder(TreeNode root) {
		while(root!=null) {
			stack.push(root);
			root=root.left;
		}
	}
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode top = stack.pop();
		partialInorder(top.right);
		return top.val;
	}

	public static void main(String args[]) {
		Binary_search_tree_iterator_2 tree = new Binary_search_tree_iterator_2();
		tree.root = new TreeNode(7);
		tree.root.left = new TreeNode(3);
		tree.root.right = new TreeNode(15);
		tree.root.left.left = new TreeNode(9);
		tree.root.left.right = new TreeNode(20);
		Binary_search_tree_iterator_2 tree1 = new Binary_search_tree_iterator_2(tree.root);
		int res = tree1.next();
		System.out.println(res);
		int res1 = tree1.next();
		System.out.println(res1);
		int res2 = tree1.next();
		System.out.println(res2);
		boolean res3 = tree1.hasNext();
		System.out.println(res3);
		int res4 = tree1.next();
		System.out.println(res4);
		int res5 = tree1.next();
		System.out.println(res5);
		boolean res6 = tree1.hasNext();
		System.out.println(res6);
	}
}
