package grokking.coding_pattern.top_k_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganizeStringO(String inputString) {
        // initialize the hash map
        Map<Character, Integer> charCounter = new HashMap<>();
        // store each character along with their frequency
        for (char c : inputString.toCharArray()){
            int freq = charCounter.getOrDefault(c, 0) + 1;
            charCounter.put(c, freq);
        }
        // initialize the max heap
        PriorityQueue<Map.Entry<Character, Integer>> maxFreqChar = new PriorityQueue<>(
                (item1, item2) -> item2.getValue() - item1.getValue()
        );

        // store all the characters with their frequencies to the max heap
        maxFreqChar.addAll(charCounter.entrySet());

        Map.Entry<Character, Integer> previous = null;
        StringBuilder result = new StringBuilder(inputString.length());
        while (!maxFreqChar.isEmpty()) {
            if (previous != null && maxFreqChar.isEmpty())
                return "";
            Map.Entry<Character, Integer> currentEntry = maxFreqChar.poll();

            if (previous != null && previous.getValue() > 0)
                maxFreqChar.offer(previous);

            result.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previous = currentEntry;
        }
        return result.length() == inputString.length() ? result.toString() : "''";

    }

    public static void main(String args[]) {
        String[] inputs = {
                "programming",
                "hello",
                "fofjjb",
                "abbacdde",
                "aba",
                "awesome",
                "aaab",
                "tree"
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string: " + inputs[i]);
            System.out.println("\n\tCount of char: " + reorganizeStringO(inputs[i]));
//            System.out.println(PrintHyphens.repeat("-", 100));
        }

    }
}
