package com.academy.binarytree.examples;

import java.util.Stack;

/*
 * In-Order Traversal
 */
public class InOrder {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

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
		System.out.println("Recursive: ");
		inOrderRecursive(root);
		System.out.println();
		System.out.println("Iterative: ");
		inOrderIterative(root);

	}

	private static void inOrderIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode top = stack.peek();
			if (top.left != null) {
				stack.push(top.left);
				top.left = null;
			}
			else {
				top = stack.pop();
				System.out.print(top.val + " ");
				if (top.right != null) {
					stack.push(top.right);
					top.right = null;
				}
			}
		}
		System.out.println();
	}

	private static void inOrderRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderRecursive(root.left);
		System.out.print(root.val + " ");
		inOrderRecursive(root.right);
	}

}
