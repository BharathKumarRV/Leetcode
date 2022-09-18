package com.example.Leetcode.TreeNode;

public class InorderSuccesorPredessor {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode successor = null;
        
        while (root != null) {
            
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        
        return successor;
    }

public static TreeNode inorderPredessor(TreeNode root, TreeNode p) {
    
    TreeNode predessor = null;
    
    while (root != null) {
        
        if (p.val<= root.val) {
            root = root.left;
        } else {
        	predessor = root;
            root = root.right;
        }
    }
    
    return predessor;
}

public static void main(String args[]) {

	InorderSuccesorPredessor tree = new InorderSuccesorPredessor();
	tree.root = new TreeNode(2);
	tree.root.left = new TreeNode(1);
	tree.root.right = new TreeNode(3);
	// tree.root.left.left = new TreeNode(4);
	// tree.root.left.right = new TreeNode(5);
	//boolean res = isValidBST(tree.root);
	TreeNode res = inorderSuccessor(tree.root,tree.root);
	TreeNode res2 = inorderPredessor(tree.root,tree.root);
	System.out.println(res2.val);
}
}
