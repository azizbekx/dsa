package g_algorithms.search_sorting;

public class MergeSorting {
    /*
    Time - O(nlogn)
     */
    public static void merge(int arr[], int left, int mid, int right) {
        int i, j, k;
        //Initializing the sizes of the temporary arrays
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        //Initializing temporary arrays
        int leftArr[] = new int[sizeLeft];
        int rightArr[] = new int[sizeRight];

        //copying the given array into the temporary array
        for (i = 0; i < sizeLeft; i++)
            leftArr[i] = arr[left + 1];
        for (j = 0; j < sizeRight; j++)
            rightArr[j] = arr[mid + 1 + j];
        //Mergin the temporary arrays back into the given array
        i = 0;
        j = 0;
        k = left;
        //This is the main part of the algorithm
        while (i < sizeLeft && j < sizeRight) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        //Copying the reamingni elements of rightArr[], if there are any
        while (j < sizeRight) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < 0 || rightIndex < 0)
            return;
        if (rightIndex > leftIndex) {
            int mid = leftIndex + (rightIndex - leftIndex);

            //Soring the first and second halves of the array
            mergeSort(arr, leftIndex, mid);
            mergeSort(arr, mid + 1, rightIndex);

            //Merging the array
            merge(arr, leftIndex, mid, rightIndex);
        }

    }
    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        mergeSort(arr, 0, arrSize - 1);
   }
}