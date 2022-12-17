package grokking.coding_pattern.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P5LongestSubstringDistinct {


    public static int findLength(String str) {
        int start = 0;
        int len = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
            while (charFreq.size() > set.size()) {
                char left = str.charAt(start);
                charFreq.put(ch, charFreq.get(left) - 1);
                if (charFreq.get(left) > 0)
                    charFreq.remove(left);
                start++;
            }
            len = Math.max(len, end - start + 1);

        }
        return len;

    }


    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + findLength("abbbb"));
        System.out.println("Length of the longest substring: " + findLength("abccde"));
    }
}
