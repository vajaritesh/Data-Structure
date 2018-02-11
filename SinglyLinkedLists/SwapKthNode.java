package com.academy.app.linkedlist.homework;

/*
 * Swap Kth Nodes in Given LinkedList
 * input  = 1-2-3-4-7-0 	k=2
 * output = 1-7-3-4-2-0
 */
public class SwapKthNode {
	static class LinkListNode {
		int data;
		LinkListNode next;

		LinkListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		LinkListNode head = new LinkListNode(1);
		head.next = new LinkListNode(2);
		head.next.next = new LinkListNode(3);
		head.next.next.next = new LinkListNode(4);
		head.next.next.next.next = new LinkListNode(7);
		head.next.next.next.next.next = new LinkListNode(0);
		int k = 2;
		print(head);
		LinkListNode newHead = swapKthNode(head, k);
		print(newHead);
	}

	private static LinkListNode swapKthNode(LinkListNode head, int k) {
		int size = getLinkListSize(head);

		LinkListNode leftPrev = null;
		LinkListNode left = head;
		for (int i = 1; i < k; i++) {
			leftPrev = left;
			left = left.next;
		}

		LinkListNode rightPrev = null;
		LinkListNode right = head;
		for (int i = 1; i < size - k + 1; i++) {
			rightPrev = right;
			right = right.next;
		}

		if (leftPrev != null) {
			leftPrev.next = right;
		}
		if (rightPrev != null) {
			rightPrev.next = left;
		}

		LinkListNode temp = left.next;
		left.next = right.next;
		right.next = temp;

		if (k == 1) {
			head = right;
		}
		if (k == size) {
			head = left;
		}
		return head;
	}

	static int getLinkListSize(LinkListNode head) {
		int size = 0;
		LinkListNode start = head;
		while (start != null) {
			start = start.next;
			size++;
		}
		return size;
	}

	static void print(LinkListNode head) {
		LinkListNode start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
		System.out.println();
	}

}
