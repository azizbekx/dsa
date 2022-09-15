package code_trust.data_structures.HashTable.challenge;

import java.util.HashMap;

public class Challenge5_Find_Two_Pairs {
    public static void main(String[] args) {
        System.out.println(findPair(new int[]{3,4,7,1,12,9}));
    }
    //time - O(n^2)
    public static String findPair(int[] arr) {

        String result = "";
        HashMap<Integer, String> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                int sum = arr[i] + arr[j];
                String s ="{" + arr[i] +","+ arr[j] +"}";
                if(map.containsKey(sum)){
                    result = s + map.get(sum);
                    return result;
                }
                else
                    map.put(sum,s);
            }
        }

        return result;
    }
    //Optimal Solution of Course
    public static String findPairO(int[] arr) {
        String result = "";
        // Create HashMap with Key being sum and value being a pair i.e key = 3 , value = {1,2}
        // Traverse all possible pairs in given arr and store sums in map
        // If sum already exist then print out the two pairs.
        HashMap < Integer,int[] > hMap = new HashMap < >();

        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                int sum = arr[i] + arr[j]; //calculate sum

                if(!hMap.containsKey(sum)){
                    //If sum is not present in Map then insert it along with pair
                    hMap.put(sum, new int[] {arr[i], arr[j]});
                }
                else{
                    //Sum already present in Map
                    int[] prev_pair = hMap.get(sum);
                    //Since array elements are distinct, we don't
                    //need to check if any element is common among pairs
                    result += "{" + prev_pair[0] + "," + prev_pair[1] + "}{" + arr[i] + "," + arr[j] +"}";
                    return result;
                }
            }
        }//end of for
        return result;
    }

}
