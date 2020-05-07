package com.example.Leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Minimum_depth_binary_tree_bfs {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static int minDepth(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    int level = 1;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            TreeNode curNode = queue.poll();
	            if (curNode.left == null && curNode.right == null) {
	                return level;
	            }
	            if (curNode.left != null) {
	                queue.offer(curNode.left);
	            }
	            if (curNode.right != null) {
	                queue.offer(curNode.right);
	            }
	        }
	        level++;
	    }
	    return level;
	}


	
	
	 public static void main(String args[]) {

			Minimum_depth_binary_tree_bfs tree = new Minimum_depth_binary_tree_bfs();

			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(2);
			tree.root.left.left = new TreeNode(3);
			tree.root.left.right = new TreeNode(3);
			tree.root.left.left.left = new TreeNode(4);
			tree.root.left.left.right = new TreeNode(4);
			
			int res=minDepth(tree.root);
			
			System.out.println(res);

		}
}
