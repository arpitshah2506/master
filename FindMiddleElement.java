package LinkedListExamples;

import java.util.Objects;

public class FindMiddleElement {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(10);
        LinkedListNode node2 = new LinkedListNode(20);
        LinkedListNode node3 = new LinkedListNode(30);
        LinkedListNode node4 = new LinkedListNode(40);
        LinkedListNode node5 = new LinkedListNode(50);
        LinkedListNode node6 = new LinkedListNode(15);
        LinkedListNode node7 = new LinkedListNode(25);
        LinkedListNode node8 = new LinkedListNode(35);
        LinkedListNode node9 = new LinkedListNode(45);
        /*LinkedListNode node10 = new LinkedListNode(55);*/

        LinkedList list = new LinkedList();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        list.add(node7);
        list.add(node8);
        list.add(node9);
        /*list.add(node10);*/

        list.printLinkedList();
        list.findMiddleElement();
    }
}

class LinkedListNode {
    Integer value;
    LinkedListNode previousNode;
    LinkedListNode nextNode;

    LinkedListNode(Integer value) {
        this.value = value;
    }
}

class LinkedList {

    LinkedListNode head;
    LinkedListNode currentNode;

    public void add(LinkedListNode node) {
        if (Objects.isNull(head)) {
            head = node;
        } else {
            currentNode = head;
            while (Objects.nonNull(currentNode.nextNode)) {
                currentNode = currentNode.nextNode;
            }

            currentNode.nextNode = node;
            node.previousNode = currentNode;
        }
    }

    public void findMiddleElement() {
        LinkedListNode slowPointer = head;
        LinkedListNode rapidPointer = head;

        while(Objects.nonNull(rapidPointer.nextNode)) {
            slowPointer = slowPointer.nextNode;
            rapidPointer = rapidPointer.nextNode.nextNode;
        }
        System.out.println("\n\n"+slowPointer.value);
    }

    public void printLinkedList() {
        currentNode = head;
        if (Objects.nonNull(currentNode)) {
            while (Objects.nonNull(currentNode.nextNode)) {
                System.out.println(currentNode.value);
                currentNode = currentNode.nextNode;
            }
            System.out.println(currentNode.value);
        }
    }
}