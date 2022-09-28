package leetcode.contest;

import java.util.LinkedList;
import java.util.Queue;

public class Second {
    public static int longestContinuousSubstring(String s) {
        int start = 0, maxSize = 1, windowSize = 1;

        for(int end=1; end<s.length(); end++){
            char right = s.charAt(end);
            char left = s.charAt(start++);

            if(right > left){
                windowSize++;
            }else{
                windowSize = 0;
            }
            maxSize = Math.max(maxSize, windowSize);
        }

        return maxSize;

    }

    public static void main(String[] args) {
        System.out.println(longestContinuousSubstring("awy"));
        Queue<Integer> queue =new LinkedList<>();
    }
}
