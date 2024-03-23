package leetcode.Y2023.january;

public class D10TwoSumII {
    public int[] twoSumO(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                if (numbers[mid] + numbers[j] < target) {
                    i = mid + 1;
                } else {
                    i++;
                }
            } else {
                if (numbers[mid] + numbers[i] > target) {
                    j = mid - 1;
                } else {
                    j--;
                }
            }
        }
        return new int[]{i + 1, j + 1};
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            else if (sum > target) r--;
            else l++;
        }
        return res;
    }
}
