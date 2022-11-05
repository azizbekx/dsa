package grokking.coding_pattern.subsets;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsByChangingCase {
    /*
    Time - O(N * 2^N)
    Space - O(N * 2^N)
     */
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null)
            return permutations;
        permutations.add(str);
        // process every character of the string one by one
        for(int i = 0; i < str.length(); i++){
            // only process characters, skip digits
            if(Character.isLetter(str.charAt(i))){
                // we will take existing permutations and change the letter case
                int n = permutations.size();
                for (int j = 0; j < n; j++){
                    char[] chs = permutations.get(j).toCharArray();
                    // if the current character is in uppercase change it to lower case or vice versa
                    if(Character.isUpperCase(chs[i]))
                        chs[i] = Character.toLowerCase(chs[i]);
                    else
                        chs[i] = Character.toUpperCase(chs[i]);
                    permutations.add(String.valueOf(chs));
                }
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
