package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Path_sum_2 {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
	    List<List<Integer>>res = new ArrayList<List<Integer>>(); 
	    List<Integer> cur = new ArrayList<Integer>(); 
	    paths(root, sum, cur, res);
	    return res;
	}
	
	public static void paths(TreeNode root, int sum,List<Integer> cur,List<List<Integer>> res) {
        if (root == null)
            return;
        cur.add(root.val);
        if (root.left == null && root.right == null && sum == root.val)
            res.add(new ArrayList<>(cur));
        paths(root.left, sum - root.val,cur,res);
        paths(root.right, sum - root.val,cur,res);
        cur.remove(cur.size() - 1);
    }
	
	 public static void main(String args[]) {

			Path_sum_2 tree = new Path_sum_2();

			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(3);
		/*
		 * tree.root.right.left = new TreeNode(13); tree.root.right.right = new
		 * TreeNode(4); tree.root.right.right.left = new TreeNode(5);
		 * tree.root.right.right.right = new TreeNode(1); tree.root.left.left = new
		 * TreeNode(11); tree.root.left.left.left = new TreeNode(7);
		 * tree.root.left.left.right = new TreeNode(2);
		 */
			
			List<List<Integer>> res=pathSum(tree.root,3);
			
			System.out.println(res);

		}
}
