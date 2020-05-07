package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.Leetcode.TreeNode.Inorder_traversal_2.TreeNode;

public class Inorder_traversal_2 {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> list = new ArrayList<>();
	    if(root == null) return list;
	    Stack<TreeNode> stack = new Stack<>();
	    while(root != null || !stack.empty()){
	        while(root != null){
	            stack.push(root);
	            root = root.left;
	        }
	        root = stack.pop();
	        list.add(root.val);
	        root = root.right;
	        
	    }
	    return list;
	}
	
	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Inorder_traversal_2 tree = new Inorder_traversal_2();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		inorderTraversal(tree.root);
	}
}
