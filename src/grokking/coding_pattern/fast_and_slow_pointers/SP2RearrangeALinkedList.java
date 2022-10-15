package grokking.coding_pattern.fast_and_slow_pointers;

import grokking.coding_pattern.ListNode;

public class SP2RearrangeALinkedList {

    /*
    Time  - O(n)
    Space - O(1)
     */
    public static void reorder(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode first = head, slow = head;
        while(first != null && first.next != null){
            slow = slow.next;
            first = first.next.next;
        }

        ListNode headSecondHalf = reverse(slow);
        ListNode headFirstHalf = head;

        while(headSecondHalf != null && headFirstHalf != null){
            ListNode temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }
        if (headFirstHalf != null)
            headFirstHalf.next = null;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
