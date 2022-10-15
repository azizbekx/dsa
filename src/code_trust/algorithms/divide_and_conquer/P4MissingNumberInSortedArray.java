package code_trust.algorithms.divide_and_conquer;

public class P4MissingNumberInSortedArray {
    /*
    Time - O(logN) N -> number of elements in array
     */
    // Performing a binary search like technique to find the missing number in the array
    public static int missingNumber(int arr[], int size) {
        int leftLimit = 0, rightLimit = size - 1;
        if (arr[leftLimit] != 1)
            return 1;
        // binary search
        while (leftLimit <= rightLimit) {
            int middle = (leftLimit + rightLimit) / 2;
            // element at index 'i' should be 'i+1' (e.g 1 at index 0)
            // if this is the first element which is not 'i + 1', then missing element is middle + 1
            if (arr[middle] != middle + 1 && arr[middle - 1] == middle)
                return middle + 1;
            // if this is not the first missing element search in left subarray
            if (arr[middle] != middle + 1)
                // update rightLimit to search only left
                rightLimit = middle - 1;
                // if it follows index + 1 property then search in right side
            else
                // update leftLimit to search only
                leftLimit = middle + 1;
        }
        // if no element missing
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1, 2, 3, 5, 6}, 5));
    }
}


