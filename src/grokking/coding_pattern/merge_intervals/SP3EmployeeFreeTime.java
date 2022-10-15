package grokking.coding_pattern.merge_intervals;

import java.util.*;


public class SP3EmployeeFreeTime {
    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        // PriorityQueue to store one interval from each employee
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(Comparator.comparing(e -> e.interval.start));

        for(int i=0; i<schedule.size(); i++)
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        Interval previousInterval = minHeap.peek().interval;
        while(!minHeap.isEmpty()){
            EmployeeInterval queueTop = minHeap.poll();
            // if previous Interval is not overlapping with next interval, insert a free interval
            if (previousInterval.end < queueTop.interval.start) {
                result.add(new Interval(previousInterval.end, queueTop.interval.start));
                previousInterval = queueTop.interval;
            // overlapping interval, update the previousInterval if needed
            }else{
                if (previousInterval.end < queueTop.interval.end)
                    previousInterval = queueTop.interval;
            }
            // if there are more intervals avaliable for the same employee, add their next interval
            List<Interval> employeeSchedule = schedule.get(queueTop.employeeIndex);
            if (employeeSchedule.size() > queueTop.intervalIndex + 1)
                minHeap.offer(new EmployeeInterval(employeeSchedule.get(queueTop.intervalIndex + 1),
                        queueTop.employeeIndex, queueTop.intervalIndex + 1));
        }
        return result;
    }
    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(List.of(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(List.of(new Interval(6, 8))));
        result = findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
class EmployeeInterval {
    Interval interval; // interval representing employee's working hours
    int employeeIndex; // index of the list containing working hours of this employee
    int intervalIndex; // index of the interval in the employee list

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
}