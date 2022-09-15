package code_trust.data_structures.array;

public class MergeArray {
    public static void main(String[] args) {
        for (int i : mergeArrays(new int[]{1, 3, 4, 5}, new int[]{2, 6, 7, 8})) {
            System.out.println(i);
        }
    }
    // merge arr1 and arr2 into a new result array
    //time - O(n+m)
    public static int[] mergeArrays(int[] arr1, int[] arr2)
    {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[] new_arr = new int[l1+l2];
        int i=0, j=0, k=0;

        while(i != l1 || j != l2){
            if(i != l1 && j != l2 ){
                if(arr1[i] < arr2[j]){
                    new_arr[k++] = arr1[i++];
                }else {
                    new_arr[k++] = arr2[j++];
                }
            }else if(i == l1){
                new_arr[k++] = arr2[j++];
            }else {
                new_arr[k++] = arr1[i++];
            }
        }

        return new_arr; // make a new resultant array and return your results in that
    }
}
