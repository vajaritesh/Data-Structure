package com.academy.app.linkedlist.homework;

/*
 * Given a linked list, split it in two such that every other node goes into new list.
 * input  = a-b-c-d-e-f-g
 * output = a-c-e-g and b-d-f 
 */
public class AlternativeNodeSplit {
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

		alternativeSplit(head);

	}

	static void alternativeSplit(LinkListNode pList) {
		LinkListNode oddHead = new LinkListNode(-1);
		LinkListNode evenHead = new LinkListNode(-1);
		LinkListNode oddStart = oddHead;
		LinkListNode evenStart = evenHead;
		LinkListNode start = pList;
		while (start != null) {
			oddStart.next = new LinkListNode(start.data);
			oddStart = oddStart.next;
			start = start.next;
			if (start != null) {
				evenStart.next = new LinkListNode(start.data);
				evenStart = evenStart.next;
				start = start.next;
			}
		}
		if (oddHead.next != null) {
			printResultList(oddHead.next);
		}
		if (evenHead.next != null) {
			printResultList(evenHead.next);
		}
	}

	static void printResultList(LinkListNode list) {
		LinkListNode start = list;
		while (start != null) {
			System.out.print(start.data);
			start = start.next;
			if (start != null) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

}
