package com.academy.binarytree.homework;
/*
 * Clone Tree
 */
public class CloneTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		// root.left.left.left = new TreeNode(10);
		// root.left.left.right = new TreeNode(20);
		//
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		// root.right.left.left = new TreeNode(50);
		// root.right.left.right = new TreeNode(60);
		// root.right.right.right = new TreeNode(80);
		printInOrder(root);
		TreeNode cloneRoot = cloneTree(root);
		System.out.println();
		printInOrder(cloneRoot);

	}

	private static void printInOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}

	private static TreeNode cloneTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = cloneTree(root.left);
		TreeNode right = cloneTree(root.right);
		TreeNode cloneRoot = new TreeNode(root.data);
		cloneRoot.left = left;
		cloneRoot.right = right;
		return cloneRoot;
	}

}
