package meta_global_hackaton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1Rollercaseter {
    public static int findMax(int[] arr) {
        if (arr == null)
            return 0;
        int current_answer = 0;
        int best_answer = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                current_answer += 1;
            else
                current_answer = 0;
            best_answer = Math.max(best_answer, current_answer);
        }
        return best_answer * 10;
    }

    public static void main(String[] args) {
        int[] arr = new int[10000];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10000; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findMax(arr));
    }

}
