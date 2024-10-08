package code_trust.data_structures.array;

public class ProductArray {
    public static int[] findProduct(int[] arr) {
        int n = arr.length;
        int i, temp = 1;

        // Allocation of result array
        int[] result = new int[n];

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++) {
            result[i] = temp;
            temp *= arr[i];
        }

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }

    public static String arrayToString(int[] arr) {
        if (arr.length > 0) {
            StringBuilder result = new StringBuilder();
            for (int j : arr) {
                result.append(j).append(" ");
            }
            return result.toString();
        } else {
            return "Empty Array!";
        }
    }

    public static void main(String[] args) {

        int[] arr = {0,2,3,4};

        System.out.println("Array before product: " + arrayToString(arr));

        int[] prodArray = findProduct(arr);

        System.out.println("Array after product: " + arrayToString(prodArray));
    }
}
