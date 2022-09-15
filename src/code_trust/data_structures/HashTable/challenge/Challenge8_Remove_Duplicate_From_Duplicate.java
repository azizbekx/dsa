package code_trust.data_structures.HashTable.challenge;

import code_trust.data_structures.linkedlist.SinglyLinkedList;

import java.util.HashSet;

public class Challenge8_Remove_Duplicate_From_Duplicate {
    public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        SinglyLinkedList<V>.Node first = list.headNode;
        HashSet<V> set = new HashSet<>();
        set.add(first.data);
        while(first.nextNode != null){
            if(set.contains(first.nextNode.data)){
                first.nextNode = first.nextNode.nextNode;
            }else{
                set.add(first.nextNode.data);
                first = first.nextNode;
            }
        }
    }
    //Optimal Solution of Problem
    public static <V> void removeDuplicatesWithHashingO(SinglyLinkedList<V> list) {
        SinglyLinkedList<V>.Node current = list.headNode;
        SinglyLinkedList<V>.Node prevNode = list.headNode;
        //will store all the elements that we observe once
        HashSet<V> visitedNodes = new HashSet<V>();

        if (!list.isEmpty() && current.nextNode != null) {
            while (current != null) {
                //check if already visited then delete this node
                if (visitedNodes.contains(current.data)) {
                    //deleting the node by undating the pointer of previous node
                    prevNode.nextNode = current.nextNode;
                    current = current.nextNode;
                } else {
                    //if node was not already visited then add it to the visited set
                    visitedNodes.add(current.data);
                    //moving on to next element in the list
                    prevNode = current;
                    current = current.nextNode;
                }
            }
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); // created linked list

        for(int i = 1; i <= 8; i++) {
            list.insertAtHead(i);      // inserting data in list
        }
        //inserting duplicates
        list.insertAtHead(2);
        list.insertAtHead(4);
        list.insertAtHead(1);

        System.out.println("List before deleting duplicates from list :");
        list.printList();
        removeDuplicatesWithHashing(list); // calling removeDuplicatesWithHashing function
        System.out.println("List after deleting duplicates from list :");
        list.printList();
    }
}
