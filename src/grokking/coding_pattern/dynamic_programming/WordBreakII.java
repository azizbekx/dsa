package grokking.coding_pattern.dynamic_programming;

import java.util.*;

public class WordBreakII {
    public static String[] wordBreak(String s, String[] WordDict) {
        Set<String> dictSet = new HashSet<>(Arrays.asList(WordDict));
        // Calling the helper function
        List<String> result = helper(s, dictSet, new HashMap<String, LinkedList<String>>());
        return result.toArray(new String[result.size()]);
    }

    // helper function returns an array including all substrings derived from s.
    public static List<String> helper(String s, Set<String> dictSet, HashMap<String, LinkedList<String>> map) {
        if(s==""){
            return new ArrayList<String>();
        }
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> result = new LinkedList<String>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        for (String word : dictSet) { // Verifying if s can be broken down further
            if (s.startsWith(word)) {
                List<String> sublist = helper(s.substring(word.length()), dictSet, map);
                for (String sub : sublist)
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, result);
        return result;
    }

    public static void main(String args[]) {
        String[] subs = {"an", "book", "car", "cat", "cook", "cookbook", "crash",
                "cream", "high", "highway", "i", "ice", "icecream", "low", "scream",
                "veg", "vegan", "way", "hello", "from", "what", "cats", "and", "dog",
                "sand", "pineapple", "pine", "apple", "pen", "applepen"};

        String[] s = {"vegancookbook", "catsanddog", "highwaycrash",
                "pineapplepenapple", "screamicecream"};

        System.out.println(
                "The list of words we can use to break down the strings are");
        System.out.println(Arrays.toString(subs) + "\n");
        for (int i = 0; i < s.length; i++) {
            System.out.print((i + 1) + ".\tThe possible strings from the string: "
                    + s[i] + " are the following combinations ");
            System.out.println("\n\t" + Arrays.toString(wordBreak(s[i], subs)));
//            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
