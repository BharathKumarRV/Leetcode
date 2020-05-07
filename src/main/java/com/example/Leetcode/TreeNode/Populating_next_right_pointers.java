package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Flatten_Binary_tree_Linkedlist_stack.TreeNode;

public class Populating_next_right_pointers {

	TreeLinkNode root;
	
	static class TreeLinkNode {
	    public int val;
	    public TreeLinkNode left;
	    public TreeLinkNode right;
	    public TreeLinkNode next;

	    public TreeLinkNode() {}
	    
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
	    while(root != null && root.left != null) {
	        TreeLinkNode cur = root;
	        while(cur != null) {
	            cur.left.next = cur.right;
	            cur.right.next = cur.next == null ? null : cur.next.left;
	            cur = cur.next;
	        }
	        root = root.left;
	    }
	}
	
	
	public static void main(String args[]) {

		Populating_next_right_pointers tree = new Populating_next_right_pointers();

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
