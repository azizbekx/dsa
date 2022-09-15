package code_trust.data_structures.HashTable.challenge;

import java.util.HashSet;

public class Challenge2_Check_Arrays_Disjoint {
    public static Object isDisjoint(int[] arr1,int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr1)
            set.add(i);
        for(int i : arr2)
            if(set.contains(i))
                return false;

        return true;
    }
}
