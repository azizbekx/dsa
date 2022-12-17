package adventofcode.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
         * --- Day 5: Supply Stacks ---

The expedition can depart as soon as the final supplies have been unloaded from the ships. Supplies are stored in stacks of marked crates, but because the needed supplies are buried under many other crates, the crates need to be rearranged.

The ship has a giant cargo crane capable of moving crates between stacks. To ensure none of the crates get crushed or fall over, the crane operator will rearrange them in a series of carefully-planned steps. After the crates are rearranged, the desired crates will be at the top of each stack.

The Elves don't want to interrupt the crane operator during this delicate procedure, but they forgot to ask her which crate will end up where, and they want to be ready to unload them as soon as possible so they can embark.

They do, however, have a drawing of the starting stacks of crates and the rearrangement procedure (your puzzle input). For example:

    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2

In this example, there are three stacks of crates. Stack 1 contains two crates: crate Z is on the bottom, and crate N is on top. Stack 2 contains three crates; from bottom to top, they are crates M, C, and D. Finally, stack 3 contains a single crate, P.

Then, the rearrangement procedure is given. In each step of the procedure, a quantity of crates is moved from one stack to a different stack. In the first step of the above rearrangement procedure, one crate is moved from stack 2 to stack 1, resulting in this configuration:

[D]        
[N] [C]    
[Z] [M] [P]
 1   2   3 

In the second step, three crates are moved from stack 1 to stack 3. Crates are moved one at a time, so the first crate to be moved (D) ends up below the second and third crates:

        [Z]
        [N]
    [C] [D]
    [M] [P]
 1   2   3

Then, both crates are moved from stack 2 to stack 1. Again, because crates are moved one at a time, crate C ends up below crate M:

        [Z]
        [N]
[M]     [D]
[C]     [P]
 1   2   3

Finally, one crate is moved from stack 1 to stack 2:

        [Z]
        [N]
        [D]
[C] [M] [P]
 1   2   3

The Elves just need to know which crate will end up on top of each stack; in this example, the top crates are C in stack 1, M in stack 2, and Z in stack 3, so you should combine these together and give the Elves the message CMZ.

After the rearrangement procedure completes, what crate ends up on top of each stack?

         */
        Scanner f = new Scanner(new File("src/adventofcode/Day5/input.txt"));

        int ans = 0;
        int cur = 0;
        List<Stack<Character>> stackList = new ArrayList<>(
//                Arrays.asList(new Stack[]{new Stack('N','C')})
        );
        String s = f.nextLine();
        generate(stackList, s.length());
        put(stackList, s);
        while (f.hasNext()) {
            String str = f.nextLine();
            if (str.length() == 11)
                put(stackList, str);
            if (str.length() == 0)
//                reverse(list);
            if (str.length() == 18)
                move(stackList, str);
        }
        for (Stack<Character> characters : stackList) {
            if (!characters.isEmpty())
                System.out.println(characters.peek());
        }
    }
    private static void reverse(List<Stack<Character>> list){
        for (Stack<Character> characters : list) {
            while (!characters.isEmpty())
                characters.push(characters.pop());
        }
    }
    private static void put(List<Stack<Character>> list, String s) {
        int n = s.length();
        int step = 1;
        for (int i = 1; i < s.length(); i = i + 4) {
            if (s.charAt(i) != ' ' && !Character.isDigit(s.charAt(i)))
                list.get(step).push(s.charAt(i));
            step++;
        }
    }

    private static void generate(List<Stack<Character>> list, int len) {
        while (len-- >= 0) {
            list.add(new Stack<>());
        }
    }

    private static void move(List<Stack<Character>> list, String moveStr) {
        int move = Integer.parseInt(String.valueOf(moveStr.charAt(5)));
        int from = Integer.parseInt(String.valueOf(moveStr.charAt(12)));
        int to = Integer.parseInt(String.valueOf(moveStr.charAt(17)));

        while (move-- > 0) {
            list.get(to).push(list.get(from).pop());
        }
    }

}
