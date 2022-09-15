package code_trust.data_structures.HashTable.challenge;

import java.util.HashSet;

public class Challenge10_FIndTwoSum {
    public static int[] findSum(int[] arr, int n)
    {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            int b = n-i;
            if(set.contains(n - i))
                return new int[]{b, i};
            set.add(i);
        }
        return result;   // return the elements in the array whose sum is equal to the value passed as parameter
    }
}
