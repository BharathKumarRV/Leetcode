package com.example.Leetcode.TreeNode;

import java.util.List;

import com.example.Leetcode.TreeNode.Sorted_array_to_bst.TreeNode;

public class Sorted_array_to_bst {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode sortedArrayToBST(int[] num) {
	    if (num.length == 0) {
	        return null;
	    }
	    TreeNode head = helper(num, 0, num.length - 1);
	    return head;
	}

	public static TreeNode helper(int[] num, int low, int high) {
	    if (low > high) { // Done
	        return null;
	    }
	    int mid = (low + high) / 2;
	    TreeNode node = new TreeNode(num[mid]);
	    node.left = helper(num, low, mid - 1);
	    node.right = helper(num, mid + 1, high);
	    return node;
	}
	
	
	public static void main(String args[]) {

		Sorted_array_to_bst tree = new Sorted_array_to_bst();
		int num[]= {-10,-3,0,5,9};
		
		tree.root=sortedArrayToBST(num);
		System.out.println(tree.root);

	}
}
