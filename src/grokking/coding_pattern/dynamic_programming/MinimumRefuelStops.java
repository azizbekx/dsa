package grokking.coding_pattern.dynamic_programming;

import java.util.Arrays;

public class MinimumRefuelStops {
    /*
    Time - O(n^2)
    Space - O(n)
     */
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        // maxDistance[i] := farthest position we can reach w/ i refuels
        long[] maxDistance = new long[stations.length + 1];
        maxDistance[0] = startFuel;
        System.out.println("\tInitialized array :" + Arrays.toString(maxDistance));

        // We'll iterate over all the stations
        // At each station we need to define that what is the maximum distance
        // we can cover using the current station as a refueling station.
        for (int i = 0; i < stations.length; ++i)
            for (int j = i + 1; j > 0; --j)
                if (maxDistance[j - 1] >= stations[i][0]) { // with j - 1 refuels, we can reach stations[i][0]
                    // We'll find max fuel among all available traversed stations
                    maxDistance[j] = Math.max(maxDistance[j], maxDistance[j - 1] + stations[i][1]);
                    System.out.println("\tUpdated array at station" + Arrays.toString(stations[i]) + ":" + Arrays.toString(maxDistance));
                }
        for (int i = 0; i < maxDistance.length; ++i)
            // Return minimum number of stations required to reach the target
            if (maxDistance[i] >= target)
                return i;

        return -1;
    }
    public static void main(String[] args) {
        int[] target = {120, 15, 570, 1360};
        int[] startFuel = {10, 3, 140, 380};
        int[][][] stations = {
                {{10, 60},{20, 25},{30, 30},{60, 40}},
                {{2, 5},{3, 1},{6, 3},{12,6 }},
                {{140, 200}, {160, 130}, {310, 200}, {330, 250}},
                {{310, 160}, {380, 620}, {700, 89}, {850, 190}, {990, 360}}
        };
        for(int i=0;i<target.length;i++){
            System.out.print(i+1);
            System.out.println(".\tStations: "+Arrays.deepToString(stations[i]));
            System.out.println("\tTarget fuel: "+target[i]);
            System.out.println("\tStart fuel: "+startFuel[i]);
            System.out.println("\tMinimum number of Refueling stops: "+minRefuelStops(target[i], startFuel[i],stations[i]));
//            System.out.println(PrintHyphens.repeat("-", 100));
        }

    }
}
