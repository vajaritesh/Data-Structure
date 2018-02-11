package com.academy.app.linkedlist.homework;

/*
 * Reverse Given LinkList in Group of K
 * input = 1-2-3-4-5-6 			k=3
 * output = 3-2-1-6-5-4
 * input  = 1-2-3-4-5-6-7-8		k=3
 * output = 3-2-1-6-5-4-8-7
 */
public class ReverseInGroup {
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
		head.next.next.next.next.next.next = new LinkListNode(7);
		head.next.next.next.next.next.next.next = new LinkListNode(8);
		int k = 3;
		print(head);
		LinkListNode newHead = reverseInGroup(head, k);
		print(newHead);
	}

	private static LinkListNode reverseInGroup(LinkListNode head, int k) {
		LinkListNode current = head;
		LinkListNode next = null;
		LinkListNode prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list starting from current. And make rest of
		 * the list as next of first node
		 */
		if (next != null)
			head.next = reverseInGroup(next, k);

		// prev is now head of input list
		return prev;
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
