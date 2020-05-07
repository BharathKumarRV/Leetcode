package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level_order_traversal {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> res = new ArrayList<>();  
		 if (root == null) return res;  
		 Queue<TreeNode> queue = new LinkedList<>();  
		 queue.add(root);  
		 while (!queue.isEmpty()) {  
			 int cnt = queue.size();
			 List<Integer> level=new ArrayList<>();
			 for(int i=0;i<cnt;i++) {
				 TreeNode current=queue.remove();
				 level.add(current.val);
				 if(current.left!=null) {
					 queue.add(current.left);
				 }
				 if(current.right!=null) {
					 queue.add(current.right);
				 }
			 }
			 res.add(level);
		 }
		 
		 return res;
	 }

	public static void main(String args[]) {

		Level_order_traversal tree = new Level_order_traversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(2);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(4);
		tree.root.right.left = new TreeNode(4);
		tree.root.right.right = new TreeNode(3);

		List<List<Integer>> res = levelOrder(tree.root);

		System.out.println(res);
	}
}
