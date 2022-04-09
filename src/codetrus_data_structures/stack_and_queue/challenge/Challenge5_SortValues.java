package codetrus_data_structures.stack_and_queue.challenge;

import codetrus_data_structures.stack_and_queue.StackImpl;

public class Challenge5_SortValues {
    //recursive
    //space - O(1)
    //time - O(n^2)
    public static void insert(StackImpl<Integer> stack, int value){
        if (stack.isEmpty() || value < stack.top())
            stack.push(value);
        else{
            int temp = stack.pop();
            insert(stack, value);
            stack.push(temp);
        }
    }
    public static StackImpl<Integer> sortStack(StackImpl<Integer> stack){
        if (!stack.isEmpty()){
            int value = stack.pop();
            sortStack(stack);
            insert(stack, value);
        }
        return stack;
    }


    // with using another stack
    //time - O(n^2)
    public static void sortStack2(StackImpl<Integer> stack) {
        //1. Use a second tempStack.
        //2. Pop value from mainStack.
        //3. If the value is greater or equal to the top of tempStack, then push the value in tempStack
        //else pop all values from tempStack and push them in mainStack and in the end push value in tempStack and repeat from step 2.
        //till mainStack is not empty.
        //4. When mainStack will be empty, tempStack will have sorted values in descending order.
        //5. Now transfer values from tempStack to mainStack to make values sorted in ascending order.
        StackImpl<Integer> newStack = new StackImpl<>(stack.getMaxSize());
        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            if (!newStack.isEmpty() && value >= newStack.top()) {
                newStack.push(value);
            } else {
                while (!newStack.isEmpty() && newStack.top() > value)
                    stack.push(newStack.pop());
                newStack.push(value);
            }
        }
        while (!newStack.isEmpty())
            stack.push(newStack.pop());
    }

    public static void main(String[] args) {

        StackImpl<Integer> stack = new StackImpl<>(7);
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);
        sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
