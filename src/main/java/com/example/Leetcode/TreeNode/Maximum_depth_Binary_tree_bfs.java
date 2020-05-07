package com.example.Leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_depth_Binary_tree_bfs {

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
	    if(root == null) {
	        return 0;
	    }
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    int count = 0;
	    while(!queue.isEmpty()) {
	        int size = queue.size();
	        while(size-- > 0) {
	            TreeNode node = queue.poll();
	            if(node.left != null) {
	                queue.offer(node.left);
	            }
	            if(node.right != null) {
	                queue.offer(node.right);
	            }
	        }
	        count++;
	    }
	    return count;
	}
	
	 public static void main(String args[]) {

			Maximum_depth_Binary_tree_bfs tree = new Maximum_depth_Binary_tree_bfs();
			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(3);
			tree.root.right.left = new TreeNode(6);
			tree.root.right.right = new TreeNode(7);

			int res = maxDepth(tree.root);

			System.out.println(res);
		}
}
