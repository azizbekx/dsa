package code_trust.data_structures.linkedlist.challenge;

import code_trust.data_structures.linkedlist.SinglyLinkedList;

public class Challenge10_nthNodeFromEnd {
    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        if(list.isEmpty()){
            return null;
        }
        int size = list.size;
        n = size - n + 1;
        SinglyLinkedList<T>.Node current = list.headNode;
        int count = 1;
        while(current != null){
            if (count == n){
                return current.data;
            }
            count++;
            current = current.nextNode;
        }
        return null;
    }
}
