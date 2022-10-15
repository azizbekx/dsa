package grokking.coding_pattern.two_pointer;

import java.util.*;

public class P4TripletSumToZero {
    /*
    Time  - O(n^2)
        sort -> O(nlogn)
        searchPair -> O(n)
    Space - O(n)
     */
    public static List<List<Integer>> searchTripletsO(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
                continue;
            searchPair(arr, -arr[i], i + 1, triplets);
        }

        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) { // found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++; // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--; // skip same element to avoid duplicate triplets
            } else if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
    }

    /*
    Time - O(n^2)
    Space - O(n)
     */
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            Map<Integer, Integer> minMap = new HashMap<>();
            for (int j = i + 1; j < arr.length; j++) {
                if (minMap.containsKey(-first - arr[j])) {
                    triplets.add(new ArrayList<>(Arrays.asList(first, arr[j], (-first - arr[j]))));
                } else {
                    minMap.put(arr[j], 0);
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(searchTripletsO(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(searchTripletsO(new int[]{-5, 2, -1, -2, 3}));
    }
}
