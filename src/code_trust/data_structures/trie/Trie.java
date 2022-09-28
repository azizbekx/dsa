package code_trust.data_structures.trie;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int getIndex(char t) {
        return t - 'a';
    }

    //Function to get root
    public TrieNode getRoot() {
        return root;
    }

    /*
    Time - O(h) h -> length of word, running time of TrieNode constructor is O(d) alphabet size
     */
    public void insert(String key) {
        if (key == null) {
            System.out.println("Null Key can not be Inserted!");
            return;
        }
        key = key.toLowerCase(); // keys are stored in lowercase
        TrieNode currentNode = this.root;
        int index = 0; // to store character index

        // Iterate the Trie with given character index,
        // If it is null, then simply create a TrieNode and go down a leave
        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currentNode.children[index] == null) currentNode.children[index] = new TrieNode();
            currentNode = currentNode.children[index];
        }
        // Mark the end character as leaf node
        currentNode.markAsLeaf();
    }

    /*
    Time - O(h) h-> length of the word
     */
    public boolean search(String key) {
        if (key == null) return false; // Null key

        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;
        // Iterate the Trie with given character index
        // If it is null at any point then we stop and return false
        // We will return true only if we reach leafNode and have traversed the
        // Trie based on the length of the key
        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currentNode.children[index] == null) return false;
            currentNode = currentNode.children[index];
        }

        return currentNode.isEndWord;
    }

    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level) {
        boolean deletedSelf = false;

        if (currentNode == null) {
            System.out.println("Key does not exist");
            return deletedSelf;
        }
        // Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length) {
            // If there are no nodes ahead of this node in this path
            // then we can delete this node
            if (hasNoChildren(currentNode)) {
                currentNode = null;
                deletedSelf = true;
            }
            // If there are nodes ahead of currentNode in this path
            // Then we cannot delete currentNode. We simply unmark this as leaf
            else {
                currentNode.unmarkedAsLeaf();
                deletedSelf = false;
            }
        } else {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted) {
                // Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                // If currentNode is leaf node that means currentNode is part of another key
                // and hence we can not delete this node, and it's parent path nodes
                if (currentNode.isEndWord) deletedSelf = false;
                    // If childNode is deleted but if currentNode has more children than currentNode must be part of another key.
                    // So, we cannot delete currentNode
                else if (!hasNoChildren(currentNode)) deletedSelf = false;
                else {
                    currentNode = null;
                    deletedSelf = true;
                }

            } else deletedSelf = false;
        }
        return deletedSelf;
    }

    //Helper Function to return true if currentNode does not have any children
    private boolean hasNoChildren(TrieNode currentNode) {
        for (int i = 0; i < currentNode.children.length; i++)
            if (currentNode.children[i] != null) return false;
        return true;
    }


    //Function to delete given key from Trie
    public void delete(String key) {
        if (root == null || key == null) {
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }
}
