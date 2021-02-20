package com.example.Leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Is_same_tree_iterative {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if(f == null && s == null){
                continue;
            }else if(f == null || s == null || f.val != s.val){
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
    }
	
	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Is_same_tree_iterative tree1 = new Is_same_tree_iterative();
		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(2);
		tree1.root.right = new TreeNode(3);
		
		Is_same_tree_iterative tree2 = new Is_same_tree_iterative();
		tree2.root = new TreeNode(1);
		tree2.root.left = new TreeNode(2);
		tree2.root.right = new TreeNode(3);

		boolean res=isSameTree(tree1.root,tree2.root);
		
		System.out.println(res);
	}
}
