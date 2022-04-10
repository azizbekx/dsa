package codetrus_data_structures.HashTable.challenge;

import java.util.HashMap;

public class Challenge6_Sub_Zero {
    // Time - O(n)
    // Space - O(n)

    public static boolean findSubZeroO(int[] arr) {

        //Use HashMap to store Sum as key and index i as value till sum has been calculated.
        //Traverse the array and return true if either
        //arr[i] == 0 or sum == 0 or HashMap already contains the sum
        //If you completely traverse the array and havent found any of the above three
        //conditions then simply return false.
        HashMap< Integer,Integer > hMap = new HashMap < >();

        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0 || sum == 0 || hMap.get(sum) != null) return true;

            hMap.put(sum, i);
        }

        return false;
    }

    //time - O(n^2)
    //space - O(1)
    public static boolean findSubZero(int[] arr) {

        for(int i=0; i<arr.length; i++){
            int sum = arr[i];
            for(int j=i+1; j<arr.length; j++){
                sum += arr[j];
                if(sum == 0) return true;
            }
        }
        return false;
    }


}
