package grokking.coding_pattern.merge_intervals;

import java.util.*;

public class P1MergeIntervals {
    /*
    Time - O(N * logN)
            we are iterating algorithms only O(n)
            in the beginning though, since we need to sort O(N * LogN)
    Space - O(N)
            sorting algorithms usually take O(N)
     */
    public static List<Interval> merge(List<Interval> intervals){
        if (intervals.size() < 2)
            return intervals;
        // sort the intervals by start time
        intervals.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> mergedIntervals = new LinkedList<>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalItr.hasNext()){
            interval = intervalItr.next();
            // overlapping intervals, adjust the 'end'
            if (interval.start <= end)
                end = Math.max(interval.end, end);
            // non-overlapping interval, add the previous interval and reset
            else{
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // add the last interval
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
