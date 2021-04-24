package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level_order_zig_zag_queue {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;

		    Queue<TreeNode> q = new LinkedList<>();
		    q.add(root);
		    boolean order = true;
		    int size = 0;

		    while(!q.isEmpty()) {
		        List<Integer> tmp = new ArrayList<>();
		        size = q.size();
		        for(int i = 0; i < size; ++i) {
		            TreeNode n = q.poll();
		            if(order) {
		                tmp.add(n.val);
		            } else {
		                tmp.add(0, n.val);
		            }
		            if(n.left != null) q.add(n.left);
		            if(n.right != null) q.add(n.right);
		        }
		        res.add(tmp);
		        order = order ? false : true;
		    }
		    return res;
		}
	
	public static void main(String args[]) {

		Level_order_zig_zag_queue tree = new Level_order_zig_zag_queue();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);

		List<List<Integer>> res = zigzagLevelOrder(tree.root);

		System.out.println(res);
	}
	
}
