package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Balanced_binary_tree.TreeNode;

public class Count_Nodes {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static int countNodes(TreeNode root) {

	    int leftDepth = leftDepth(root);
		int rightDepth = rightDepth(root);

		if (leftDepth == rightDepth)
			return (1 << leftDepth) - 1; // If Binary tree is complete, calculate nodes by 2^h-1
		else
			return 1+countNodes(root.left) + countNodes(root.right);

	}

	private static int rightDepth(TreeNode root) {
		// TODO Auto-generated method stub
		int dep = 0;
		while (root != null) {
			root = root.right;
			dep++;
		}
		return dep;
	}

	private static int leftDepth(TreeNode root) {
		// TODO Auto-generated method stub
		int dep = 0;
		while (root != null) {
			root = root.left;
			dep++;
		}
		return dep;
	}
	
	 public static void main(String args[]) {

		 Count_Nodes tree = new Count_Nodes();

			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(3);
			//tree.root.left.left = new TreeNode(4);
			//tree.root.left.right = new TreeNode(5);
			tree.root.right.left = new TreeNode(6);
			tree.root.right.right = new TreeNode(7);
			
			int res=countNodes(tree.root);
			
			System.out.println(res);

		}
}
