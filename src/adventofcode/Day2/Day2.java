package adventofcode.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/adventofcode/Day2/input.txt"));

        int ans = 0;
        int cur = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] strArr = line.split(" ");

            if (Objects.equals(strArr[1], "X"))
                ans += 1;
            else if (Objects.equals(strArr[1], "Y"))
                ans += 2;
            else if (Objects.equals(strArr[1], "Z"))
                ans += 3;

            System.out.println(ans);
            if (Objects.equals(strArr[0], "A")) {
                if (Objects.equals(strArr[1], "X"))
                    ans += 3;
                else if (Objects.equals(strArr[1], "Y"))
                    ans += 6;
            } else if (Objects.equals(strArr[0], "B")) {
                if (Objects.equals(strArr[1], "Y"))
                    ans += 3;
                else if (Objects.equals(strArr[1], "Z"))
                    ans += 6;
            } else if (Objects.equals(strArr[0], "C")){
                if (Objects.equals(strArr[1], "X"))
                    ans += 6;
                else if (Objects.equals(strArr[1], "Z"))
                    ans += 3;
            }
            System.out.println(ans);
        }
        System.out.println(ans);

    }
}
