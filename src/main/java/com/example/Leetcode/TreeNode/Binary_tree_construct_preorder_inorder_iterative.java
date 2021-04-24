package com.example.Leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Binary_tree_construct_preorder_inorder_iterative {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	    if (preorder.length == 0) return null;
	    Stack<TreeNode> s = new Stack<>();
	    TreeNode root = new TreeNode(preorder[0]), cur = root;
	    for (int i = 1, j = 0; i < preorder.length; i++) {
	        if (cur.val != inorder[j]) {
	            cur.left = new TreeNode(preorder[i]);
	            s.push(cur);
	            cur = cur.left;
	        } else {
	            j++;
	            while (!s.empty() && s.peek().val == inorder[j]) {
	                cur = s.pop();
	                j++;
	            }
	            cur = cur.right = new TreeNode(preorder[i]);
	        }
	    }
	    return root;
	}
	
	public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        // deal with edge case(s)
        if (preorder.length == 0) {
            return null;
        }
        
        // build a map of the indices of the values as they appear in the inorder array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        // initialize the stack of tree nodes
        Stack<TreeNode> stack = new Stack<>();
        int value = preorder[0];
        TreeNode root = new TreeNode(value);
        stack.push(root);
        
        // for all remaining values...
        for (int i = 1; i < preorder.length; i ++) {
            // create a node
            value = preorder[i];
            TreeNode node = new TreeNode(value);
            
            if (map.get(value) < map.get(stack.peek().val)) {
                // the new node is on the left of the last node,
                // so it must be its left child (that's the way preorder works)
                stack.peek().left = node;
            } else {
                // the new node is on the right of the last node,
                // so it must be the right child of either the last node
                // or one of the last node's ancestors.
                // pop the stack until we either run out of ancestors
                // or the node at the top of the stack is to the right of the new node
                TreeNode parent = null;
                while(!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        
        return root;
    }
	
	 public static void main(String args[]) {

			Binary_tree_construct_preorder_inorder_iterative tree = new Binary_tree_construct_preorder_inorder_iterative();
			
			int []preorder = {3,9,20,15,7};
		    int []inorder = {9,3,15,20,7};

		    tree.root = buildTree(preorder,inorder);
            System.out.println(tree.root);
		}
}
