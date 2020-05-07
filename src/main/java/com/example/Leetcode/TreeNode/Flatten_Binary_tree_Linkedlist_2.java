package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Flatten_Binary_tree_Linkedlist.TreeNode;

public class Flatten_Binary_tree_Linkedlist_2 {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static void flatten(TreeNode root) {
	    flatten(root,null);
	}
	private static  TreeNode flatten(TreeNode root, TreeNode pre) {
	    if(root==null) return pre;
	    pre=flatten(root.right,pre);    
	    pre=flatten(root.left,pre);
	    root.right=pre;
	    root.left=null;
	    pre=root;
	    return pre;
	}
	
	public static void main(String args[]) {

		Flatten_Binary_tree_Linkedlist_2 tree = new Flatten_Binary_tree_Linkedlist_2();

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(5);
		tree.root.right.right = new TreeNode(6);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(4);
		
		flatten(tree.root,null);
		
		System.out.println(tree.root);

	}
}
