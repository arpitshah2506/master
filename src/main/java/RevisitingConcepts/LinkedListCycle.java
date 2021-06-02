package RevisitingConcepts;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = node.next;

        ListNode ptr1 = node;
        ListNode ptr2 = node;

        while (ptr1!=null && ptr2!=null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;

            if (ptr1 == ptr2) {
                System.out.println(true);
                break;
            }
        }
        System.out.println(false);
        ListNode head = node;
        while (ptr1.next != head) {
            if (ptr1.next == head.next) {
                break;
            }
        }

        System.out.println(ptr1);
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + val +
                '}';
    }

}