package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.InorderSuccesorPredessor.TreeNode;

public class Floor_Ceil_InBST {

	TreeNode root;

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			data = x;
		}
	}

	public static TreeNode floorInBST(TreeNode root, int key) {
		TreeNode floor = new TreeNode(-1);
		while (root != null) {
			if (root.data == key) {
				floor = root;
				return floor;
			}

			if (key > root.data) {
				floor = root;
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return floor;
	}
	
	public static TreeNode ceilInBST(TreeNode root, int key) {
		TreeNode floor = new TreeNode(-1);
		while (root != null) {
			if (root.data == key) {
				floor = root;
				return floor;
			}

			if (key < root.data) {
				floor = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return floor;
	}
	
	

	public static void main(String args[]) {

		Floor_Ceil_InBST tree = new Floor_Ceil_InBST();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(5);
		tree.root.left.right = new TreeNode(2);
		TreeNode res = floorInBST(tree.root, 4);
		TreeNode res1 = ceilInBST(tree.root, 4);
		System.out.println(res1.data);
	}
}
