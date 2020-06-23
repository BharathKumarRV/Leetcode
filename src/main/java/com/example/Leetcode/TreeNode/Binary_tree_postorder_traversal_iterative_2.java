package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_tree_postorder_traversal_iterative_2 {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	// Important, when you pop a node, ensure its children are traversed.
    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode cur = root;
        
        while (cur != null || !s.empty()) {
            while (!isLeaf(cur)) {
                s.push(cur);
                cur = cur.left;
            }
            
            if (cur != null) ans.add(cur.val);
            
            while (!s.empty() && cur == s.peek().right) {
                cur = s.pop();
                ans.add(cur.val);
            }
            
            if (s.empty()) cur = null; else cur = s.peek().right;
        }
        
        return ans;
    }
    
    private static boolean isLeaf(TreeNode r) {
        if (r == null) return true;
        return r.left == null && r.right == null;
    }
	
	
	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Binary_tree_postorder_traversal_iterative_2 tree = new Binary_tree_postorder_traversal_iterative_2();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> res=postorderTraversal(tree.root);
		System.out.println(res);
	}
}
