package grokking.coding_pattern.fast_and_slow_pointers;

import grokking.coding_pattern.ListNode;

public class P2StartOfLinkedList {
    /*
    Time - O(n) n-> number of nodes
    Space - O(1)
     */
    public static ListNode findCycleStart(ListNode head) {
        ListNode fast = head, slow = head;
        int cycleLen = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycleLen = findLengthOfCycle(slow);
                break;
            }
        }

        return findHeadOfCycle(head, cycleLen);
    }

    private static ListNode findHeadOfCycle(ListNode head, int cycleLen) {
        ListNode first = head;
        ListNode second = head;
        while (cycleLen-- > 0) {
            second = second.next;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    private static int findLengthOfCycle(ListNode slow) {
        ListNode current = slow;
        int cycleLen = 0;
        do {
            current = current.next;
            cycleLen++;
        } while (current != slow);
        return cycleLen;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);
    }
}
