package com.academy.binarytree.examples;

/*
 * Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructTreeInOrderPreOrder {

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
		int[] inorder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] preorder = { 1, 2, 4, 5, 3, 7, 6, 8 };
		TreeNode root = constructTreeFromInOrderPreOrder(inorder, preorder);
		printInOrder(root);
	}

	private static TreeNode constructTreeFromInOrderPreOrder(int[] inorder, int[] preorder) {
		int instart = 0;
		int inend = inorder.length - 1;
		int prestart = 0;
		int preend = preorder.length - 1;
		return helper(inorder, preorder, instart, inend, prestart, preend);
	}

	private static TreeNode helper(int[] inorder, int[] preorder, int instart, int inend, int prestart, int preend) {
		if (instart > inend || prestart > preend) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[prestart]);
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[prestart]) {
				k = i;
				break;
			}
		}
		root.left = helper(inorder, preorder, instart, k - 1, prestart + 1, prestart + (k - instart));
		root.right = helper(inorder, preorder, k + 1, inend, prestart + (k - instart) + 1, preend);
		return root;
	}

	private static void printInOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.val + " ");
		printInOrder(root.right);
	}

}
