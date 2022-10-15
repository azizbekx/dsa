package grokking.coding_pattern.in_place_reverse;

import grokking.coding_pattern.ListNode;

public class ReverseKGroup {
    /*
    Time - O(N)
    Space - O(1)
     */
    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;

        ListNode curr = head, prev = null;
        while (true) {
            ListNode first = prev;
            // after reversing the linked list 'current' will become the the last node of the sub-list
            ListNode last = curr;
            ListNode next = null; // will be used temporarily stored the next node
            // reverse 'k' nodes
            for (int i = 0; curr != null && i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            // connect with previous part
            if (first != null)
                first.next = prev;
            else
                head = prev;

            // connect with next part
            last.next = curr;

            if (curr == null)
                break;
            // prepare for the next sub-list
            prev = last;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
