package com.example.Leetcode.TreeNode;

import java.util.List;

import com.example.Leetcode.TreeNode.Maximum_depth_Binary_tree_recursive.TreeNode;

public class Maximum_depth_Binary_tree_recursive {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
	
	 public static void main(String args[]) {

			Maximum_depth_Binary_tree_recursive tree = new Maximum_depth_Binary_tree_recursive();
			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(3);
			tree.root.right.left = new TreeNode(6);
			tree.root.right.right = new TreeNode(7);

			int res = maxDepth(tree.root);

			System.out.println(res);
		}
}
