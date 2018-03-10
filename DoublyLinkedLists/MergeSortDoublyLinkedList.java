package com.academy.app.doublylinkedlist;

/*
 * Merge Sort on Doubly LinkedList
 * Input = 15-10-5-20-3-2
 * Output = 2-3-5-10-215-20
 */
public class MergeSortDoublyLinkedList {
	static class LinkListNode {
		int data;
		LinkListNode next;
		LinkListNode prev;

		LinkListNode(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public static void main(String[] args) {
		LinkListNode head = new LinkListNode(15);
		head.next = new LinkListNode(10);
		head.next.next = new LinkListNode(5);
		head.next.next.next = new LinkListNode(20);
		head.next.next.next.next = new LinkListNode(3);
		head.next.next.next.next.next = new LinkListNode(2);

		// print(head);
		LinkListNode newHead = mergeLinkedList(head);
		print(newHead);
	}

	private static LinkListNode mergeLinkedList(LinkListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkListNode middle = getMiddle(head);

		LinkListNode first = mergeLinkedList(head);
		LinkListNode second = mergeLinkedList(middle);
		LinkListNode sortedList = merge(first, second);
		return sortedList;
	}

	private static LinkListNode merge(LinkListNode first, LinkListNode second) {
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}
		if (first.data < second.data) {
			first.next = merge(first.next, second);
			first.next.prev = first;
			first.prev = null;
			return first;
		}
		else {
			second.next = merge(first, second.next);
			second.next.prev = second;
			second.prev = null;
			return second;
		}
	}

	private static LinkListNode getMiddle(LinkListNode head) {
		LinkListNode slow = head;
		LinkListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		LinkListNode temp = slow.next;
		slow.next = null;
		return temp;
	}

	static void print(LinkListNode head) {
		LinkListNode start = head;
		LinkListNode backPointer = head;
		System.out.println("Forward list");
		while (start != null) {
			System.out.print(start.data + " ");
			backPointer = start;
			start = start.next;
		}
		System.out.println();
		System.out.println("Backword list");

		while (backPointer != null) {
			System.out.print(backPointer.data + " ");
			backPointer = backPointer.prev;
		}
	}

}
