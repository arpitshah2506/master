public class LinkedListHasCycle {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(1);
        node.next.next = new ListNode(8);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = node.next;

        //System.out.println(hasCycle(node));
        System.out.println(getIntersectionNode(node, node2));
        System.out.println(getIntesectingNodeMine(node, node2));
    }

    private static boolean hasCycle(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;

        while (ptr2 != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;

            if (ptr1 == ptr2) {
                return true;
            }
        }

        return false;
    }

    private static ListNode getIntesectingNodeMine(ListNode headA, ListNode headB) {
        int nodesInListA = 0;
        int nodesInListB = 0;

        ListNode dummyListA = headA;
        ListNode dummyListB = headB;

        while (dummyListA != null) {
            nodesInListA++;
            dummyListA = dummyListA.next;
        }

        while (dummyListB != null) {
            nodesInListB++;
            dummyListB = dummyListB.next;
        }

        if (nodesInListA > nodesInListB) {
            while (nodesInListA != nodesInListB) {
                headA = headA.next;
                nodesInListA--;
            }
        }

        if (nodesInListB > nodesInListA) {
            while (nodesInListA != nodesInListB) {
                headB = headB.next;
                nodesInListB--;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
