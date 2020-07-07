public class IntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(10);
        ListNode list1node2 = new ListNode(20);
        ListNode intersectingNode = new ListNode(30);
        ListNode nodeAfterIntersection = new ListNode(40);

        ListNode headB = headA;
        ListNode list2node2 = new ListNode(20);


        headA.next = list1node2;
        list1node2.next = intersectingNode;
        intersectingNode.next = nodeAfterIntersection;

        headB.next = list2node2;
        list2node2.next = intersectingNode;

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
        //return headA;
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
