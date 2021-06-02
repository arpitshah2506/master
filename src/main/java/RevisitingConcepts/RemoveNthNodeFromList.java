package RevisitingConcepts;

public class RemoveNthNodeFromList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        /*listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);*/
        removeNode(listNode, 1);
    }

    private static ListNode removeNode(ListNode head, int n) {
        //if (head.next == null) return null;

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        int counter = 0;
        while (fastPointer!= null && counter < n) {
            fastPointer = fastPointer.next;
            counter++;
        }

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        if (slowPointer.next != null && slowPointer.next.next != null) {
            slowPointer.next = slowPointer.next.next;
            slowPointer.next.next = null;
        } else {
            slowPointer.next = null;
        }

        while (head != null) {
            System.out.println(head);
            head = head.next;
        }

        return head;
    }
}
