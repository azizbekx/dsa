package code_trust.algorithms.searching_sorting;

public class SearchInSortedMatrix {
    public static Object findKeyBF(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
        for (int i = 0; i < numberOfColumns; i++) {
            for (int j = 0; j < numberOfRows; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    public static Object findKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
        int leftCol = 0;
        int rightCol = numberOfColumns;
        int midCol = 0;
        while (leftCol <= rightCol) {
            midCol = (leftCol + rightCol) / 2;
            if (target == matrix[midCol][0])
                return true;
            if (target > matrix[midCol][0])
                leftCol = midCol + 1;
            else
                rightCol = midCol - 1;
        }
        int leftRow = 0;
        int rightRow = numberOfRows;
        int midRow = 0;
        while (leftRow <= rightRow) {
            midRow = (leftRow + rightRow) / 2;
            if (target == matrix[midCol][midRow])
                return true;
            if (target > matrix[midCol][midRow])
                leftRow = midRow + 1;
            else
                rightRow = midRow - 1;
        }
        // write your code here
        return -1;
    }

    public static void main(String args[]) {
        int[][] matrix = {
                {10, 11, 12, 13},
                {14, 15, 16, 17},
                {27, 29, 30, 31},
                {32, 33, 39, 50}
        };
        // Example 1
        Object x = findKey(matrix, 4, 4, 80);
        System.out.println("Search for 80 returned: " + x);

        // Example 2
        x = findKey(matrix, 4, 4, 15);
        System.out.println("Search for 15 returned: " + x);
    }
}
