package RevisitingConcepts;

import java.util.ArrayList;
import java.util.List;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next =  new ListNode(4);

        swap(node);
    }

    private static void swap(ListNode head) {
        ListNode current = head;
        int i = 0;
        ListNode next, previous = null;
        ListNode result;

        //if (head == null) return null;

        result = new ListNode(0);
        ListNode temp = result;

        while (current != null) {
            if (i % 2 != 0) {
                result.next = new ListNode(current.val);
                result = result.next;

                result.next = new ListNode(previous.val);
                result = result.next;

                next = current.next;
                current.next = previous;
                previous.next = next;
                current = previous;
            } else {
                previous = current;
                if (current.next == null) {
                    result.next = new ListNode(current.val);
                    //result = result.next;
                }
            }
            current = current.next;
            i = i + 1;
        }

        //return temp.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
