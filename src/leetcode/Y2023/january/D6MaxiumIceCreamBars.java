package leetcode.Y2023.january;

import java.util.Arrays;

public class D6MaxiumIceCreamBars {
    public int maxIceCreamO1(int[] costs, int coins) {
        int maxCost = 0;

        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }

        int[] numOfCosts = new int[maxCost + 1];

        for (int cost : costs) {
            numOfCosts[cost]++;
        }

        int iceCreamBars = 0;

        for (int cost = 1; cost <= maxCost; cost++) {
            if (numOfCosts[cost] == 0) {
                continue;
            }

            if (coins < cost) {
                break;
            }

            int count = Math.min(numOfCosts[cost], coins / cost);
            coins -= count * cost;
            iceCreamBars += count;
        }

        return iceCreamBars;
    }
    public int maxIceCreamO(int[] costs, int coins) {
        int m = costs[0];
        int icecreams = 0;

        for (int cost : costs){
            m = Math.max(m, cost);
        }
        int[] costsFrequency = new int[m + 1];
        for (int cost : costs){
            costsFrequency[cost]++;
        }

        for (int cost = 1; cost <= m; ++cost){
            // No ice cream is present costing 'cost'.
            if (costsFrequency[cost] == 0)
                continue;
            // We don't have enough 'coins' to even pick one ice cream
            if (coins < cost)
                break;
            // Count how many icecreams of 'cost' we can pick with our 'coins'.
            // Either we can pick all ice creams of 'cost' or we will be limited by remaining 'coints
            int count = Math.min(costsFrequency[cost], coins/cost);
            // we reduce price of picked ice creams from our coins
            coins -= cost * count;
            icecreams += count;
        }
        return icecreams;

    }
    public int maxIceCream(int[] costs, int coins) {
        int count = 0;
        Arrays.sort(costs);

        for (int cost : costs){
            coins -= cost;
            if (coins < 0)
                break;
            count++;
        }

        return count;
    }
}
