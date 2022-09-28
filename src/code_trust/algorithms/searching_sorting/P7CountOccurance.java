package code_trust.algorithms.searching_sorting;

public class P7CountOccurance {
    public static int calcFreq(int arr[], int key) {
        // Finding the index of the first occurance
        int arrSize = arr.length;
        int start = 0, end = arrSize - 1, mid, result = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key) {
                result = mid;
                end = mid - 1;
            } else if (arr[mid] > key)
                end = mid - 1;
            else if (arr[mid] < key)
                start = mid + 1;
        }
        int start1 = 0, end1 = arrSize - 1, mid1, result1 = -1;
        while (start1 <= end1) {
            mid1 = (start1 + end1) / 2;
            if (arr[mid1] == key) {
                result1 = mid1;
                start1 = mid1 + 1;
            } else if (arr[mid1] > key)
                end1 = mid1 - 1;
            else if (arr[mid1] < key)
                start1 = mid1 + 1;
        }
        //If one of them is not found, return theriiiir difference
        if (result == -1 || result1 == -1)
            return (result1 - result);
        return result1 - result + 1;
    }

    public static void main(String args[]) {
        int arr[] = {-5, -3, 0, 1, 3, 3, 3, 3, 4, 5};
        int key = 3;
        System.out.println("The key \"" + key + "\" occurs " + calcFreq(arr, key) + " times in the Array.");
    }
}
