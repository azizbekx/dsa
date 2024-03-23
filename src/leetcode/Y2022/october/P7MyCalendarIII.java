package leetcode.Y2022.october;

import java.util.TreeMap;

public class P7MyCalendarIII {
    class MyCalendarThree {
        /*
        Balanced tree
        */
        private TreeMap<Integer, Integer> starts;
        private int res;

        public MyCalendarThree(){
            starts = new TreeMap<>();
            starts.put(0, 0);
            res = 0;
        }
        public void split(int x){
            Integer prev = starts.floorKey(x);
            Integer next = starts.ceilingKey(x);
            if(next != null && next == x)
                return;
            starts.put(x, starts.get(prev));
        }
        public int book(int start, int end){
            split(start);
            split(end);
            for(var interval : starts.subMap(start, true, end, false).entrySet()){
                res = Math.max(res, interval.setValue(interval.getValue() + 1) + 1);
            }
            return res;
        }
    }

    /*
    Approach 1 - Sweep-Line Algorithm

    private Map<Integer, Integer> diff;

    public P7MyCalendarIII() {
        diff = new TreeMap<>();
    }
    public int book(int start, int end){
        diff.put(start, diff.getOrDefault(start, 0) + 1);
        diff.put(end, diff.getOrDefault(end, 0) - 1);
        int res = 0, curr = 0;
        for(int delta : diff.values()){
            curr += delta;
            res = Math.max(res, curr);
        }
        return res;
    }
     */

     /*
    Approach 2 - Segment Tree
    Time - O(NlogC)
    Space - O(NlogC)
    class MyCalendarThree {
    private Map<Integer, Integer> vals;
    private Map<Integer, Integer> lazy;

    public MyCalendarThree(){
        vals = new HashMap<>();
        lazy = new HashMap<>();
    }
    public void update(int start, int end, int left, int right, int idx){
        if(start > right || end < left)
            return;
        if(start <= left && right <= end){
            vals.put(idx, vals.getOrDefault(idx, 0) + 1);
            lazy.put(idx, lazy.getOrDefault(idx, 0) + 1);
        }else {
            int mid = (left + right) / 2;
            update(start, end, left, mid, idx * 2);
            update(start, end, mid + 1, right, idx * 2 + 1);
            vals.put(idx, lazy.getOrDefault(idx, 0)
                    +Math.max(vals.getOrDefault(idx * 2, 0),
                    vals.getOrDefault(idx * 2 + 1, 0)));
        }
    }
    public int book(int start, int end){
        update(start, end - 1, 0, 1000000000, 1);
        return vals.getOrDefault(1,0);
    }
      */
    /*
    Approach 3  - Balanced Tree
     */

}


/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
