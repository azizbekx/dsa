package grokking.coding_pattern.fast_and_slow_pointers;

public class SP3CycleInACircularArray {
    public static boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // if we are moving forward or not
            boolean isForward = arr[i] >= 0;
            int slow = i, fast = i;

            // if slow or fast becomes '-1' this means we can't find cycle for this number
            do {
                // move on step for slow pointer
                slow = findNextIndex(arr, isForward, slow);
                // move one step for fast pointer
                fast = findNextIndex(arr, isForward, fast);
                if (fast != -1)
                    // move another step for fast pointer
                    fast = findNextIndex(arr, isForward, fast);
            } while (slow != -1 && fast != -1 && slow != fast);

            if(slow != -1 && slow == fast)
                return true;
        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction)
            // change in direction, return -1
            return -1;
        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
        if (nextIndex < 0)
            // wrap around for negative numbers
            nextIndex += arr.length;

        // one element cycle, return -1
        if (nextIndex == currentIndex)
            nextIndex = -1;

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(loopExists(new int[]{1, 2, -1, 2, 2}));
        System.out.println(loopExists(new int[]{2, 2, -1, 2}));
        System.out.println(loopExists(new int[]{2, 1, -1, -2}));
    }
}
