package grokking.coding_pattern.in_place_reverse;

import grokking.coding_pattern.ListNode;

public class ReverseAlternatingKSublist {
    /*
    Time - O(N) N - number of nodes
    Space - O(1)
     */
    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null) return null;

        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode first = prev;
            ListNode last = curr;
            ListNode next = null;

            for (int i = 0; curr != null && i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if (first != null)
                first.next = prev;
            else head = prev;

            last.next = curr;

            for (int i = 0; curr != null && i < k; ++i) {
                prev = curr;
                curr = curr.next;
            }
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

        ListNode result = reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
