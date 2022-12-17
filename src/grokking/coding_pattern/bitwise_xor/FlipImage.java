package grokking.coding_pattern.bitwise_xor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlipImage {
    public static int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            int n = image[0].length;
            for (int j = 0; j < n / 2; j++) {
                int t = image[i][j];
                image[i][j] = image[i][n - j - 1];
                image[i][n - j - 1] = t;
            }
            for (int j = 0; j < n; j++)
                image[i][j] = image[i][j] ^ 1;

        }
        return image;
    }
}

