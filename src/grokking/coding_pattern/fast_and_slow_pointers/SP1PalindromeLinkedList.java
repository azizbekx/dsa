package grokking.coding_pattern.fast_and_slow_pointers;

import grokking.coding_pattern.ListNode;

public class SP1PalindromeLinkedList {
    /*
    Time - O(n)
    Space - O(1)
     */

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headSecondHalf = reverse(slow);
        ListNode copyOfHeadSecondHalf = headSecondHalf;

        while(head != null && headSecondHalf != null){
            if (head.value != headSecondHalf.value)
                break;
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }
        reverse(copyOfHeadSecondHalf);
        return head == null || headSecondHalf == null;

    }
    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
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
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));
    }
}
