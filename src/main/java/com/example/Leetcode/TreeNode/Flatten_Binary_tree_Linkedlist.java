package com.example.Leetcode.TreeNode;

import java.util.List;

import com.example.Leetcode.TreeNode.Flatten_Binary_tree_Linkedlist.TreeNode;

public class Flatten_Binary_tree_Linkedlist {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	private static TreeNode prev = null;
	
	public static void flatten(TreeNode root) {
	    if (root == null)
	        return;
	    flatten(root.right);
	    flatten(root.left);
	    root.right = prev;
	    root.left = null;
	    prev = root;
	}
	
	
	public static void main(String args[]) {

		Flatten_Binary_tree_Linkedlist tree = new Flatten_Binary_tree_Linkedlist();

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(5);
		tree.root.right.right = new TreeNode(6);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(4);
		
		flatten(tree.root);
		
		System.out.println(tree.root);

	}
}
