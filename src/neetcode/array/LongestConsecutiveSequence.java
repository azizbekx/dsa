package neetcode.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // edge cases
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) numSet.add(n);
        int longest = 0;

        for (int n : nums)
            // Check if its the start of a sequence
            if (!numSet.contains(n-1)){
                int length = 0;
                while (numSet.contains(n + length)) length++;
                longest = Math.max(length, longest);
            }

        return longest;
    }
}
