package com.example.Leetcode.TreeNode;

import java.util.Stack;

import com.example.Leetcode.TreeNode.Inorder_traversal.TreeNode;

public class Binary_search_tree_iterator {

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

	  Stack<TreeNode> stack;
	    TreeNode root;
	    public Binary_search_tree_iterator(TreeNode root) {
	        stack = new Stack();
	        this.root = root;
	    }

	    public Binary_search_tree_iterator() {
			// TODO Auto-generated constructor stub
		}

		/** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty() || root != null;
	    }

	    /** @return the next smallest number */
	    public int next() {
	        while (root != null) {
	            stack.push(root);
	            root = root.left;
	        }
	        root = stack.pop();
	        int res = root.val;
	        root = root.right;
	        return res;
	    }
	    
	    public static void main(String args[]) {

			/*
			 * creating a binary tree and entering the nodes
			 */
	    	Binary_search_tree_iterator tree = new Binary_search_tree_iterator();
			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(3);
			tree.root.left.left = new TreeNode(4);
			tree.root.left.right = new TreeNode(5);
			Binary_search_tree_iterator tree1 = new Binary_search_tree_iterator(tree.root);
			int res=tree1.next();
			System.out.println(res);
			int res1=tree1.next();
			System.out.println(res1);
			int res2=tree1.next();
			System.out.println(res2);
			boolean res3=tree1.hasNext();
			System.out.println(res3);
			int res4=tree1.next();
			System.out.println(res4);
			int res5=tree1.next();
			System.out.println(res5);
			boolean res6=tree1.hasNext();
			System.out.println(res6);
			
			
			
			
		}
}
