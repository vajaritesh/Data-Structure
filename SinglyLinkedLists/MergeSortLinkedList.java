package com.academy.app.linkedlist.homework;

/*
 * Merge Sort on Single LinkedList
 * Input = 15-10-5-20-3-2
 * Output = 2-3-5-10-215-20
 */
public class MergeSortLinkedList {
	static class LinkListNode {
		int data;
		LinkListNode next;

		LinkListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		LinkListNode head = new LinkListNode(15);
		head.next = new LinkListNode(10);
		head.next.next = new LinkListNode(5);
		head.next.next.next = new LinkListNode(20);
		head.next.next.next.next = new LinkListNode(3);
		head.next.next.next.next.next = new LinkListNode(2);

		print(head);
		LinkListNode newHead = mergeLinkedList(head);
		print(newHead);
	}

	private static LinkListNode mergeLinkedList(LinkListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkListNode middle = getMiddle(head);
		// LinkListNode nextFromMiddle = middle.next;
		// middle.next = null;

		LinkListNode left = mergeLinkedList(head);
		LinkListNode right = mergeLinkedList(middle);

		LinkListNode sortedList = merge(left, right);
		return sortedList;
	}

	private static LinkListNode merge(LinkListNode left, LinkListNode right) {
		LinkListNode result = null;
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		if (left.data < right.data) {
			result = left;
			result.next = merge(left.next, right);
		}
		else {
			result = right;
			result.next = merge(right.next, left);
		}
		return result;
	}

	private static LinkListNode getMiddle(LinkListNode head) {
		if (head == null) {
			return head;
		}
		LinkListNode slow = head;
		LinkListNode fast = head.next;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		LinkListNode temp = slow.next;
		slow.next = null;
		return temp;
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
