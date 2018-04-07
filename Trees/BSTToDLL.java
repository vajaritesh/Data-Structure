package com.academy.binarytree.examples;

/*
 * https://articles.leetcode.com/convert-binary-search-tree-bst-to/
 * Convert Binary Search Tree (BST) to Sorted Doubly-Linked List
 */
public class BSTToDLL {
	static class DLList {
		int key;
		String value;
		DLList prev;
		DLList next;

		DLList(int key, String value) {
			this.key = key;
			this.value = value;
			prev = next = null;
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}

	static TreeNode prev;
	static TreeNode head;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		// root.right.left = new TreeNode(45);
		// root.right.right = new TreeNode(70);
		// root.right.right.left = new TreeNode(65);
		// root.right.right.right = new TreeNode(80);
		TreeNode head = buildBSTToDLLT(root);
		print(head);
	}

	private static TreeNode buildBSTToDLLT(TreeNode root) {
		if (root == null) {
			return null;
		}
		buildBSTToDLLT(root.left);
		root.left = prev;
		if (prev == null) {
			head = root;
		}
		else {
			prev.right = root;
		}
		prev = root;
		TreeNode right = root.right;
		head.left = root;
		root.right = head;
		buildBSTToDLLT(right);
		return head;
	}

	private static void print(TreeNode head) {
		TreeNode start = head;
		do {
			System.out.print(start.val + " ");
			start = start.right;
		}
		while (start != head);
	}

}
