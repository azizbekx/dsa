package adventofcode.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner f = new Scanner(new File("src/adventofcode/Day3/input.txt"));

        int ans = 0;
        int cur = 0;
        while (f.hasNext()) {
            String s = f.nextLine();
            String str1 = s.substring(0, s.length() / 2);
            String str2 = s.substring(s.length() / 2);
            List<Character> s1 = new ArrayList<>();
            List<Character> s2 = new ArrayList<>();
            for (int i = 0; i < str1.length(); i++) {
                s1.add(str1.charAt(i));
            }
            for (int i = 0; i < str2.length(); i++) {
                s2.add(str2.charAt(i));
            }
            // Finding intersection of both lists
            s1.retainAll(s2);
            char c = s1.get(0);

            ans += Character.isUpperCase(c) ? c - 'A' + 27 : c - 'a' + 1;
            System.out.println(ans);
        }
        System.out.println(ans);
    }
}