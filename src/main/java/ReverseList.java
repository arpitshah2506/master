public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reverseList(head);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode next;
        ListNode prev = null;

        while (current !=null) {
            next = current.next; //placeholder
            current.next = prev; //reversing link
            prev = current; //
            current = next;

        }

        return prev;
    }
}
