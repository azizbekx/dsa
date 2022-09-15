package code_trust.data_structures.linkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            dll.insertAtHead(i);
        }
        System.out.print("Original ");
        dll.printList();
        System.out.print("After deleting 10 ");
        dll.deleteByValue(10);
        dll.printList();
        System.out.print("After deleting 1 ");
        dll.deleteByValue(1);
        dll.printList();
        System.out.print("After deleting 5 ");
        dll.deleteByValue(5);
        dll.printList();
    }
}
