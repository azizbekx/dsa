package code_trust.data_structures.HashTable.challenge;

import java.util.HashSet;

public class Challenge1_Find_Subset_Array {
    // Time - O(m+n)
    // Space - O(n)
    public static boolean isSubset(int[] arr1, int[] arr2) {

        HashSet<Integer> hSet = new HashSet<>();
        for(int i : arr1)
            hSet.add(i);

        for(int j : arr2){
            if(!hSet.contains(j))
                return false;
        }
        return true;
    }
}
