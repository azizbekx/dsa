package grokking.coding_pattern.merge_intervals;

import java.util.Arrays;
import java.util.Comparator;

public class P4ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        for (int i=1; i<intervals.length; i++){
            if (intervals[i].start <= intervals[i-1].end)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
