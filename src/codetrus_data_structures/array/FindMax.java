package codetrus_data_structures.array;

public class FindMax {
    public static int findMaxSumSubArray(int[] arr) {
        int currMax = arr[0];
        int globalMax = arr[0];

        for(int i=1; i<arr.length; i++){
            if(currMax < 0){
                currMax = arr[i];
            }else currMax += arr[i];

            if(globalMax < currMax){
                globalMax = currMax;
            }
        }
        return globalMax;
    }
}
