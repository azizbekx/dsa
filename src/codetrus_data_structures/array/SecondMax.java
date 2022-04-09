package codetrus_data_structures.array;

public class SecondMax {
    public static int findSecondMaximum(int[] arr){
        int first_max = Integer.MIN_VALUE;
        int second_max = Integer.MAX_VALUE;

        for (int j : arr) {
            if (j > first_max) {
                second_max = first_max;
                first_max = j;
            } else if (j > second_max && j != first_max) {
                second_max = j;
            }
        }
        return second_max;
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

        int[] arr = {-2, -33, -10, -456};

        System.out.println("Array: " + arrayToString(arr));

        int secMax = findSecondMaximum(arr);

        System.out.println("Second maximum: " + secMax);

    }
}
