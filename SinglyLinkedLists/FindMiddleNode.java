package com.academy.app.linkedlist.homework;

/*
 * Find Middle Element from linklist
 * input = 1-2-3-4-5 output = 3
 * input = 1-2-3-4 output = 2
 */
public class FindMiddleNode {
	static class LinkedListNode {
		int data;
		LinkedListNode next;

		LinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		LinkedListNode list = new LinkedListNode(1);
		list.next = new LinkedListNode(2);
		list.next.next = new LinkedListNode(3);
		list.next.next.next = new LinkedListNode(4);
		list.next.next.next.next = new LinkedListNode(5);
		LinkedListNode list1 = init();
		int middle = findMiddle(list);
		print(list1);
		System.out.println(middle);
	}

	private static void print(LinkedListNode list1) {
		LinkedListNode start = list1;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
		System.out.println();
	}

	private static LinkedListNode init() {
		LinkedListNode parent = new LinkedListNode(-1);
		for (int i = 1; i < 5; i++) {
			LinkedListNode temp = new LinkedListNode(i);
			temp.next = parent;
			parent = temp;
		}
		parent = reverse(parent);
		return parent.next;

	}

	private static LinkedListNode reverse(LinkedListNode parent) {
		LinkedListNode curr = parent;
		LinkedListNode next = null;
		LinkedListNode prev = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static int findMiddle(LinkedListNode list) {
		LinkedListNode slow = list;
		LinkedListNode fast = list;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

}
