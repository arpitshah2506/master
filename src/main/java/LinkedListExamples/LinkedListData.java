package LinkedListExamples;

import java.util.Objects;

public class LinkedListData {

	LinkedListNode head, tail;

	class LinkedListNode {
		private LinkedListNode previous;
		private Integer value;
		private LinkedListNode next;

		public LinkedListNode(Integer nodeVal) {
			this.value = nodeVal;
		}
	}

	public void add(Integer nodeVal) {
		LinkedListNode node = new LinkedListNode(nodeVal);
		if (Objects.isNull(head)) {
			head = tail = node;
		} else {
			tail.next = node;
			node.previous = tail;
			tail = node;
		}
	}
	
	public void displayNodes() {
		LinkedListNode currentNode = head;
		while(Objects.nonNull(currentNode)) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}

	public void removeDups() {
		LinkedListNode currentNode = head;
		while(Objects.nonNull(currentNode)) {
			LinkedListNode nodeToTraverse = currentNode.next;
			while (Objects.nonNull(nodeToTraverse)) {
				if (nodeToTraverse.value == currentNode.value) {
					nodeToTraverse.next.previous = currentNode.next;
					nodeToTraverse.next = currentNode.next.next;
				}
			}
		}
	}
	
	public void kthElement(int positionFromEnd) {
		int counter = 0;
		LinkedListNode currentNode = head;
		LinkedListNode slowPointer = head;
		
		for (int index = 0; index <positionFromEnd; index++) {
			currentNode = currentNode.next;
		}
		
		while (Objects.nonNull(currentNode)) {
			currentNode = currentNode.next;
			slowPointer = slowPointer.next;
		}
		
		System.out.println("*****Print Kth Element Begin*****");
		System.out.println(slowPointer.value);
		System.out.println("*****Print Kth Element End*****");
	}
}
