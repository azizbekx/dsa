package code_trust.data_structures.stack_and_queue.challenge;

import code_trust.data_structures.stack_and_queue.StackImpl;

public class Challenge6_EvalueatePrefix {
    public static int evaluatePostFixO(String expression) {
        StackImpl<Integer> stack = new StackImpl<>(expression.length());
        //1.Scan expression character by character,
        //2.If character is a number push it in stack
        //3.If character is operator then pop two elements from stack
        //perform the operation and put the result back in stack
        //At the end, Stack will contain result of whole expression.
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (!Character.isDigit(character)) {
                Integer x = stack.pop();
                Integer y = stack.pop();

                switch (character) {
                    case '+':
                        stack.push(y + x);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(y * x);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                }

            } else
                stack.push(Character.getNumericValue(character));
        }
        return stack.pop();
    }

    public static int evaluatePostFix(String expression) {
        StackImpl<Integer> stack = new StackImpl<>(expression.length());

        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(String.valueOf(expression.charAt(i)).matches("[-+*/]")){
                calc(stack, String.valueOf(c));
            }else{
                stack.push(Character.getNumericValue(c));
            }
        }


        return stack.top();
    }

    public static void calc(StackImpl<Integer> stack, String operator){
        int res = 0;
        int a = stack.pop();
        int b = stack.pop();
        switch(operator){
            case "-":
                res = b - a;
                stack.push(res);
                break;
            case "+":
                res = b + a;
                stack.push(res);
                break;
            case "*":
                res = b * a;
                stack.push(res);
                break;
            case "/":
                res = b / a;
                stack.push(res);
                break;
        }
    }
    public static void main(String[] args) {
        System.out.println(evaluatePostFix("921*-8-4+"));
        //Try your own examples below
    }
}
