package com.example.Leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Path_sum_iterative_2stack {

	TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();

        stack.push(root);
        sums.push(sum);
        while(!stack.isEmpty()&&(root!=null)){
            int value = sums.pop();
            TreeNode top = stack.pop();
            
            if(top.left==null&&top.right==null&&top.val==value){
                return true;
            }
            if(top.right!=null){
                stack.push(top.right);
                sums.push(value-top.val);
            }
            if(top.left!=null){
                stack.push(top.left);
                sums.push(value-top.val);
            }

        }
        return false;
    }
	
	public static boolean hasPathSum_2(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        Queue <TreeNode> stack = new LinkedList();	    
	    stack.offer(root) ;	    
	    while (!stack.isEmpty()){
	    	TreeNode cur = stack.poll() ;	
	    	if (cur.left == null && cur.right == null){	    		
	    		if (cur.val == sum ) return true ;
	    	}
	    	if (cur.right != null) {
	    		cur.right.val = cur.val + cur.right.val ;
	    		stack.offer(cur.right) ;
	    	}
	    	if (cur.left != null) {
	    		cur.left.val = cur.val + cur.left.val;
	    		stack.offer(cur.left);
	    	}
	    }	    
	    return false ;
    }
	
	
	 public static void main(String args[]) {

			Path_sum_iterative_2stack tree = new Path_sum_iterative_2stack();

			tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			tree.root.right = new TreeNode(3);
			tree.root.left.left = new TreeNode(4);
			tree.root.left.right = new TreeNode(5);
			
			boolean res=hasPathSum(tree.root,8);
			
			System.out.println(res);

		}
}
