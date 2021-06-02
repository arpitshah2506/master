import java.util.Stack;

public class PelindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        /*head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);*/
        //head.next.next.next.next.next.next = new Node(1);

        if (head.next == null) {
            //return true;
        } else if (head.next.next == null && head.val == head.next.val) {
            //return true;
        }

        Stack<Integer> stack = new Stack<>();
        findMiddleNode(head, stack);
    }

    private static void findMiddleNode(ListNode head, Stack<Integer> stack) {
        ListNode middleElement = head;
        ListNode listNode = head;

        //System.out.println(node + " " + middleElement);

        int i = 0;
        stack.push(listNode.val);
        while ((middleElement == null || middleElement.next == null) == false) {
            listNode = listNode.next;
            middleElement = middleElement.next.next;

            //System.out.println(node + " middle : " + middleElement);
            stack.push(listNode.val);
            i = i + 1;
        }

        if (middleElement != null)
        {
            listNode = listNode.next;
        }

        stack.pop();
        while (listNode != null)
        {
            if (listNode.val != stack.pop())
            {
                System.out.println(false);
                break;
            }
            else
            {
                listNode = listNode.next;
            }
        }
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

    public String traverse() {
        StringBuilder builder = new StringBuilder(0);
        ListNode node = this;

        while (node != null) {
            builder.append(node.val).append("->");
            node = node.next;
        }
        return builder.toString();
    }
}