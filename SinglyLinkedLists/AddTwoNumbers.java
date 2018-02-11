package com.academy.app.linkedlist.homework;

/*
 * Add two number represented by LinkedList (12+23=35)
 * Input = 2-1 and 3-2
 * Output = 5-3
 */
public class AddTwoNumbers {

	static class LinkedListNode {
		int data;
		LinkedListNode next;

		LinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		LinkedListNode ll1 = new LinkedListNode(2);
		ll1.next = new LinkedListNode(1);
		LinkedListNode ll2 = new LinkedListNode(3);
		ll2.next = new LinkedListNode(2);
		LinkedListNode result = addTwoNumberList(ll1, ll2);
		LinkedListNode reverse = reverseLinkedList(result);
		printLinkedList(reverse);
	}

	private static LinkedListNode addTwoNumberList(LinkedListNode ll1, LinkedListNode ll2) {
		LinkedListNode start1 = ll1;
		LinkedListNode start2 = ll2;
		LinkedListNode parent = null;
		int carry = 0;
		while (start1 != null && start2 != null) {
			int res = start1.data + start2.data + carry;

			if (res > 9) {
				carry = 1;
				res = res % 10;
			}
			else {
				carry = 0;
			}

			LinkedListNode temp = new LinkedListNode(res);
			temp.next = parent;
			parent = temp;
			start1 = start1.next;
			start2 = start2.next;
		}
		while (start1 != null) {
			int res = start1.data + carry;
			LinkedListNode temp = new LinkedListNode(res);
			if (res < 10) {
				carry = 0;
			}
			temp.next = parent;
			parent = temp;
			start1 = start1.next;
		}
		while (start2 != null) {
			int res = start2.data + carry;
			LinkedListNode temp = new LinkedListNode(res);
			if (res < 10) {
				carry = 0;
			}
			temp.next = parent;
			parent = temp;
			start2 = start2.next;
		}
		if (carry != 0) {
			LinkedListNode temp = new LinkedListNode(carry);
			temp.next = parent;
			parent = temp;
		}
		return parent;
	}

	private static LinkedListNode reverseLinkedList(LinkedListNode result) {
		LinkedListNode curr = result;
		LinkedListNode next = curr.next;
		LinkedListNode prev = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static void printLinkedList(LinkedListNode result) {
		LinkedListNode curr = result;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
}
