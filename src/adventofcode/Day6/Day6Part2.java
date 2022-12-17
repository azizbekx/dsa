package adventofcode.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day6Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner f = new Scanner(new File("src/adventofcode/Day6/input.txt"));

        int ans = 0;
        int cur = 0;
        int step = 0;
        int size = 4;
        int length = 14;
        int index = 0;
        String s = f.nextLine();
        String curr = s.substring(0, length);
        Set<Character> chars = new HashSet<>();
        for(char c : curr.toCharArray())
            chars.add(c);
        while (hasDups(curr, length)) {
            index++;
            curr = s.substring(index, index + length);
        }
        System.out.println(length + index);
    }
    public static boolean hasDups(String curr, int exp)
    {
        Set<Character> chars = new HashSet<>();
        for(char c : curr.toCharArray())
            chars.add(c);
        return chars.size() != exp;
    }
}
