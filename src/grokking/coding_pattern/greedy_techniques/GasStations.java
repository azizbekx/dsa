package grokking.coding_pattern.greedy_techniques;

import java.util.Arrays;

public class GasStations {
    /*
    Time - O(n)
    Space - O(1)
     */
    public static int gasStationJourney(int[] gas, int[] cost) {
        int startIndex = 0, totalGas = 0;
        if (Arrays.stream(gas).sum() - Arrays.stream(cost).sum() < 0)
            return -1;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            if (totalGas < 0)
                startIndex = i + 1;
        }
        return startIndex;
    }
    public static void main(String[] args) {

        int[][] gas = {
                {1, 2, 3, 4, 5},
                {2, 3, 4},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 10},
                {1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5}
        };
        int[][] cost = {
                {3, 4, 5, 1, 2},
                {3, 4, 5},
                {1, 2, 3, 4, 5},
                {2, 2, 1, 3, 1},
                {1, 0, 1, 2, 3},
                {1, 2, 3, 4, 5}
        };
        for (int i = 0; i < cost.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tGas: " + Arrays.toString(gas[i]));
            System.out.println("\tCost: " + Arrays.toString(cost[i]));
            System.out.println("\tThe index of the gas station we can start our journey from is "+ gasStationJourney(gas[i], cost[i])+ " (If it's -1, then that\n\tmeans no solution exists)");
//            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
