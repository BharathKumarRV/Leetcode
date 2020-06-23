package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Binary_tree_postorder_traversal_recursive {

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
         List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        helper(res, root);
        return res;
    }
    
    private static void helper(List<Integer> res, TreeNode node){
        if(node.left != null){
            helper(res, node.left);
        }
        if(node.right != null){
            helper(res, node.right);
        }
        res.add(node.val);
    }

	
	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 * pre-order traversal is root-left-right, 
		 * and post order is left-right-root. 
		 * modify the code for pre-order to make it root-right-left, 
		 * and then reverse the output so that we can get left-right-root .
		 */
		Binary_tree_postorder_traversal_recursive tree = new Binary_tree_postorder_traversal_recursive();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> res=postorderTraversal(tree.root);
		System.out.println(res);
	}
	
}
