import java.util.HashSet;

public class HasCycle {
    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        node.next = new ListNode(20);
        node.next.next = new ListNode(30);
        node.next.next.next = new ListNode(40);
        node.next.next.next.next = node.next;

        HashSet<ListNode> set = new HashSet<>();
        while (node != null)
        {
            if (set.add(node) == false)
            {
                //return true;
            }
            node = node.next;
        }
    }
}
