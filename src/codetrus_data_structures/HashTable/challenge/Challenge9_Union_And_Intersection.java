package codetrus_data_structures.HashTable.challenge;

import codetrus_data_structures.linkedlist.SinglyLinkedList;

import java.util.HashSet;

public class Challenge9_Union_And_Intersection {
    //performs intersection between list
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        SinglyLinkedList<T>.Node first = list1.headNode;
        SinglyLinkedList<T>.Node second = list2.headNode;
        HashSet<T> set = new HashSet<>();

        while (first != null || second != null){
            if(first != null){
                set.add(first.data);
                first = first.nextNode;
            }else if(!set.contains(second.data)) {
                set.add(second.data);
                second = second.nextNode;
            }
        }
        set.forEach(result::insertAtHead);
        return result;
    }

    public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        HashSet<T> set = new HashSet<>();

        SinglyLinkedList<T>.Node current = list1.headNode;
        while(current != null){
            if (!set.contains(current.data)){
                set.add(current.data);
            }
            current = current.nextNode;
        }
        current = list2.headNode;
        while(current != null){
            if (set.contains(current.data)){
                result.insertAtHead(current.data);
                set.remove(current);
            }
            current = current.nextNode;
        }
        return result;
    }

}
