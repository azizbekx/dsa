package leetcode.Y2023.january;

import java.util.Arrays;
import java.util.Comparator;

public class D4MinimumNumberOfArrows {
    public int findMinArrowShotsO1(int[][] segments) {
        Arrays.sort(segments, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int arrow = 0;
        for (int[] segment : segments) {
            if (ans == 0 || segment[0] > arrow) {
                ans++;
                arrow = segment[1];
            }
        }
        return ans;
    }
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int count = 0; // result
        // minEnd: Key parameter 'active set' for overlapping intervals
        // e.g. the minium ending point among all overlapping intervals
        int minEnd = Integer.MAX_VALUE;
        // sorting the intervals/pairs in ascending order of its starting point
        Arrays.sort(points, (a, b) -> (a[0] - b[0]));
        for (int[] in : points){
            // if the changing some states, record some information, and start a new active set 'new arrow'
            if (in[0] > minEnd){
                count++;
                minEnd = in[1];
            }else{
                // renew key parameters of the active set
                minEnd = Math.min(minEnd, in[1]);
            }
        }
        return count + 1;
    }
}
