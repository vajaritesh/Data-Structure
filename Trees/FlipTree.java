package com.academy.binarytree.homework;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Invert Binary Tree
 */
public class FlipTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);
		// root.left.left.left = new TreeNode(10);
		// root.left.left.right = new TreeNode(20);
		//
		// root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		// root.right.left.left = new TreeNode(50);
		// root.right.left.right = new TreeNode(60);
		// root.right.right.right = new TreeNode(80);
		printInOrder(root);
		TreeNode flipRoot = flipTree(root);
		System.out.println();
		printInOrder(flipRoot);
		flipRoot = flipTreeIterative(root);
		System.out.println();
		printInOrder(flipRoot);
	}

	private static TreeNode flipTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		flipTree(root.left);
		flipTree(root.right);
		return root;
	}

	public static void swapChildren(TreeNode node) {
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public static TreeNode flipTreeIterative(TreeNode node) {
		if (node == null) {
			return node;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			TreeNode top = queue.poll();
			swapChildren(top);
			if (top.left != null) {
				queue.add(top.left);
			}
			if (top.right != null) {
				queue.add(top.right);
			}
		}
		return node;
	}

	private static void printInOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}

}
