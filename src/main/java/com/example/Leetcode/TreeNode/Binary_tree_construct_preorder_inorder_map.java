package com.example.Leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Binary_tree_construct_preorder_inorder_map {

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
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<inorder.length;i++) {
			map.put(inorder[i],i);
		}
	    return helper(0, 0, inorder.length - 1, preorder, inorder,map);
	}

	public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder,Map<Integer,Integer> map) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex= map.get(preorder[preStart]);
	    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder,map);
	    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder,map);
	    return root;
	}
	
	 public static void main(String args[]) {

			Binary_tree_construct_preorder_inorder_map tree = new Binary_tree_construct_preorder_inorder_map();
			
			int []preorder = {3,9,20,15,7};
		    int []inorder = {9,3,15,20,7};

		    tree.root = buildTree(preorder,inorder);
            System.out.println(tree.root);
		}
}
