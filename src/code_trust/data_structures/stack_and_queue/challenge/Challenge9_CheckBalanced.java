package code_trust.data_structures.stack_and_queue.challenge;

import code_trust.data_structures.stack_and_queue.StackImpl;

public class Challenge9_CheckBalanced {
    public static boolean isBalanced(String exp) {
        StackImpl<String> stack1 = new StackImpl<>(exp.length());
        StackImpl<String> stack2 = new StackImpl<>(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            String s = String.valueOf(exp.charAt(i));

            if (s.equals("{") || s.equals("(") || s.equals("["))
                stack1.push(s);
            else stack2.push(s);
        }

        while (!stack1.isEmpty()) {
            if (stack1.getCurrentSize() != stack2.getCurrentSize())
                return false;
            String s1 = stack1.pop();
            String s2 = stack2.pop();

            if (!isOpponent(s1,s2))
                return false;

        }
        return true;
    }

    public static boolean isOpponent(String s1, String s2) {
        switch (s1) {
            case "{":
                return s2.equals("}");
            case "[":
                return s2.equals("]");
            case "(":
                return s2.equals(")");
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("}{}{}"));
    }

}
