public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(mergeTwoLists(l1, l2));
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode l3Head = null;

        while (l1 != null || l2 != null) {
            if (l1 == null && l2 != null) {
                if (l3 == null) {
                    l3 = new ListNode(l2.val);
                    l3Head = l3;
                } else {
                    l3Head.next = new ListNode(l2.val);
                    l3Head = l3Head.next;
                }
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                if (l3 == null) {
                    l3 = new ListNode(l1.val);
                    l3Head = l3;
                } else {
                    l3Head.next = new ListNode(l1.val);
                    l3Head = l3Head.next;
                }
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    if (l3 == null) {
                        l3 = new ListNode(l1.val);
                        l3Head = l3;
                    } else {
                        l3Head.next = new ListNode(l1.val);
                        l3Head = l3Head.next;
                    }
                    l1 = l1.next;
                } else {
                    if (l3 == null) {
                        l3 = new ListNode(l2.val);
                        l3Head = l3;
                    } else {
                        l3Head.next = new ListNode(l2.val);
                        l3Head = l3Head.next;
                    }
                    l2 = l2.next;
                }
            }
        }

        return l3;
    }
}
