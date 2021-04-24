package com.example.Leetcode.TreeNode;

import com.example.Leetcode.TreeNode.Populating_next_right_pointers_2_iterative.TreeLinkNode;

public class Populating_next_right_pointers_2_iterative_2while {

	TreeLinkNode root;

	static class TreeLinkNode {
		public int val;
		public TreeLinkNode left;
		public TreeLinkNode right;
		public TreeLinkNode next;

		public TreeLinkNode() {
		}

		public TreeLinkNode(int _val) {
			val = _val;
		}

		public TreeLinkNode(int _val, TreeLinkNode _left, TreeLinkNode _right, TreeLinkNode _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};
	
	public static TreeLinkNode connect(TreeLinkNode root) {
		helper(root);
		return root;
	}
	
	 public static void helper(TreeLinkNode root) {
	        TreeLinkNode head=root;//The left most node in the lower level
	        TreeLinkNode prev=null;//The previous node in the lower level
	        TreeLinkNode curr=null;//The current node in the upper level
	        while (head!=null){
	            curr=head;
	            prev=null;
	            head=null;
	            while (curr!=null){
	                if (curr.left!=null){
	                    if (prev!=null)
	                        prev.next=curr.left;
	                    else 
	                        head=curr.left;
	                    prev=curr.left;
	                }
	                if (curr.right!=null){
	                    if (prev!=null)
	                        prev.next=curr.right;
	                    else 
	                        head=curr.right;
	                    prev=curr.right;
	                }
	                curr=curr.next;
	            }
	        }
	    }
	 
	 //Go through this
	 public static void helper_2(TreeLinkNode root) {
			if (root == null)
				return;
			TreeLinkNode head = root;
			while (head != null) {
				TreeLinkNode nextDummyHead = new TreeLinkNode(0);
				TreeLinkNode temp = nextDummyHead;
				while (head != null) {
					if (head.left != null) {
						temp.next = head.left;
						temp = temp.next;
					}
					if (head.right != null) {
						temp.next = head.right;
						temp = temp.next;
					}
					head = head.next;
				}

				head = nextDummyHead.next;
			}
		}
	 
	 public static void main(String args[]) {

			Populating_next_right_pointers_2_iterative_2while tree = new Populating_next_right_pointers_2_iterative_2while();

			tree.root = new TreeLinkNode(1);
			tree.root.left = new TreeLinkNode(2);
			tree.root.right = new TreeLinkNode(3);
			tree.root.left.left = new TreeLinkNode(4);
			tree.root.left.right = new TreeLinkNode(5);
			tree.root.right.right = new TreeLinkNode(7);

			connect(tree.root);

			System.out.println(tree.root);

		}
}
