import java.util.Arrays;

public class RotateRight {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        /*head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);*/
        /*head.next.next.next.next.next = new ListNode(6);*/

        //ListNode node = rotateRight(head, 1);
        System.out.println(rotateRight(head, 3).traverse());
    }

    private static ListNode rotateRight(ListNode head, int k) {
        //find the total no. of nodes
        //run through the entire nodes
        //join two parts - one : 0 to total nodes - k the second : all the remaining nodes
        //merge it
        //1->2->3
        //1->2->3->4
        if (head == null) return null;
        if (head.next == null) return head;
        if (head.next.next == null) {
            if (k % 2 == 0) return head;
            else {
                ListNode temp = head.next;
                temp.next = head;
                temp.next.next = null;
                return temp;
            }
        }

        ListNode fastPointer = head;
        int count = 1;
        int totalNodes;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            count += 1;
        }

        totalNodes = count * 2;

        if (fastPointer.next == null) {
            totalNodes = count * 2 - 1;
        }

        int[] digits = new int[3];
        digits[0] = 1;
        Arrays.copyOf(digits, digits.length);

        if (k > totalNodes) k = k % totalNodes;
        if (k == 0 || k == totalNodes) return head;

        ListNode headTraversal = head;
        ListNode temp = new ListNode(head.val);
        ListNode part2 = temp;
        for (int i = 0; i < totalNodes - k - 1; i++) {
            headTraversal = headTraversal.next;
            temp.next = new ListNode(headTraversal.val);
            temp = temp.next;
        }

        ListNode temp2 = new ListNode(headTraversal.next.val);
        headTraversal = headTraversal.next;
        ListNode part1 = temp2;
        while (headTraversal.next != null) {
            headTraversal = headTraversal.next;
            temp2.next = new ListNode(headTraversal.val);
            temp2 = temp2.next;
        }

        temp2.next = part2;

        return part1;
    }
}
