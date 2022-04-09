package codetrus_data_structures.stack_and_queue.challenge;

import codetrus_data_structures.stack_and_queue.QueueImpl;
import codetrus_data_structures.stack_and_queue.StackImpl;

public class Challenge3_Reverse {
    public static <V> void reverseK(QueueImpl<Integer> queue, int k) {
        StackImpl<Integer> stack  = new StackImpl<>(queue.getMaxSize());
        for(int i=0; i<k; i++){
            int temp = queue.dequeue();
            stack.push(temp);
        }
        for(int i=0; i<k; i++){
            queue.enqueue(stack.pop());
        }
    }


}
