package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Lowest_common_ancestor_BST.TreeNode;

public class Lowest_common_ancestor_BT {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	
	 private static TreeNode lowestCommonAncestor(TreeNode curr, TreeNode A, TreeNode B) {
         
	        if(curr == null) {
	            return null;
	        }
	         
	        // If we find p or q, we return the node
	        if(curr == A || curr == B)
	            return curr;
	         
	        // Recursive calls to find LCA in left and right subtrees
	        TreeNode leftNode = lowestCommonAncestor(curr.left, A, B);
	        TreeNode rightNode = lowestCommonAncestor(curr.right, A, B);
	         
	        // If we found p and q in left or right subtree of the current node, 
	        // this means current node is a common ancestor, so return the node
	        if(leftNode != null && rightNode != null)
	            return curr;
	         
	        // If we found p or q in left or right subtree of the current node,
	        // the means current node is an ancestor, return the node
	        if(leftNode == null) {
	            return rightNode;
	        } else {
	            return leftNode;
	        }
	    }
	
	
	
	public static void main(String args[]) {

		Lowest_common_ancestor_BT tree = new Lowest_common_ancestor_BT();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(5);
		tree.root.left.left = new TreeNode(6);
		tree.root.left.right = new TreeNode(2);
		tree.root.left.right.left = new TreeNode(7);
		tree.root.left.right.right = new TreeNode(4);
		tree.root.right = new TreeNode(1);
		tree.root.right.left = new TreeNode(0);
		tree.root.right.right = new TreeNode(8);
		TreeNode res = lowestCommonAncestor(tree.root, tree.root.left, tree.root.left.right.right);
		System.out.println(res);
	}
}
