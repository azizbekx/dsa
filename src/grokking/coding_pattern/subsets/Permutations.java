package grokking.coding_pattern.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    /*
    Time - O(N * N!)
    Space - O(N * N!)
     */
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take existing permuations and add the current number to create new permutations
            int n = permutations.size();
            for (int i = 0; i < n; i++){
                List<Integer> oldPermutation = permutations.poll();
                // create new permutations by adding the current number at every position
                for (int j = 0; j <= oldPermutation.size(); j++){
                    List<Integer> newPermutations = new ArrayList<>(oldPermutation);
                    newPermutations.add(j, currentNumber);
                    if(newPermutations.size() == nums.length)
                        result.add(newPermutations);
                    else
                        permutations.add(newPermutations);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
