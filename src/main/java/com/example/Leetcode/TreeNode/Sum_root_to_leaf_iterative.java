package com.example.Leetcode.TreeNode;

import java.util.Stack;

public class Sum_root_to_leaf_iterative {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum = 0;
        TreeNode curr;
        Stack<TreeNode> ws = new Stack<TreeNode>();
        ws.push(root);
        
        while(!ws.empty()){
            curr = ws.pop();
            
            if(curr.right!=null){
                curr.right.val = curr.val*10+curr.right.val;
                ws.push(curr.right);
            }
            
            if(curr.left!=null){
                curr.left.val = curr.val*10+curr.left.val;
                ws.push(curr.left);
            }
            
            if(curr.left==null && curr.right==null){ // leaf node
                sum+=curr.val;
            }
        }
        return sum;
    }
	
	public static void main(String args[]) {

		Sum_root_to_leaf_iterative tree = new Sum_root_to_leaf_iterative();

		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(0);
		tree.root.left.left = new TreeNode(5);
		tree.root.left.right = new TreeNode(1);

		int res = sumNumbers(tree.root);

		System.out.println(res);

	}
}
