package grokking.coding_pattern.merge_intervals;

import java.util.ArrayList;
import java.util.List;

public class P3IntervalsIntersection {
    /*
    Time - O(N + M) N, M total number of intervals
    Space - O(1)
            if we ignore result list
     */
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        int i=0, j=0;
        while(i<arr1.length && j < arr2.length){
            // check if the interval arr1[i] intersects with arr2[j]
            // check if one of the interval's start time lies within the other interval
            if((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
                || (arr2[j].start >= arr1[j].start && arr2[j].start <= arr1[i].end)){
                int start = Math.max(arr1[i].start, arr2[j].start);
                int end = Math.min(arr1[i].end, arr2[j].end);
                intervalsIntersection.add(new Interval(start, end));
            }
            // move next from the interval which is finishing first
            if (arr1[i].end < arr2[j].end)
                i++;
            else
                j++;
        }
        return intervalsIntersection.toArray(new Interval[0]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
