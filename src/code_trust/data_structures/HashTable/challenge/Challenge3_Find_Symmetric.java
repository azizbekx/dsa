package code_trust.data_structures.HashTable.challenge;

import java.util.HashMap;

public class Challenge3_Find_Symmetric {
    public static String findSymmetric(int[][] arr) {

        String result = "";

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] ints : arr) {
            Integer first = ints[0];
            Integer second = ints[1];
            Integer value = map.get(second);


            if (value != null && value.equals(first)) {
                result += "{" + ints[1] + "," + ints[0] + "}";
            } else
                map.put(ints[0], ints[1]);

        }
        return result;
    }
}
