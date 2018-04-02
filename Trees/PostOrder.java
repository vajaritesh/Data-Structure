package com.academy.binarytree.examples;

import java.util.Stack;

/*
 * Post Order Traversal
 */
public class PostOrder {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		printPostOrderRec(root);
		System.out.println();
		printPostOrderIterative(root);
	}

	private static void printPostOrderRec(TreeNode root) {
		if (root == null) {
			return;
		}
		printPostOrderRec(root.left);
		printPostOrderRec(root.right);
		System.out.print(root.data + " ");
	}

	private static void printPostOrderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			TreeNode top = stack.peek();
			if (top.left == null && top.right == null) {
				System.out.print(top.data + " ");
				top = stack.pop();
			}
			if (top.left != null) {
				stack.push(top.left);
				top.left = null;
			}
			else if (top.right != null) {
				stack.push(top.right);
				top.right = null;
			}

		}

	}

}
