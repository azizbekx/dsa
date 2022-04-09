package codetrus_data_structures.linkedlist.challenge;

import codetrus_data_structures.linkedlist.SinglyLinkedList;

public class Challenge9_UnionAndIntersect {
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T>.Node second = list2.headNode;

        while(second != null){
            if(!list1.searchNode(second.data)){
                list1.insertAtEnd(second.data);
            }
            second = second.nextNode;
        }
        return list1;
    }

    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        SinglyLinkedList<T>.Node second = list2.headNode;

        while (second != null){
            if(list1.searchNode(second.data)){
                result.insertAtHead(second.data);
            }
            second = second.nextNode;
        }

        return result;
    }
}
