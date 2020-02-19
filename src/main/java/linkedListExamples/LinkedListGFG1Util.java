package linkedListExamples;

import java.util.Stack;

public class LinkedListGFG1Util {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(6);
        linkedList.add(8);
        //linkedList.add(10);
        linkedList.add(8);
        linkedList.add(4);
        linkedList.add(2);

        System.out.println("traversing elements");
        linkedList.traverse();

        System.out.println("\ndelete element 6");
        linkedList.deleteNode(6);

        System.out.println("traverse after deletion");
        linkedList.traverse();

        System.out.println("\nlength of linked list");
        linkedList.getLength();

        System.out.println("\nSearching element of linked list 8");
        linkedList.search(8);

        System.out.println("\nPrinting the middle element");
        linkedList.middle();

        System.out.println("\nDetecting loop");
        //linkedList.tail.nextNode = linkedList.head;

        System.out.println("\nChecking for pelindrome list");
        System.out.println(linkedList.checkForPelindromeListUsingStack());

        System.out.println("\nDetecting duplicates");
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(10);
        linkedList2.add(20);
        linkedList2.add(30);
        linkedList2.add(40);

        linkedList2.removeDups();
    }
}

class LinkedList {
    NodeGFG1 head;
    NodeGFG1 tail;

    public void add(int value) {
        if (head == null) {
            head = tail = new NodeGFG1(value);
        } else {
            NodeGFG1 nodeGFG1 = new NodeGFG1(value);
            tail.nextNode = nodeGFG1;
            tail = nodeGFG1;
        }
    }

    public void traverse() {
        NodeGFG1 node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.nextNode;
        }
    }

    public void deleteNode(int value) {
        NodeGFG1 node = head;

        //head contains value
        if (node.value == value) {
            head = node.nextNode;
            return;
        }

        while (node != null) {
            if (node.nextNode.value == value) {
                if (node.nextNode.nextNode != null) { //tail deletion
                    node.nextNode = node.nextNode.nextNode;
                } else {
                    node.nextNode = null;
                }
                break;
            }
            node = node.nextNode;
        }
    }

    public void getLength() {
        NodeGFG1 node = head;
        int length = 0;
        while (node != null) {
            length = length + 1;
            node = node.nextNode;
        }
        System.out.println(length);
    }

    public void search(int value) {
        NodeGFG1 node = head;
        int index = 0;
        while (node != null) {
            index = index + 1;
            if (node.value == value) {
                System.out.println(index);
                break;
            }
            node = node.nextNode;
        }
    }

    public NodeGFG1 middle() {
        NodeGFG1 slowPointer = head;
        NodeGFG1 fastPointer = head;

        while (fastPointer != null && fastPointer.nextNode != null) {
            fastPointer = fastPointer.nextNode.nextNode;
            slowPointer = slowPointer.nextNode;
        }
        System.out.println(slowPointer.value);
        return slowPointer;
    }

    public int detectLoop() {
        NodeGFG1 slowPointer = head, fastPointer = head;
        while (slowPointer != null && fastPointer != null && fastPointer.nextNode != null) {
            System.out.println(slowPointer.value + " " + fastPointer.value);
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
            if (slowPointer == fastPointer) {
                System.out.println("Found loop");
                return 1;
            }
        }
        return 0;
    }

    public boolean checkForPelindromeListUsingStack() {
        Stack<NodeGFG1> stack = new Stack<>();
        boolean isPelindromeList = true;
        NodeGFG1 slowPointer = head, fastPointer = head;
        while (fastPointer != null && fastPointer.nextNode != null) {
            stack.push(slowPointer);
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
        }

        if (fastPointer != null) {
            slowPointer = slowPointer.nextNode;
        }

        while (slowPointer != null) {
            if ((slowPointer.value == stack.pop().value) == false) {
                isPelindromeList = false;
                break;
            }
            slowPointer = slowPointer.nextNode;
        }
        return isPelindromeList;
    }

    public void removeDups() {
        this.traverse();
        NodeGFG1 node = head;
        while (node != null && node.nextNode != null) {
            if (node.nextNode.value == node.value) {
                System.out.println("\nFound duplicate\n");
                break;
            }
            node = node.nextNode;
        }
    }

    class NodeGFG1 {
        NodeGFG1 nextNode;
        int value;

        NodeGFG1(int value) {
            this.value = value;
        }

        public String toString() {
            return ""+this.value;
        }

        public int hashCode() {
            return value;
        }
    }
}