package code_trust.data_structures.array;

public class MaxMin {
    /*
    space - O(n)
    time - O(n)
     */
    public static void maxMinO(int[] arr){
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1;

        for (int i=0; i<arr.length; i++){
            if (i % 2 == 0){
                arr[i] += (arr[maxIdx] % maxElem) * maxElem;
                maxIdx --;
            }else {
                arr[i] += (arr[minIdx] % maxElem) * maxElem;
                minIdx++;
            }
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i]/maxElem;
        }
    }
    public static void maxMin(int[] arr) {

        int n = arr.length;
        int right = n-1;
        int left = 0;

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            if(i % 2 != 0){
                ans[i] = arr[left++];
            }else ans[i] = arr[right--];
        }
        System.arraycopy(ans, 0, arr, 0, n);
    }
}
