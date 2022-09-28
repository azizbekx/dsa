package grokking.coding_pattern.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class P1PairWithSum {
    /*
    Time - O(n)
    Space - O(1)
     */
    public static int[] searchO(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[left] + arr[right] == targetSum) return new int[]{left, right};
            if (arr[left] + arr[right] > targetSum) right--;
            else left++;
        }
        return new int[]{-1, -1};
    }
    public static int[] search(int[] arr, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(targetSum - arr[i])){
                return new int[]{map.get(targetSum - arr[i]),i};
            }else{
                map.put(arr[i],i);
            }
        }
        return new int[]{-1, -1};
    }
    /*
    Time - O(n)
    Space - O(n)
     */
    public static void main(String[] args) {
        int[] result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
