package grokking.coding_pattern.dynamic_programming;

import java.util.*;

/*
n - total
m - the number of coins
Time - O(n*m)
Space - O(n)
 */
public class CoinChange {

    public static int coinChange(List<Integer> coins, int total) {
        if (total < 1)
            return 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < total; i++)
            l.add(Integer.MAX_VALUE);
        return calculateMinimumCoins(coins, total, l);
    }
    private static int calculateMinimumCoins(List<Integer> coins, int rem, List<Integer> counter){
        int result = 0;
        if (rem < 0)
            return -1;
        if (rem == 0)
            return 0;
        if (counter.get(rem - 1) != Integer.MAX_VALUE)
            return counter.get(rem - 1);
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < coins.size(); j++){
            result = calculateMinimumCoins(coins, rem - coins.get(j), counter);
            if (result >= 0 && result < minimum)
                minimum = 1 + result;
        }
        if (minimum != Integer.MAX_VALUE)
            counter.set(rem - 1, minimum);
        else
            counter.set(rem - 1, -1);

        return counter.get(rem - 1);
    }
    public static void main( String args[] ) {
        List<List<Integer>> coins = Arrays.asList(List.of(5), Arrays.asList(1, 4, 6, 9), Arrays.asList(6, 7, 8), Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(14, 15, 18, 20));
        List<Integer> total = Arrays.asList(3, 11, 27, 41, 52);
        for (int i = 0; i < total.size(); i++)
        {
            System.out.println(i + 1 + ".\tThe minimum number of coins required to find " + total.get(i) + " from " + coins.get(i) + " is: "+ coinChange(coins.get(i), total.get(i)));
//            System.out.println(PrintHyphens.repeat("-", 100));
        }

    }

}
