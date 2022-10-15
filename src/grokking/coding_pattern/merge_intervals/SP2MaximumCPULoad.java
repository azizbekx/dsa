package grokking.coding_pattern.merge_intervals;

import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};


public class SP2MaximumCPULoad {
    /*
    N - Total number of jobs
    Time - O(NLogN)
    Space - O(N) -> required for sorting
     */

    public static int findMaxCPULoad(List<Job> jobs) {

        jobs.sort(Comparator.comparingInt(a -> a.start));

        int maxCPULoad = 0;
        int currentCPULoad = 0;

        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), Comparator.comparingInt(a -> a.end));

        for(Job job : jobs){
            while(!minHeap.isEmpty() && job.start > minHeap.peek().end)
                currentCPULoad -= minHeap.poll().cpuLoad;

            minHeap.offer(job);
            currentCPULoad += job.cpuLoad;
            maxCPULoad = Math.max(currentCPULoad, maxCPULoad);
        }
        return maxCPULoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + findMaxCPULoad(input));
    }
}
