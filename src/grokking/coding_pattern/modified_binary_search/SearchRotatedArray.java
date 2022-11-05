package grokking.coding_pattern.modified_binary_search;

public class SearchRotatedArray {
    public static int searchO(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start);
            if (arr[mid] == key)
                return mid;
            // left side is sorted
            if (arr[start] <= arr[mid]){
                if (key >= arr[start] && key < arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;

            } else { // right side is sorted
                if (key > arr[mid] && key <= arr[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static int search(int[] arr, int key) {
        int maxIndex = findMax(arr);
        int keyIndex = binarSearch(arr, key, 0, maxIndex);
        if (keyIndex != -1)
            return keyIndex;

        return binarSearch(arr, key, maxIndex + 1, arr.length - 1);
    }
    private static int findMax(int[] arr){
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[start] > arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        // at the end of the loop end with 'start == end'
        return start;
    }

    private static int binarSearch(int[] arr, int key, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > key)
                end = mid - 1;
            else if (arr[mid] < key)
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(SearchRotatedArray.searchO(new int[]{10, 15, 1, 3, 8}, 15));
        System.out.println(SearchRotatedArray.searchO(new int[]{4, 5, 7, 9, 10, -1, 2}, 10));
    }
}
