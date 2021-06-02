public class MiddleNode {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        /*node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);*/

        middleNode(node);
        System.out.println(removeNthNodeFromEnd(node, 1).traverse());

    }

    private static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        for (int i = 0; i <= n; i++) {
            fastPointer = fastPointer.next;
        }

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        slowPointer.next = slowPointer.next.next;

        return head;
    }

    private static void middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        //System.out.println(slowPointer);
    }
}
