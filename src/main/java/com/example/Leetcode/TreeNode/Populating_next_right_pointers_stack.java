package com.example.Leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Populating_next_right_pointers_stack {

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
		if(root== null) return root;
	    Queue<TreeLinkNode>q = new LinkedList<>();
	    q.add(root);
	    
	    while(!q.isEmpty()){
	         int size = q.size();
	         TreeLinkNode prev = null;
	        while(size-- >0){
	        	TreeLinkNode poll = q.poll();
	            if(poll.left!=null) q.add(poll.left);
	            if(poll.right!=null) q.add(poll.right);
	            if(prev!=null) prev.next = poll;
	            prev = poll;
	        }
	    }
	    return root;
	}

	public static void main(String args[]) {

		Populating_next_right_pointers_stack tree = new Populating_next_right_pointers_stack();

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
