package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Binary_tree_construct_preorder_inorder_iterative {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	    if (preorder.length == 0) return null;
	    Stack<TreeNode> s = new Stack<>();
	    TreeNode root = new TreeNode(preorder[0]), cur = root;
	    for (int i = 1, j = 0; i < preorder.length; i++) {
	        if (cur.val != inorder[j]) {
	            cur.left = new TreeNode(preorder[i]);
	            s.push(cur);
	            cur = cur.left;
	        } else {
	            j++;
	            while (!s.empty() && s.peek().val == inorder[j]) {
	                cur = s.pop();
	                j++;
	            }
	            cur = cur.right = new TreeNode(preorder[i]);
	        }
	    }
	    return root;
	}
	
	 public static void main(String args[]) {

			Binary_tree_construct_preorder_inorder_iterative tree = new Binary_tree_construct_preorder_inorder_iterative();
			
			int []preorder = {3,9,20,15,7};
		    int []inorder = {9,3,15,20,7};

		    tree.root = buildTree(preorder,inorder);
            System.out.println(tree.root);
		}
}
