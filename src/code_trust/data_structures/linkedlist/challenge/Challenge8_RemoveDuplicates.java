package code_trust.data_structures.linkedlist.challenge;

import code_trust.data_structures.linkedlist.SinglyLinkedList;

public class Challenge8_RemoveDuplicates {
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {

        SinglyLinkedList<T>.Node current = list.headNode;
        SinglyLinkedList<T>.Node compare = null;

        while (current != null && current.nextNode != null){

            compare = current;
            while(compare.nextNode != null){
                if (current.data.equals(compare.nextNode.data)){
                    compare.nextNode = compare.nextNode.nextNode;
                }else{
                    compare = compare.nextNode;
                }
            }
            current = current.nextNode;
        }
    }
    public static void main( String args[] ) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for(int i = 0; i < 9; i++)
            list.insertAtEnd(i);
        list.insertAtEnd(0);
        list.insertAtEnd(1);
        System.out.print("Before ");
        list.printList();
        removeDuplicates(list);
        System.out.print("After ");
        list.printList();

    }

}
