package grokking.coding_pattern.greedy_techniques;

import java.util.Arrays;
import java.util.Comparator;

/*
N - number of elements
M - represents the memory required to sort this arrays
Time - O(NlogN)
Space - O(N + M)

 */
public class TwoCityScheduleCost {
    public static int twoCitySchedulingO(int[][] costs) {
        Pair[] pairs = new Pair[costs.length];

        for (int i = 0; i < costs.length; i++){
            Pair pair = new Pair(
                    costs[i][0], costs[i][1], costs[i][1] - costs[i][0],i
            );
            pairs[i] = pair;
        }
        Arrays.sort(pairs, Comparator.comparingInt(Pair::getDiff1Over2));
        int res = 0;
        for (int i = 0; i < pairs.length; i++){
            if (i < pairs.length / 2)
                res += pairs[i].cost2;
            else
                res += pairs[i].cost1;
        }
        return res;
    }
    public static int twoCityScheduling(int[][] costs) {
        // Array that we will use to divide the group in two equal parts.
        Pair[] difference = new Pair[costs.length];
        // Initiliazing a loop, to calculate the difference to travel to City A or B.
        for(int i = 0; i < costs.length; i++){
            // Calculating the differences, and adding costs for City A and B alongside in an array.
            int calculateDifference = costs[i][0] - costs[i][1];
            difference[i] = new Pair(costs[i][0], costs[i][1], calculateDifference, i);
        }
        // We sort the array based on the differences we calculated above.
        Arrays.sort(difference, Comparator.comparing(Pair::getDiff1Over2));

        // Initiliazing a new variable to calculate the minimum cost required to send exactly n people to both cities.
        int answer = 0;

        // Initiliazing a loop, to add the relevent costs to our answer variable.
        for(int i = 0; i < difference.length; i++){
            Pair pair = difference[i];
            if(i < (difference.length/2)){
                // We will send this half to City B
                answer += pair.cost1;
            }else {
                // We will send this half to City A
                answer += pair.cost2;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int[][][]A = {{{10, 20}, {30, 200}, {400, 50}, {30,20}}, {{259,770}, {448,54}, {926,667}, {184,139}, {840,118}, {577,469}},
                {{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779},{457, 60}, {650, 359}, {631, 42}}, {{1, 2}, {3, 4}, {5, 6}, {7,8}}, {{1, 2}, {1, 2}, {1, 2}, {1, 2}}};

        for(int i=0;i<A.length;i++){
            System.out.println("Test Case # "+ (i + 1));
            System.out.println("\nThe minimum cost to send people equally into City A and B when the costs are "+ Arrays.deepToString(A[i])+ " is:\n");
            System.out.println(twoCitySchedulingO(A[i]));
//            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }

}
