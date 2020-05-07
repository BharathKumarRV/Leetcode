package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Level_order_traversal_zig_zag_dfs {
	
	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	 public static List<List<Integer>> zigzagLevelOrder(TreeNode root) 
	    {
	        List<List<Integer>> sol = new ArrayList<>();
	        travel(root, sol, 0);
	        return sol;
	    }
	    
	    private static void travel(TreeNode curr, List<List<Integer>> sol, int level)
	    {
	        if(curr == null) return;
	        
	        if(sol.size() <= level)
	        {
	            List<Integer> newLevel = new LinkedList<>();
	            sol.add(newLevel);
	        }
	        
	        List<Integer> collection  = sol.get(level);
	        if(level % 2 == 0) collection.add(curr.val);
	        else collection.add(0, curr.val);
	        
	        travel(curr.left, sol, level + 1);
	        travel(curr.right, sol, level + 1);
	    }
	    
	    public static void main(String args[]) {

			Level_order_traversal_zig_zag_dfs tree = new Level_order_traversal_zig_zag_dfs();
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
