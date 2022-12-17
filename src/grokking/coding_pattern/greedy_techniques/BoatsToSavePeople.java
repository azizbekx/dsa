package grokking.coding_pattern.greedy_techniques;

import java.util.Arrays;

public class BoatsToSavePeople {
    /*
    Time - O(n+ nlogn)
    Space - O(n)
     */
    public static int rescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int l = 0, r = people.length - 1;
        while (l <= r) {
            boats++;
            if (people[l] + people[r] <= limit) l++;
            r--;
        }
        return boats;
    }
}