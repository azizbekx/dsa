package code_trust.data_structures.trie;

import java.util.Arrays;

public class Ch1FindNumberOfWords {
    /*
    Time - O(d^h) d - size of alphabet h - length of longest the word
     */
    public static int totalWords(TrieNode root) {
        int result = 0;

        if (root.isEndWord)
            result++;

        for (int i = 0; i < 26; i++)
            if (root.children[i] != null)
                result += totalWords(root.children[i]);

        return result;
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};

        System.out.println("Keys: " + Arrays.toString(keys));

        // Construct trie
        Trie t = new Trie();

        for (int i = 0; i < keys.length; i++)
            t.insert(keys[i]);

        System.out.println(totalWords(t.getRoot()));
    }
}
