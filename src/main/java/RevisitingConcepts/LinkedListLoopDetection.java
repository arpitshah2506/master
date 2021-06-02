package RevisitingConcepts;

public class LinkedListLoopDetection {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        /*node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = new ListNode(-1);
        node.next.next.next.next.next = new ListNode(-2);
        node.next.next.next.next.next.next = new ListNode(-3);
        node.next.next.next.next.next.next.next = node.next;*/
        //node.next.next.next.next = new ListNode(-5);

        ListNode slowPointer = node;
        ListNode fastPointer = node;

        boolean isCycleExist = false;

        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                isCycleExist = true;
                break;
            }
        }

        if (isCycleExist) {
            while (slowPointer != fastPointer) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        } else {
            System.out.println();
        }
        System.out.println(slowPointer.next.val);
    }
}
