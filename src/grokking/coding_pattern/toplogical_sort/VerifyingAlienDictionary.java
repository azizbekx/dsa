package grokking.coding_pattern.toplogical_sort;

import java.util.HashMap;

public class VerifyingAlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];

            for (int j = 0; j < word1.length(); j++) {
                if (j == word2.length()) return false;
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (map.get(word2.charAt(j)) < map.get(word1.charAt(j))) return false;
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
