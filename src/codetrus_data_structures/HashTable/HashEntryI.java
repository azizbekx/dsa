package codetrus_data_structures.HashTable;

public class HashEntryI {
    String key;
    int value;

    HashEntryI next;

    public HashEntryI(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
