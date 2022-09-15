package code_trust.data_structures.linkedlist.challenge;

import code_trust.data_structures.linkedlist.SinglyLinkedList;

public class Challenge7_FindMiddleNode {
    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node slow = list.headNode;
        SinglyLinkedList<T>.Node fast = list.headNode;

        while(slow != null && fast.nextNode != null && fast.nextNode.nextNode != null){
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }

        return slow.data;
    }
}
