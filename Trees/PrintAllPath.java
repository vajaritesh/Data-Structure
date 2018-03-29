package com.academy.binarytree.homework;

import java.util.ArrayList;
import java.util.List;

/*
 * Print All Path root to left recursion
 */
public class PrintAllPath {
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

		List<Integer> tempList = new ArrayList<Integer>();
		printPath(root, tempList);
	}

	private static void printPath(TreeNode root, List<Integer> tempList) {
		if (root == null) {
			System.out.println(tempList);
			return;
		}

		tempList.add(root.val);
		printPath(root.left, tempList);
		tempList.remove(tempList.size() - 1);

		if (root.right != null) {
			tempList.add(root.val);
			printPath(root.right, tempList);
			tempList.remove(tempList.size() - 1);
		}
	}
}
