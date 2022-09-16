package grokking.coding_pattern.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class P4FruitsIntoBasket {
    public static int findLength(String str) {
        if (str == null || str.length() == 0)
            throw new IllegalArgumentException();
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char right = str.charAt(windowEnd);
            charFreq.put(right, charFreq.getOrDefault(right, 0) + 1);

            //let's shrink the sliding window, until we are left 'k' distinct characters in the frequency map
            while (charFreq.size() > 2) {
                char left = str.charAt(windowStart);
                charFreq.put(left, charFreq.get(left) - 1);
                if (charFreq.get(left) == 0)
                    charFreq.remove(left);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println("Length of the longest substring: " + findLength("araaci"));
        System.out.println("Length of the longest substring: " + findLength("araaci"));
        System.out.println("Length of the longest substring: " + findLength("cbbebi"));
    }
}
