package code_trust.data_structures.HashTable;

import java.util.ArrayList;

public class HashTableI {
    private ArrayList<HashEntryI> bucket;
    private int slots;
    private int size;

    public HashTableI() {
        bucket = new ArrayList<>();
        this.size = 0;
        this.slots = 10;
        for (int i = 0; i < slots; i++)
            bucket.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getIndex(String key) {
        int hashCode = key.hashCode();
        int index = hashCode % slots;
        if (index < 0)
            index = (index + slots) % slots;
        return index;
    }

    //Inserts a key value pair into table
    public void insert(String key, int value) {
        //Find head of chain
        int b_index = getIndex(key);
        HashEntryI head = bucket.get(b_index);

        //Check if the key is already exists
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        //Inserts key in the chain
        size++;
        head = bucket.get(b_index);
        HashEntryI new_slot = new HashEntryI(key, value);
        new_slot.next = head;
        bucket.set(b_index, new_slot);

        //Checks if array > 60% of the array gets filled
        if ((1.0 * size) % slots >= 60) {
            ArrayList<HashEntryI> temp = bucket;
            bucket = new ArrayList<>();
            slots = 2 * slots;
            size = 0;

            for (int i = 0; i < slots; i++)
                bucket.add(null);
            for (HashEntryI head_node : temp){
                while(head_node != null){
                    insert(head_node.key, head_node.value);
                    head_node = head_node.next;
                }
            }
        }
    }

    //Return a value for a given key
    public int getValue(String key){
        //Find a head of chain
        int b_index = getIndex(key);
        HashEntryI head = bucket.get(b_index);
        //Search key in the slots
        while(head != null){
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        //If key not found
        return -1;
    }

    //Remove a value based key
    public int delete(String key){
        //Find index
        int b_index = getIndex(key);
        //Get head of the chain for the index
        HashEntryI head = bucket.get(b_index);
        //Find the key in the slots
        HashEntryI prev = null;
        while(head != null){
            if (head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }
        //If key doesn't exist
        if (head == null)
            return -1;
        //Decrease the size by one
        size--;
        //Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucket.set(b_index, head.next);

        return head.value;
    }

}
