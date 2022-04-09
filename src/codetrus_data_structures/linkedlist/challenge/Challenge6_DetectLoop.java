package codetrus_data_structures.linkedlist.challenge;

import codetrus_data_structures.linkedlist.SinglyLinkedList;

public class Challenge6_DetectLoop {

    //Detects loop in the given linked list
    //Using Floyd's Cycle Detection algorithm
    public static <T> boolean detectLoopO(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node slow = list.headNode;
        SinglyLinkedList<T>.Node fast = list.headNode;

        while(slow != null && fast != null && fast.nextNode != null){
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;

            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    //Detects loop in the given linked list
    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {

        SinglyLinkedList<T> trackList = new SinglyLinkedList();

        SinglyLinkedList<T>.Node temp = list.headNode;

        SinglyLinkedList<T>.Node curr = trackList.headNode;

        while(temp != null){
            trackList.insertAtHead(temp.data);

            while(curr != null) {
                if(curr.data.equals(temp.data)){
                    return true;
                }
                curr = curr.nextNode;
            }

            curr = trackList.headNode;
            temp = temp.nextNode;
        }
        return false;
    }
}
