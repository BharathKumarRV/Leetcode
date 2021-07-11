package com.example.Leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

import com.example.Leetcode.TreeNode.Binary_tree_construct_preorder_inorder_map.TreeNode;

public class Binary_tree_construct_preorder_inorder_map_2 {

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
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
	}

	public static TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> map) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = map.get(preorder[preStart]);
		int diff = inIndex - inStart;
		root.left = helper(preorder, preStart + 1, preStart + diff, inorder, inStart, inStart + diff, map);
		root.right = helper(preorder, preStart + diff + 1, preEnd, inorder, inStart + diff + 1, inEnd, map);
		return root;
	}

	public static void main(String args[]) {

		Binary_tree_construct_preorder_inorder_map_2 tree = new Binary_tree_construct_preorder_inorder_map_2();

		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		tree.root = buildTree(preorder, inorder);
		System.out.println(tree.root);
	}

}
