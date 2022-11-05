package grokking.coding_pattern.modified_binary_search;

public class NumberRange {
    /*
    Time - O(logN)
    Space - O(1)
     */
    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        result[0] = search(arr, key, false);
        if(result[0] != -1)
            result[1] = search(arr, key, true);
        return result;
    }

    // modified binary search
    private static int search(int[] arr, int key, boolean findMaxIndex) {
        int keyIndex = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > key)
                end = mid - 1;
            else if (arr[mid] < key)
                start = mid + 1;
            else {
                keyIndex = mid;
                if(findMaxIndex)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return keyIndex;
    }

    public static void main(String[] args) {
        int[] result = findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
