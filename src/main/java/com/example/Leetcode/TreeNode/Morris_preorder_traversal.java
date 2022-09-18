package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Morris_preorder_traversal {

	Node root;

	static class Node {
		int val;
		Node left;
		Node right;

		Node(int x) {
			val = x;
		}
	}
	static ArrayList < Integer > preorderTraversal(Node root) {
        ArrayList < Integer > preorder = new ArrayList < > ();
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.val);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.val);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }
	
	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Morris_preorder_traversal tree = new Morris_preorder_traversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		List<Integer> res =preorderTraversal(tree.root);
		System.out.println(res);
	}

}
