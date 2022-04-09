package codetrus_data_structures.stack_and_queue.challenge;

import codetrus_data_structures.stack_and_queue.StackImpl;

public class Challenge4_ImplementQueueUsingStack {
    static class QueueWithStackO <V> {
        //We can use 2 stacks for this purpose, stack1 to store original values
        //and stack2 which will help in dequeue operation.
        StackImpl<V> stack1;
        StackImpl<V> stack2;

        void QueueWithStack(int maxSize){
            stack1 = new StackImpl<>(maxSize);
            stack2 = new StackImpl<>(maxSize);
        }
        public boolean isEmpty(){
            return (stack1.isEmpty() && stack2.isEmpty());
        }
        public void enqueue(V value){
            stack1.push(value);
        }
        public V dequeue(){
            //return null if both the stacks are empty
            if (isEmpty()){
                return null;
            }
            else if (stack2.isEmpty()){
                //if stack2 is empty, we pop all the elements
                //from stack1 and push them to the stack2
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                //finally, we return the top of stack2
                return stack2.pop();
            }
            else{
                //if none of the above conditions are true
                //we will simply return the top of stack2
                return stack2.pop();
            }
        }

    }
    class QueueWithStack2 <V> {
        private StackImpl<V> stack1;
        private StackImpl<V> stack2;

        public void QueueWithStack(int maxSize){
            stack1 = new StackImpl<>(maxSize+1);
            stack2 = new StackImpl<>(maxSize+1);
        }

        public void enqueue(V value){
            if(stack1.isFull() || stack2.isFull())
                return;
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack1.push(value);
            while(!stack2.isEmpty())
                stack1.push(stack2.pop());

        }
        public V dequeue(){
            if(stack1.isEmpty()) return null;
            return stack1.pop();
        }
        public boolean isEmpty(){
            if(stack1.isEmpty() && stack2.isEmpty()) return true;
            return false;
        }
    }
    static class QueueWithStack1 <V> {
        //We can use 2 stacks for this purpose, stack1 to store original values
        //and stack2 which will help in dequeue operation.
        StackImpl<V> stack1;
        StackImpl<V> stack2;

        public void QueueWithStack(int maxSize){
            stack1 = new StackImpl<>(maxSize);
            stack2 = new StackImpl<>(maxSize);
        }
        public boolean isEmpty(){
            return stack1.isEmpty();
        }
        public void enqueue(V value){
            stack1.push(value);
        }
        public V dequeue(){
            //Traverse stack1 and pop all elements in stack2
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            //pop from stack2 (which was at the end of stack1)
            V result = stack2.pop();
            //put all elements back in stack1
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return result;
        }

    }


    
}
