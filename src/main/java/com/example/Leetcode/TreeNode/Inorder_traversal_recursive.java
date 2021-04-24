package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

import com.example.Leetcode.TreeNode.Binary_tree_preorder_traversal_recursive.TreeNode;

public class Inorder_traversal_recursive {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Integer> inorder(TreeNode root, List<Integer> list) {
		if (root == null) {
          return list;
		}
		list=inorder(root.left, list);
		list.add(root.val);
		return inorder(root.right, list);
	}
	
	public static void inorder_2(TreeNode root, List<Integer> list) {
		if(root==null) return;
		inorder_2(root.left,list);
		list.add(root.val);
		inorder_2(root.right,list);
	}


	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Inorder_traversal_recursive tree = new Inorder_traversal_recursive();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		inorder(tree.root, new ArrayList<Integer>());
	}
}
