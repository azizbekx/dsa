package code_trust.data_structures.stack_and_queue;

public class QueueImpl<V> {
    private int maxSize;
    private V[] array;
    private int front;
    private int back;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize){
        this.maxSize = maxSize;
        array = (V[]) new Object[maxSize];
        this.front = 0;
        this.back = -1;
        this.currentSize = 0;
    }

    public int getMaxSize(){
        return maxSize;
    }
    public int getCurrentSize(){
        return currentSize;
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize == maxSize;
    }
    public V top(){
        return array[front];
    }

    public void enqueue(V value){
        if (isFull()){
            return;
        }
        back = (back + 1) % maxSize;
        array[back] = value;
        currentSize++;

    }
    public V dequeue(){
        if (isEmpty())
            return null;
        V temp = array[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return temp;
    }
}
