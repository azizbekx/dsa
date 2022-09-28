package code_trust.data_structures.trie;

public class TrieNode {
    TrieNode[] children;
    boolean isEndWord;
    static final int ALPHABET_SIZE = 26;

    public TrieNode() {
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }
    public void markAsLeaf(){
        this.isEndWord = true;
    }
    public void unmarkedAsLeaf(){
        this.isEndWord = false;
    }
}
