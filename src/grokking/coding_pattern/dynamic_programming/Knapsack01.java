package grokking.coding_pattern.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack01 {

    public static int findMaxKnapsackProfit(int capacity,
                                            List<Integer> weights,
                                            List<Integer> values) {
        // Store values length to use it later in the code
        int valuesLength = values.size();
        // check if the constraints are fulfilled for the given problem
        // check if the given capacity is not smaller than or equals to zero
        // check if the length of values is not equal to zero, if zero we will
        // return 0
        // check if the length of weigths is not equals to length of the values
        // if false we will return 0
        if (capacity <= 0 || valuesLength == 0 || weights.size() != valuesLength)
            return 0;
        // initialise list named profits of size(capacity + 1) and fill the list with 0
        List<Integer> profits = new ArrayList<>(capacity + 1);
        for (int i = 0; i < capacity + 1; i++)
            profits.add(0);
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("i" + "    | " + "values[i]" + "    | " + "weights[i]" + "    | " + "c" + "       | " + "Initial profit[c]" + "    | " + "Current profit[c]");
        System.out.println("-------------------------------------------------------------------------------------------");
        // iterate in values and weight list using i as an iterator where
        // values and weight list have the same lengths
        for (int i = 0; i < valuesLength; i++) {
            // Find the profit for each capacity starting from Cn to C0
            for (int c = capacity; c >= 0; c--) {
                // Check if the weight[i] is smaller than or equal to capacity
                // in range Cn - C0
                if (weights.get(i) <= c) {
                    // Saving the profit for priniting purposes
                    int initProfit = profits.get(c);
                    // Calculate the new profit using the previous profit and
                    // values[i]
                    int newProfit = profits.get(c - weights.get(i)) + values.get(i);
                    // Set profits[c] value equal to the maxium of profits[c]
                    // and new calculated profit
                    profits.set(c, Math.max(profits.get(c), newProfit));
                    System.out.println(i + "    | " + values.get(i) + "            | " + weights.get(i) + "             | " + c + "       | " + initProfit +  "                  | " + profits.get(c));
                }
            }
        }
        return profits.get(capacity);
    }

    public static void main(String args[]) {
        List<Integer> weights = Arrays.asList(1, 2, 3, 5);
        List<Integer> values = Arrays.asList(1, 5, 4, 8);
        int capacity = 6;

        System.out.println("We have the following list of values and weights for the capacity  " + capacity + ": ");
        System.out.println("---------------------------------");
        System.out.println("Weights" + "    |    " + "Values");
        System.out.println("---------------------------------");
        for (int i = 0; i < values.size(); i++)
            System.out.println(weights.get(i) + "          |    " + values.get(i));
        System.out.println("\nLet's look at the following table for all iterations:\n");
        int result = findMaxKnapsackProfit(capacity, weights, values);
        System.out.println("\n\nThe maximum profit found: " + result);
    }


    /*
    public static int findMaxKnapsackProfit(int capacity, List<Integer> weight,
                                            List<Integer> value) {
        int[] profits = new int[capacity + 1];
        for (int i = 0; i < value.size(); i++) {
            for (int j = 0; j < capacity; j++) {
                if (weight.get(i) < capacity) {
                    profits[i] = value.get(i);
                }
            }
        }
        return profits[capacity];
    }
     */
}

