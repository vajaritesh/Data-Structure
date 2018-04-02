package com.academy.binarytree.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Level Order Traversal
 */
public class LevelOrderTravel {
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
		List<List<Integer>> result = printLevelOrder(root);
		print(result);
	}

	private static void print(List<List<Integer>> result) {
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

	private static List<List<Integer>> printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			int level = queue.size();
			List<Integer> tempList = new ArrayList<Integer>();
			for (int i = 0; i < level; i++) {
				TreeNode top = queue.poll();
				tempList.add(top.data);

				if (top.left != null) {
					queue.add(top.left);
				}
				if (top.right != null) {
					queue.add(top.right);
				}
				System.out.print(top.data + " ");
			}
			System.out.println();
			result.add(0, tempList);
		}
		return result;
	}
}
