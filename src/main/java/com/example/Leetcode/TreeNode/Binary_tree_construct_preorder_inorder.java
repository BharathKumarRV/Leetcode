package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Binary_tree_construct_preorder_inorder.TreeNode;

public class Binary_tree_construct_preorder_inorder {

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
	    return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	        }
	    }
	    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	
	 public static void main(String args[]) {

			Binary_tree_construct_preorder_inorder tree = new Binary_tree_construct_preorder_inorder();
			
			int []preorder = {3,9,20,15,7};
		    int []inorder = {9,3,15,20,7};

		    tree.root = buildTree(preorder,inorder);
            System.out.println(tree.root);
		}
}
