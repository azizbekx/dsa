package grokking.coding_pattern.subsets;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpression {
    /*

    Catalan number O(4^N / sqrt(N))
     */
    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();

        // base case: if the input string is a number, parts and add it to output
        if (!input.contains("+") && !input.contains("-") && !input.contains("*"))
            result.add(Integer.parseInt(input));

        else {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if(!Character.isDigit(ch)){
                    // break the equation here into two parts and made recursively calls
                    List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
                    List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i + 1));
                    for (int part1 : leftParts){
                        for (int part2 : rightParts){
                            if (ch == '+')
                                result.add(part1 + part2);
                            if (ch == '-')
                                result.add(part1 - part2);
                            if (ch == '*')
                                result.add(part1 * part2);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}
