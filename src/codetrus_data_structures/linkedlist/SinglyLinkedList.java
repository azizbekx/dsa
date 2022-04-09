package codetrus_data_structures.linkedlist;

public class SinglyLinkedList<T> {
    //node inner class of SLL
    public class Node{
        public T data;
        public Node nextNode;
    }

    public Node headNode; //head node of SLL
    public int size; // size of SLL

    public SinglyLinkedList(){
        headNode = null;
        size = 0;
    }

    //Helper Function that checks if List is empty or not
    public boolean isEmpty(){
        return headNode == null;
    }

    //Insert new data at the start of the linked list
    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;

        //Linking head to the NewNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }
    //Helper function to print list
    public void printList(){
        if (isEmpty()){
            System.out.println("List is Empty");
            return;
        }

        Node temp = headNode;
        while (temp.nextNode != null){
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");

    }

    public void insertAtEnd(T data){
        if (isEmpty()){
            insertAtHead(data);
            return;
        }

        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node last = headNode;
        while(last.nextNode != null){
            last = last.nextNode;
        }
        last.nextNode = newNode;
        size++;
    }

    public void insertAtAfter(T data, T previous){
        //Creating a new node with value
        Node newNode = new Node();
        newNode.nextNode = null;
        newNode.data = data;
        //Start from head node
        Node currentNode = headNode;
        while(currentNode != null && !currentNode.data.equals(previous)){
            currentNode = currentNode.nextNode;
        }
        //If such a node was found
        //then point our newNode to currentNode's nextElement
        if (currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            size++;
        }

    }

    public boolean searchNode(T data){
        //Start from first element
        Node currentNode = this.headNode;

        //Traverse the list till you reach end
        while(currentNode != null){
            if (currentNode.data.equals(data))
                return true; // value found

            currentNode = currentNode.nextNode;
        }
        return false; // value not found
    }

    //Deletes data from the head of list
    public void deleteAtHead(){
        if (isEmpty()) {
            return;
        }
        headNode = headNode.nextNode;
        size--;
    }

    //Deletes data given from the linked list
    public void deleteByValue(T data){
        if (isEmpty())
            return;

        Node currentNode = this.headNode;
        Node prevNode = null; //previous node starts from null

        if (currentNode.data.equals(data)){
            deleteAtHead();
            return;
        }

        //traverse the list searching for the data to delete
        while (currentNode != null){
            if (data.equals(currentNode.data)){
                prevNode.nextNode = currentNode.nextNode;
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }

    }

    /*
    Second approach for Delete By Value
      public void deleteByValue(T data) {
      if(isEmpty()){
        return;
      }

      Node currentNode = headNode;
      if(currentNode.data.equals(data)){
        deleteAtHead();
        return;
      }

      while(currentNode.nextNode != null){
        if(currentNode.nextNode.data.equals(data)){

          currentNode.nextNode = currentNode.nextNode.nextNode;
          size--;
          return;
        }
        currentNode = currentNode.nextNode;

      }
     */
}
