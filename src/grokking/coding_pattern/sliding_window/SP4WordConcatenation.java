package grokking.coding_pattern.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SP4WordConcatenation {
    /*
    N is number of character in string,
    M is total number of words
    Len is the length of a word
    Time - O(N*M*Len)
    Space - O(M+N)
    O(M) -> hashMap
    O(N) -> result list
     */
    public static List<Integer> findWordConcatenationO(String str, String[] words) {
        Map<String, Integer> wordFreq = new HashMap<>();
        for(String word: words)
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);

        List<Integer> resultIndices = new ArrayList<Integer>();
        int wordsCount = words.length, wordLength = words[0].length();

        for(int i=0; i<= str.length() - wordsCount * wordLength; i++){
            Map<String, Integer> wordsSeen = new HashMap<>();
            for(int j=0; j<wordsCount; j++){
                int nextWordIndex = i + j * wordLength;
                //get the next word from the string
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if(!wordFreq.containsKey(word))//break if we don't need this word
                    break;
                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                // no need to process futher if the word has higher frequency than required
                if(wordsSeen.get(word) >  wordFreq.getOrDefault(word, 0))
                    break;
                if(j+1 == wordsCount)
                    resultIndices.add(i);
            }
        }
        return resultIndices;
    }

    public static List<Integer> findWordConcatenation(String str, String[] words) {

        List<Integer> resultIndices = new ArrayList<Integer>();
        int start = 0, matched = 0, subStart = 0;
        int wordLen = words[0].length();
        Map<String, Integer> stringFreq = new HashMap<>();


        if (wordLen > str.length()) {
            return resultIndices;
        }

        for (String s : words)
            stringFreq.put(s, stringFreq.getOrDefault(s, 0) + 1);

        for (int end = wordLen; end < str.length(); end += wordLen) {
            String right = str.substring(subStart, end);
            subStart += wordLen;
            if (stringFreq.containsKey(right)) {
                stringFreq.put(right, stringFreq.get(right) - 1);
                if (stringFreq.get(right) == 0)
                    matched++;
            }
            if (matched == words.length)
                resultIndices.add(start);

            if (end >= wordLen * words.length) {
                String left = str.substring(start, start + wordLen);
                start += wordLen;
                if (stringFreq.containsKey(left)) {
                    if (stringFreq.get(left) == 0)
                        matched--;
                    stringFreq.put(left, stringFreq.get(left) + 1);
                }
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        List<Integer> result = findWordConcatenationO("catfoxcat", new String[]{"cat", "fox"});
        System.out.println(result);
        result = findWordConcatenationO("catcatfoxfox", new String[]{"cat", "fox"});
        System.out.println(result);
    }
}
