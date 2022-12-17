package adventofcode.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day4Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner f = new Scanner(new File("src/adventofcode/Day4/input.txt"));

        int ans = 0;
        int cur = 0;
        while (f.hasNext()) {
            String[] intervals = f.nextLine().split(",");
            System.out.println(Arrays.toString(intervals));
            String[] one = intervals[0].split("-");
            String[] two = intervals[1].split("-");
            int oneStart = Integer.parseInt(one[0]);
            int oneEnd = Integer.parseInt(one[1]);
            int twoStart = Integer.parseInt(two[0]);
            int twoEnd = Integer.parseInt(two[1]);

            if (Math.max(oneStart, twoStart) <= Math.min(oneEnd, twoEnd)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
