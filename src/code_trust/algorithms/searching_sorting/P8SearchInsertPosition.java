package code_trust.algorithms.searching_sorting;

public class P8SearchInsertPosition {
    public static int insertPositionO(int arr[], int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0, pos=0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target == arr[mid])
                return mid;
            else if (target > arr[mid]) {
                l = mid + 1;
                pos = mid + 1;
            } else {
                r = mid - 1;
                pos = mid;
            }
        }

        return pos;
    }

    public static int insertPosition(int arr[], int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target == arr[mid])
                return mid;
            else if (target > arr[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return target > arr[mid] ? mid + 1 : mid;
    }

    public static void main(String[] args) {
        System.out.println(insertPosition(new int[]{1, 3, 5, 6}, 4));
    }
}
