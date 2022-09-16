package code_trust.algorithms.searching_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class P3GroupAnagrams {
    /*
    Time - O(n*klogk)
    k -> length of the word
    n-> number of words
     */
    public static String groupAnagrams(String[] arr) {
        HashMap<String, List<String>> myMap = new HashMap<>();

        // traverse all the words
        for (String word : arr) {
            char[] letters = word.toCharArray(); // convert the given String Array's each index value to char array
            Arrays.sort(letters); // now sort all the words (based of letter's ASCII values using built in sort function for Arrays)
            String newWord = new String(letters); //  and then re-convert each word to separate String

            if (myMap.containsKey(newWord)) // calculate hashcode of string after sorting
                myMap.get(newWord).add(word);
            else {
                List<String> totalWords = new ArrayList<>();
                totalWords.add(word); // Add words for the specific hashcode
                myMap.put(newWord, totalWords);
            }
        }
        String anagrams = "";
        for (String s : myMap.keySet()) // print values if size is > 1, If you want to print non-anagrams, then print the values with size = 1
        {
            List<String> values = myMap.get(s);
            if (values.size() > 1) anagrams = anagrams + values;
        }
        return anagrams;
    }
}
