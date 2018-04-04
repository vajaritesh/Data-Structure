package com.academy.binarytree.examples;


//Build Balanced BST from Sorted array
public class BuildBSTbySortedArray {
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
		int[] arr = { 9, 13, 16, 18, 20, 25, 27, 30 };
		TreeNode root = buildBalanceBST(arr, 0, arr.length - 1);
		printInOrderBST(root);
	}

	private static void printInOrderBST(TreeNode root) {
		if (root == null) {
			return;
		}
		printInOrderBST(root.left);
		System.out.print(root.data + " ");
		printInOrderBST(root.right);

	}

	private static TreeNode buildBalanceBST(int[] arr, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = buildBalanceBST(arr, left, mid - 1);
		root.right = buildBalanceBST(arr, mid + 1, right);
		return root;
	}

}
