package grokking.coding_pattern.two_pointer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P7SubarraysProductLessThanK {
    /*
    Time - O(n^3)
        for-loop - O(n)
        creating subarray - O(n^2)
    Space - O(n^2)
        temp list - O(n)
        output list - O(n^2)
     */
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        double product = 1;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left <= right)
                product /= arr[left++];
            /*
            Since the product of all numbers from left to right is less than
            the target therefore, all subarrays from left to right will have a product less than the target too;
            to avoid duplicates, we will start with a subarray containing only arr[right] and then extend it
             */
            List<Integer> tempList = new LinkedList<>();
            for(int i= right; i>= left; i--){
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
