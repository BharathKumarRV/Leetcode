package com.example.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Top_view_traversal {

	TreeNode root;

	static class Pair {
		TreeNode node;
		int ind;

		public Pair(TreeNode _node, int _ind) {
			node = _node;
			ind = _ind;
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static ArrayList<Integer> topView(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair it = q.remove();
			int ind = it.ind;
			TreeNode temp = it.node;
			if (map.get(ind) == null)
				map.put(ind, temp.val);
			if (temp.left != null) {

				q.add(new Pair(temp.left, ind - 1));
			}
			if (temp.right != null) {

				q.add(new Pair(temp.right, ind + 1));
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}
		return ans;

	}
	
	static ArrayList <Integer> bottomView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
    	q.add(new Pair(root, 0)); 
        while(!q.isEmpty()) {
        	Pair it = q.remove();
            int ind = it.ind; 
            TreeNode temp = it.node;
            map.put(ind, temp.val); 
            if(temp.left != null) {
                q.add(new Pair(temp.left, ind - 1)); 
            }
            if(temp.right != null) {
                q.add(new Pair(temp.right, ind + 1));
            }
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }

	public static void main(String args[]) {
		Top_view_traversal tree = new Top_view_traversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		List<Integer> res = topView(tree.root);
		List<Integer> res1 = bottomView(tree.root);
		System.out.println(res);
		System.out.println(res1);
	}

}


