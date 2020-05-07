package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Level_order_traversal_11_dfs_2 {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>(); // LinkedList - addFirst(), add(), remove() and removeLast()
        recursiveLevelOrderBottom(root, 0, result);
        return result;
    }
    
    private static void recursiveLevelOrderBottom(TreeNode root, int height, LinkedList<List<Integer>> result) {
        if (root == null) { // Base case
            return;
        }
        
        if (height == result.size()) { // Create a new list for current level
            result.addFirst(new ArrayList<>());
        } else if (height < result.size()) { // Move the list for current level from tail to head
            result.addFirst(result.removeLast());
        }
        
        /* Postorder traversal */
        recursiveLevelOrderBottom(root.left, height + 1, result); // Recursive steps
        recursiveLevelOrderBottom(root.right, height + 1, result);
        // Add root value to the list for current level, then move it from head to tail since we are about to backtrack
        result.peek().add(root.val);
        result.add(result.remove());
    }
	
	
	 public static void main(String args[]) {

			Level_order_traversal_11_dfs_2 tree = new Level_order_traversal_11_dfs_2();

			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(3);
			tree.root.right.left = new TreeNode(6);
			tree.root.right.right = new TreeNode(7);
			
			List<List<Integer>> res=levelOrderBottom(tree.root);
			System.out.println(res);

		}
}
