package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Binary_tree_construct_postorder_inorder_recursive.TreeNode;

public class Binary_tree_construct_postorder_inorder_recursive_2 {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private static TreeNode build_tree_rec(int[] inorder, int i1, int i2, int[] postorder, int p1, int p2){
        if(i1 >=i2 || p1 >= p2) return null;
        TreeNode root = new TreeNode(postorder[p2-1]);
        int it = 0;
        for(int i = i1; i <i2; ++i){
            if(postorder[p2-1] == inorder[i]) {
                it = i;
                break;
            }
        }
        int diff = it - i1; //How far the element is from start
        root.left = build_tree_rec(inorder, i1, i1 + diff, postorder, p1, p1+diff); //p1+diff since same number of elements are present in left subtree postorder
        root.right = build_tree_rec(inorder, i1+diff+1, i2, postorder, p1+diff, p2-1);
        
        //i1+diff+1 since we have to count elements after root(L,root,R)
        //p1+diff since in postorder right elements occurs immediately after left(L,R,root)
        //p2-1, as we have to consider next root
        
        return root;
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(n == 0) return null;
        
        return build_tree_rec(inorder, 0, n, postorder, 0, n);
    }
	
	
	 public static void main(String args[]) {

			Binary_tree_construct_postorder_inorder_recursive_2 tree = new Binary_tree_construct_postorder_inorder_recursive_2();
			
			int []postorder = {9,15,7,20,3};
		    int []inorder = {9,3,15,20,7};

		    tree.root = buildTree(inorder,postorder);
         System.out.println(tree.root);
		}
	 
	 
}
