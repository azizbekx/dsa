package g_algorithms.search_sorting;

public class P2SearchInRotated {
    /*
    Time Complexity - O(logn)
    In case of duplicates (in worst case) it is O(n)
     */
    public static int searchRotatedArray(int[] arr, int left, int right, int n) {
        int mid = (left + right) / 2;

        if (n == arr[mid]) // Element Found
            return mid;

        if (right < left)
            return -1;

        if (arr[left] < arr[mid]) { // The left half of the array is sorted

            if (n >= arr[left] && n < arr[mid]) // If s is between the mid and start values
                return searchRotatedArray(arr, left, mid - 1, n); // Search in the left half
            else
                return searchRotatedArray(arr, mid + 1, right, n);  // Search in the right half

        } else if (arr[mid] < arr[right]) { // The right half of the array is sorted

            if (n > arr[mid] && n <= arr[right]) // If s is between the mid and end values
                return searchRotatedArray(arr, mid + 1, right, n); // Search right
            else
                return searchRotatedArray(arr, left, mid - 1, n); // Search left

        } else if (arr[left] == arr[mid]) { // If the left is all repeats

            if (arr[mid] != arr[right]) // If the right element is not a repeat
                return searchRotatedArray(arr, mid + 1, right, n); // search in the right half
            else { // Otherwise, search both halves

                int result = searchRotatedArray(arr, left, mid - 1, n); // Search in left
                if (result == -1)
                    return searchRotatedArray(arr, mid + 1, right, n); // Search in right
                else
                    return result;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {40, 100, -100, 40, 0, 24, 40};
        System.out.println("The index is: " + searchRotatedArray(arr, 0, 6, -100));
        }
}
