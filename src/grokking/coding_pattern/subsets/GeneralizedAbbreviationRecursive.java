package grokking.coding_pattern.subsets;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviationRecursive {
    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<>();
        generateAbbreviationRecursive(word, new StringBuilder(), 0, 0, result);
        return result;
    }
    private static void generateAbbreviationRecursive(String word, StringBuilder str,
                                                      int start, int count,
                                                      List<String> result){
        if(start == word.length()) {
            if (count != 0) str.append(count);
            result.add(str.toString());
        }else {
            generateAbbreviationRecursive(word,
                    new StringBuilder(str), start + 1, count + 1, result);

            if(count != 0)
                str.append(count);

            generateAbbreviationRecursive(word,
                    new StringBuilder(str).append(word.charAt(start)), start + 1, 0, result);
        }
    }
    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviationRecursive.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviationRecursive.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
