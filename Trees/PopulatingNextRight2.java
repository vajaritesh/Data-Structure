package com.academy.binarytree.examples;

/*
 * Populating Next Right Pointers in Each Node
 * With Constance space
 * With Binary Tree is not Perfect or Full.
 */
public class PopulatingNextRight2 {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		nextRight(root);

	}

	private static void nextRight(TreeNode root) {
		TreeNode head = null; // head of the next level
		TreeNode prev = null; // the leading node on the next level
		TreeNode cur = root; // current node of current level

		while (cur != null) {

			while (cur != null) { // iterate on the current level
				// left child
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					}
					else {
						head = cur.left;
					}
					prev = cur.left;
				}
				// right child
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					}
					else {
						head = cur.right;
					}
					prev = cur.right;
				}
				// move to next node
				cur = cur.next;
			}

			// move to next level
			cur = head;
			head = null;
			prev = null;
		}
	}

}
