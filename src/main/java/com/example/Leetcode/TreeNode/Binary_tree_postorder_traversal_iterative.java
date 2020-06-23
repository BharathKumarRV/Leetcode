package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_tree_postorder_traversal_iterative {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(0,curr.val);
            if(curr.left!=null) {
              stack.push(curr.left);
            }
            if(curr.right!=null) {
               stack.push(curr.right); 
            }
        }
        return list;
    }
	
	
	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Binary_tree_postorder_traversal_iterative tree = new Binary_tree_postorder_traversal_iterative();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> res=postorderTraversal(tree.root);
		System.out.println(res);
	}
	
	
}
