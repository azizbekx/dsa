package g_coding_patter.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class P6LongestSubstringWithSameLetter {
    public static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeat = 0;
        Map<Character, Integer> letterFreq = new HashMap<>();
        // try to expand the range [windowEnd, windowStart]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char right = str.charAt(windowEnd);
            letterFreq.put(right, letterFreq.getOrDefault(right, 0) + 1);
            // we don't need to place the maxRepeat under the below 'if' see the
            // explanation in the 'Solution' section above
            maxRepeat = Math.max(maxRepeat, letterFreq.get(right));

            //current window size if form windowStart to windowEnd, overall we have letter which is
            //repeating 'maxRepeat' time
            if(windowEnd - windowStart + 1 - maxRepeat > k){
                char left = str.charAt(windowStart);
                letterFreq.put(left, letterFreq.get(left) -1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart +1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));
    }
}
