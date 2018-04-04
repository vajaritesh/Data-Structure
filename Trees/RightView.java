package com.academy.binarytree.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Binary Tree Right Side View
 */
public class RightView {

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
		root.right.left = new TreeNode(6);
		List<Integer> result = rightViewIterative(root);
		System.out.println(result);
		List<Integer> list = new ArrayList<Integer>();
		rightViewRec(root, list, 0);
		System.out.println(list);
	}

	private static List<Integer> rightViewIterative(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		queue.add(root);

		while (queue.size() > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode top = queue.poll();
				if (i == 0) {
					result.add(top.val);
				}

				if (top.right != null) {
					queue.add(top.right);
				}
				if (top.left != null) {
					queue.add(top.left);
				}
			}

		}
		return result;
	}

	private static void rightViewRec(TreeNode root, List<Integer> list, int depth) {
		if (root == null) {
			return;
		}
		if (list.size() == depth) {
			list.add(root.val);
		}
		rightViewRec(root.right, list, depth + 1);
		rightViewRec(root.left, list, depth + 1);
	}
}
