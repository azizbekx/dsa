package grokking.coding_pattern.greedy_techniques;

import java.util.Arrays;

public class JumpGameI {
    public static String repeat(String str, int pValue) {
        String out = "";
        for (int i = 0; i < pValue; i++) {
            out += str;
        }
        return out;
    }

    public static String printArrayWithMarker(int[] arr, int pValue1, String mrk1a, String mrk1b, int pValue2, String mrk2a, String mrk2b) {
        String out = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            if (i == pValue1) {
                out += mrk1a;
                out += String.valueOf(arr[i]) + mrk1b + ", ";
            } else if (i == pValue2) {
                out += mrk2a;
                out += String.valueOf(arr[i]) + mrk2b + ", ";
            } else {
                out += String.valueOf(arr[i]) + ", ";
            }
        }
        if (arr.length - 1 == pValue1) {
            out += mrk1a;
            out += String.valueOf(arr[arr.length - 1]) + mrk1b + "]";
        } else if (arr.length - 1 == pValue2) {
            out += mrk2a;
            out += String.valueOf(arr[arr.length - 1]) + mrk2b + "]";
        } else
            out += String.valueOf(arr[arr.length - 1]) + "]";
        return out;
    }

    public static String printArrayWithMarker(int[] arr, int pValue, String mrk1a, String mrk1b) {
        String out = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            if (i == pValue) {
                out += mrk1a;
                out += String.valueOf(arr[i]) + mrk1b + ", ";
            } else {
                out += String.valueOf(arr[i]) + ", ";
            }
        }
        if (arr.length - 1 == pValue) {
            out += mrk1a;
            out += String.valueOf(arr[arr.length - 1]) + mrk1b + "]";
        } else
            out += String.valueOf(arr[arr.length - 1]) + "]";
        return out;
    }

    public static boolean jumpGame(int[] nums) {
        System.out.println("\tSetting the last element in our array as our initial target: ");
        int targetNumIndex = nums.length - 1;
        System.out.println("\t\t" + printArrayWithMarker(nums, targetNumIndex, "»", "«"));
        System.out.println("\tWorking backwards in the array:");
        // Traversing the array from the back to the first element in the array
        for (int i = nums.length - 2; i >= 0; i--) {
            System.out.println("\t\t Loop iteration: " + (nums.length - i - 1));
            System.out.println("\t\t" + printArrayWithMarker(nums, i, "«", "»", targetNumIndex, "»", "«"));
            if (targetNumIndex == i) {
                System.out.println("\t\tBoth the current and target indexes are the same.");
                System.out.println("\t\tThe target is reachable.\n");
            } else if (targetNumIndex <= (i + nums[i])) {
                System.out.println("\t\tSince target index (" + targetNumIndex + ") is within "
                        + nums[i] + " jump(s) of current index (" + i + "),\n"
                        + "\t\twe can reach it from here.");
                System.out.println("\t\t\tUpdating target index to current index: " + targetNumIndex + " → " + i + "\n");
                targetNumIndex = i;
            } else {
                System.out.println("\t\tJumping to the target is not possible from here.\n" +
                        "\t\t\tChecking preceding indexes.\n");
            }
        }
        return targetNumIndex == 0;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 2, 2, 0, 1, 4},
                {2, 3, 1, 1, 9},
                {0},
                {1},
                {4, 3, 2, 1, 0},
                {1, 1, 1, 1, 1},
                {4, 0, 0, 0, 1},
                {3, 3, 3, 3, 3},
                {1, 2, 3, 4, 5, 6, 7}};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(
                    (i + 1) + ".\tInput array: " + Arrays.toString(nums[i]));
            if (jumpGame(nums[i]))
                System.out.println("\tCan we reach the very last index? Yes");
            else
                System.out.println("\tCan we reach the very last index? No");
            System.out.println(repeat("-", 100));
        }
    }
}