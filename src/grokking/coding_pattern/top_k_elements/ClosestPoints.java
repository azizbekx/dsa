package grokking.coding_pattern.top_k_elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestPoints {
    /*
    K - is number of points closest to the origin
    N - is the number of points provided as input
    Time - O(NlogK)
    Space - O(K)
     */
    public static List<Point> kClosestO(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(
                (p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());
        // put the first 'k' points the max heap
        maxHeap.addAll(Arrays.asList(points).subList(0, k));

        for (Point point : points) {
            if (point.distFromOrigin() < maxHeap.peek().distFromOrigin()) {
                maxHeap.poll();
                maxHeap.add(point);
            }
        }

        return new ArrayList<>(maxHeap);
    }
    public static List<Point> kClosest(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());

        for (Point p : points)
            maxHeap.offer(p);

        int removedPoint = maxHeap.size() - k;
        while (removedPoint-- > 0)
            maxHeap.poll();

        return new ArrayList<>(maxHeap);
    }
}
