package neetcode.array;

import java.util.*;

public class GroupAnagrams {
    // Leetcode Optimal Solution
    // Time - O(M * N)
    public static List<List<String>> groupAnagramsO(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        if (strs.length == 0) return new ArrayList<>(new ArrayList<>());

        for (String str : strs) {
            char[] count = new char[26];
            for (char c : str.toCharArray())
                count[c - 'a']++;
            String key = String.valueOf(count);
            anagrams.computeIfAbsent(key, k -> new ArrayList<>());
            anagrams.get(key).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }
    // My Solution
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String anagram = String.valueOf(charArr);
            if (anagrams.containsKey(anagram)) {
                anagrams.get(anagram).add(str);
            } else {
                anagrams.put(anagram, new ArrayList<>(List.of(str)));
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : anagrams.entrySet()){
            res.add(entry.getValue());
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
