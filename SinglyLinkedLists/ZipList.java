package com.academy.app.linkedlist.homework;

/*
 * Zip given linklist from end
 * input = 1-2-3-4-5-6
 * output = 1-6-2-5-3-4
 */
public class ZipList {
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
		head.next.next.next.next = new LinkListNode(5);
		head.next.next.next.next.next = new LinkListNode(6);

		print(head);
		LinkListNode newHead = zipList(head);
		print(newHead);
	}

	private static LinkListNode zipList(LinkListNode head) {
		int size = getLinkListSize(head);
		LinkListNode returnHead = head;
		LinkListNode startHead = head;
		LinkListNode start = head;
		for (int i = 0; i < size / 2; i++) {
			start = start.next;
		}
		LinkListNode reverseHead = start;
		LinkListNode prev = null;
		LinkListNode next;

		while (start != null) {
			next = start.next;
			start.next = prev;
			prev = start;
			start = next;
		}
		reverseHead = prev;

		LinkListNode startTemp;
		LinkListNode reverseTemp;
		while (reverseHead != null) {
			startTemp = startHead.next;
			reverseTemp = reverseHead.next;

			startHead.next = reverseHead;
			reverseHead.next = startTemp;

			startHead = startTemp;
			reverseHead = reverseTemp;
		}
		if (size % 2 == 0) {
			startHead.next = reverseHead;
		}
		return returnHead;
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
