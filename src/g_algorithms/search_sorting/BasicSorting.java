package g_algorithms.search_sorting;

public class BasicSorting {
    /*
    Time - O(n^2)
    avarage-case - Omega(n)
    Space - O(1)
     */
    public static void insertionSort(int[] arr, int arrSize){
        int ele, j;
        for (int i = 0; i < arrSize; i++) {
            ele = arr[i];
            j=i-1;
            while(j >= 0 && arr[j] > ele){
                arr[j+1] = arr[j];
                j=j-1;
            }
            arr[j+1] = ele;
        }
    }
    /*
    Time - O(n^2)
     */
    public static void bubbleSort(int[] arr, int arrSize){
        int i, j, temp;
        for (i = 0; i < arrSize - 1; i++) {
            for (j = 0; j < arrSize - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    /*
    Time - O(n^2)
     */
    public static void selectionSort(int[] arr, int arrSize){
        int minInd;
        for (int i = 0; i < arrSize; i++) {
            minInd = findMin(arr, i, arrSize - 1);
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }
    }
    static int findMin(int[] arr, int start, int end) {
        if (end <= 0 || start < 0)
            return 0;

        int minInd = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[minInd] > arr[i])
                minInd = i;
        }
        return minInd;
    }

    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        bubbleSort(arr, arrSize);
//        selectionSort(arr, arrSize);
    }
}
