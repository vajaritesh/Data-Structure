package com.academy.binarytree.examples;

import com.academy.binarytree.examples.ConstructTreeInOrderPreOrder.TreeNode;

/*
 * Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructTreeInOrderPostOrder {

	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] postorder = { 4, 5, 2, 6, 7, 8, 3, 1 };
		TreeNode root = constructTreeFromInOrderPostOrder(inorder, postorder);
		printInOrder(root);
	}

	private static TreeNode constructTreeFromInOrderPostOrder(int[] inorder, int[] postorder) {
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int postEnd = postorder.length - 1;
		return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}

	private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;

		int rootValue = postorder[postEnd];
		TreeNode root = new TreeNode(rootValue);

		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}

		root.left = buildTree(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1));
		root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k - inStart, postEnd - 1);

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
