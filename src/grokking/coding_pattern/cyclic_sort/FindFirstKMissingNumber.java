package grokking.coding_pattern.cyclic_sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindFirstKMissingNumber {
    public static List<Integer> findNumbers(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> extraMissingNumber = new HashSet<>();
        for (i = 0; i < nums.length & missingNumbers.size() < k; i++)
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
                extraMissingNumber.add(nums[i]);
            }
        // adding remaining missing numbers
        for(i = 1; missingNumbers.size() < k; i++){
            int candidateNumber = i + nums.length;
            // ignore if the array contains the candidate number
            if(!extraMissingNumber.contains(candidateNumber))
                missingNumbers.add(candidateNumber);
        }
        return missingNumbers;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        List<Integer> missingNumbers = findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = findNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}

