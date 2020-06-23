package com.example.Leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.example.Leetcode.TreeNode.Binary_tree_preorder_traversal.TreeNode;

public class Binary_tree_preorder_traversal_recursive {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		preHelper(root,pre);
		return pre;
	}
	public static void preHelper(TreeNode root, List<Integer> pre) {
		if(root==null) return;
		pre.add(root.val);
		preHelper(root.left,pre);
		preHelper(root.right,pre);
	}
	
	
	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Binary_tree_preorder_traversal_recursive tree = new Binary_tree_preorder_traversal_recursive();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> res=preorderTraversal(tree.root);
		System.out.println(res);
	}
}
