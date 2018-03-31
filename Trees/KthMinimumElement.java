package com.academy.binarytree.examples;

import java.util.Stack;

/*
 * Kth Minimum Element
 */
public class KthMinimumElement {
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
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(2);
		int k = 2;
		int ans = findKMinElement(root, k);
		System.out.println(ans);
	}

	public static int findKMinElement(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
		int i = 0;
		while (!stack.isEmpty()) {
			TreeNode t = stack.pop();
			i++;

			if (i == k)
				return t.val;

			TreeNode r = t.right;
			while (r != null) {
				stack.push(r);
				r = r.left;
			}

		}

		return -1;
	}
}
