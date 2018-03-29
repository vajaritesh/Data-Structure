package com.academy.binarytree.homework;

import java.util.Stack;

/*
 * Post Order Traversal without recursion
 */
public class PostOrderTravelBinaryTreeIteratively {

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
		postOrderRecursive(root);
		System.out.println();
		printPostOrder(root);

	}

	private static void printPostOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode top = stack.peek();
			if (top.left == null && top.right == null) {
				System.out.print(top.val + " ");
				stack.pop();
			}
			else if (top.left != null) {
				stack.push(top.left);
				top.left = null;
			}
			else if (top.right != null) {
				stack.push(top.right);
				top.right = null;
			}
		}
	}

	private static void postOrderRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.val + " ");
	}

}
