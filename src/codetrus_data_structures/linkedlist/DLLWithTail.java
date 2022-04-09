package codetrus_data_structures.linkedlist;

public class DLLWithTail<T> {
    public class Node{
        public T data;
        public Node nextNode;
        public Node prevNode;
    }
    //member of variables
    public Node headNode;
    public Node tailNode;
    public int size;

    //constructor
    public DLLWithTail(){
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return headNode == null && tailNode == null;
    }

    public Node getHeadNode(){
        return headNode;
    }
    public Node getTailNode(){
        return tailNode;
    }
    public int getSize(){
        return size;
    }

    //print list function
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : null <- ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }
    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        newNode.prevNode = null;

        if (!isEmpty())
            headNode.prevNode = newNode;
        else
            tailNode = newNode;
        this.headNode = newNode;
        size++;
    }

    public void insertAtEnd(T data){
        if (isEmpty()){
            insertAtHead(data);
            return;
        }

        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;
        newNode.prevNode = tailNode;
        tailNode.nextNode = newNode;
        tailNode = newNode;
        size++;
    }

    public void deleteAtHead(){
        if (isEmpty()){
            return;
        }

        headNode = headNode.nextNode;
        if (headNode == null)
            tailNode = null;
        else
            headNode.prevNode = null;
        size--;
    }
    public void deleteAtTail(){
        if (isEmpty())
            return;

        tailNode = tailNode.prevNode;
        if (tailNode == null)
            headNode = null;
        else
            tailNode.nextNode = null;
        size--;


    }

}
