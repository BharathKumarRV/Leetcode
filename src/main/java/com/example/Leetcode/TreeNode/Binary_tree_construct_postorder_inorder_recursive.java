package com.example.Leetcode.TreeNode;

import java.util.HashMap;

public class Binary_tree_construct_postorder_inorder_recursive {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	 public static TreeNode buildTree(int[] inorder, int[] postorder) {
		    if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
		    HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
		    for (int i=0;i<inorder.length;++i)
			    hm.put(inorder[i], i);
		    return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1,hm);
	    }

	    private static TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer,Integer> hm){
	        if (ps>pe || is>ie) return null;
	        TreeNode root = new TreeNode(postorder[pe]);
	        int ri = hm.get(postorder[pe]);
	        int leftlen =  ri-1-is, rightlen = ie-(ri+1);
	        TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+leftlen, hm);
	        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, pe-1-rightlen, pe-1, hm);
	        root.left = leftchild;
	        root.right = rightchild;
	        return root;
	    }
	    
	    public static void main(String args[]) {

			Binary_tree_construct_postorder_inorder_recursive tree = new Binary_tree_construct_postorder_inorder_recursive();
			
			int []postorder = {9,15,7,20,3};
		    int []inorder = {9,3,15,20,7};

		    tree.root = buildTree(inorder,postorder);
            System.out.println(tree.root);
		}
}
