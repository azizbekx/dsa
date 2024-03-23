package leetcode.Y2022.december;

import java.util.HashMap;
import java.util.Map;

public class TwpHalvesAreLike {
    public static boolean halvesAreAlike(String s) {
        Map<Character, Integer> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();

        int j = s.length() - 1;
        for (int i = 0; i < s.length()/2; i++, j--) {
            char c1 = s.charAt(j);
            char c2 = s.charAt(i);

            if (checkVowel(c1)) {
                map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            }
            if (checkVowel(c2)) {
                map2.put(c2, map2.getOrDefault(c2, 0) + 1);
            }
        }

        return map1.equals(map2);
    }
    public static boolean checkVowel(char c){
        String VOWELS = "aeiouAEIOU";
        return VOWELS.indexOf(c) != -1;
    }

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }
}
