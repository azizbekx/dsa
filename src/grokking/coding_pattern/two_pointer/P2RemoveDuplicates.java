package grokking.coding_pattern.two_pointer;

public class P2RemoveDuplicates {
    /*
    Time  - O(n)
    Space - O(1)
     */
    public static int remove(int[] arr) {
        if (arr.length <= 1) return 1;
        int first = 0, second = 1;
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[first++] != arr[second++])
                count++;
        }
        return ++count;
    }

    /*
    Time  - O(n)
    Space - O(1)
     */
    public static int removeO(int[] arr) {
        int nextNonDuplicate = 1; //index of the next non-duplicate element
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;

    }

    /*
    Time - O(n) n -> total number of elements given arr
    Space - (1)
     */
    public static int remove(int[] arr, int key) {
        int nextElement = 0;
        for(int i=0; i<arr.length; i++){
            if (arr[i] != key){
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }
        return nextElement;
    }

}
