package RevisitingConcepts;

public class LinkedListLoopDetectionAlgo {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        //node.next.next.next.next = node.next.next;

        System.out.println(loopDetection(node));
    }

    private static ListNode loopDetection(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                break;
            }
        }

        if (slowPointer == null || fastPointer == null || fastPointer.next == null) {
            return null;
        }

        ListNode node = head;

        while (node != slowPointer) {
            node = node.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer;
    }
}
