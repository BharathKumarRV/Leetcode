package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Flatten_Binary_tree_Linkedlist_stack {

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
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode curr = stk.pop();
            if (curr.right!=null)  
                 stk.push(curr.right);
            if (curr.left!=null)  
                 stk.push(curr.left);
            if (!stk.isEmpty()) 
                 curr.right = stk.peek();
            curr.left = null;  // dont forget this!! 
        }
    }
	
	public static void main(String args[]) {

		Flatten_Binary_tree_Linkedlist_stack tree = new Flatten_Binary_tree_Linkedlist_stack();

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
