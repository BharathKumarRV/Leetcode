package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Is_same_tree.TreeNode;

public class Is_same_tree {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
	    
	    // Equal nullity denotes that this branch is the same (local equality)
	    // This is a base case, but also handles being given two empty trees
	    if (p == null && q == null) return true;
	    
	    // Unequal nullity denotes that the trees aren't the same
	    // Note that we've already ruled out equal nullity above
	    else if (p == null || q == null) return false;
	        
	    // Both nodes have values; descend iff those values are equal
	    // "&&" here allows for any difference to overrule a local equality
	    if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	    
	    // If we're here, both nodes have values, and they're unequal, so the trees aren't the same
	    return false;
	}
	

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Is_same_tree tree1 = new Is_same_tree();
		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(2);
		tree1.root.right = new TreeNode(3);
		
		Is_same_tree tree2 = new Is_same_tree();
		tree2.root = new TreeNode(1);
		tree2.root.left = new TreeNode(2);
		tree2.root.right = new TreeNode(3);

		boolean res=isSameTree(tree1.root,tree2.root);
		
		System.out.println(res);
	}
}
