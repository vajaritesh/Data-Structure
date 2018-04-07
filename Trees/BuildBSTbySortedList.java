package com.academy.binarytree.examples;

/*
 * Convert Sorted List to Binary Search Tree 
 */
public class BuildBSTbySortedList {

	static class LinkListNode {
		int data;
		LinkListNode next;

		LinkListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}

	static LinkListNode h;

	public static void main(String[] args) {
		LinkListNode head = new LinkListNode(1);
		LinkListNode first = new LinkListNode(2);
		LinkListNode second = new LinkListNode(3);
		LinkListNode third = new LinkListNode(4);
		// LinkListNode fourth = new LinkListNode(5);
		// LinkListNode fifth = new LinkListNode(6);
		head.next = first;
		first.next = second;
		second.next = third;
		// third.next = fourth;
		// fourth.next = fifth;
		TreeNode root = buildListToBST(head);
		print(root);
	}

	private static TreeNode buildListToBST(LinkListNode head) {
		if (head == null) {
			return null;
		}
		h = head;
		int len = listSize(h);
		return helper(0, len - 1);
	}

	private static TreeNode helper(int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode left = helper(start, mid - 1);
		TreeNode root = new TreeNode(h.data);
		root.left = left;
		h = h.next;
		root.right = helper(mid + 1, end);
		return root;
	}

	private static int listSize(LinkListNode head) {
		LinkListNode start = head;
		int len = 0;
		while (start != null) {
			len++;
			start = start.next;
		}
		return len;
	}

	private static void print(TreeNode root) {
		if (root == null) {
			return;
		}
		print(root.left);
		System.out.print(root.val + " ");
		print(root.right);
	}

}
