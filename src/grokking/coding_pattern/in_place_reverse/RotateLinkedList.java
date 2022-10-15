package grokking.coding_pattern.in_place_reverse;

import grokking.coding_pattern.ListNode;

public class RotateLinkedList {
    /*
    Time - O(N) N - number of nodes
    Space - O(1)
     */
    public static ListNode rotate(ListNode head, int rotations) {
        if (head == null || head.next == null || rotations <= 0)
            return head;
        // find the length and the last node of the list
        ListNode lastNode = head;
        int len = 1;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            len++;
        }
        // connect the last node with head to make it a circular list
        lastNode.next = head;
        // no need to do rotations more than the lenght of the list
        rotations %= len;
        int skipLength = len - rotations;
        ListNode lastNodeOfRotatedList = head;
        for (int i = 0; i < skipLength - 1; i++) {
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;
        }
        // 'lastNodeOfRotatedList.next' is pointing to the sub-list of 'k' ending nodes
        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
