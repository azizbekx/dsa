package leetcode.december;

import java.util.Objects;
import java.util.Stack;

public class Day17EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b = 0;
        for (String s : tokens) {
           if (Objects.equals(s, "+"))
               stack.push(stack.pop() + stack.pop());
           else if (Objects.equals(s, "*"))
               stack.push(stack.pop() * stack.pop());
           else if (Objects.equals(s, "-")) {
               a = stack.pop();
               b = stack.pop();
               stack.push(b - a);
           } else if (Objects.equals(s, "/")) {
               a = stack.pop();
               b = stack.pop();
               stack.push(b / a);
           }else
               stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

}
