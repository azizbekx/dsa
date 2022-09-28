package code_trust.data_structures.trie;

public class Ch4WordFormationGivenDictionary {
    /*
    Time - O(n^2)
     */
    public static boolean isFormationPossible(String[] dict, String word){
        if (word.length() < 2 || dict.length <2)
            return false;
        //Create Trie and insert dictionary elements in it
        Trie trie = new Trie();
        for (String s : dict) trie.insert(s);

        for(int i=0; i<word.length(); i++){
            //Slice the word into two strings in each iteration
            String first = word.substring(0,i);
            String second = word.substring(i, word.length());

            //If both substrings are present in the trie, the condition is fulfilled
            if (trie.search(first) && trie.search(second))
                return true;
        }
        return false;
    }
}
