package code_trust.data_structures.HashTable.challenge;

import java.util.HashMap;
import java.util.Map;

public class Challenge4_Trace_Path {

    public static String tracePath(Map<String, String> map) {


        String result = "";
        String first = "";
        String second = "";
        for (Map.Entry<String, String> set : map.entrySet()) {
            // String tempFirst = set.getKey();
            // String tempSecond = set.getValue();
            // if(first != tempSecond){
            //   first = temp;
            // }
            if (!map.containsValue(set.getKey())) {
                first = set.getKey();
                second = set.getValue();

                result += first + "->" + second + ", ";

            }
        }
        while (first != null && map.containsKey(second)) {
            result += second + "->" + map.get(second) + ", ";
            first = second;
            second = map.get(second);
        }

        return result;
    }

    public static String tracePathO(Map<String, String> map) {
        String result = "";
        //Create a reverse Map of given map i.e if given map has (N,C) then reverse map will have (C,N) as key value pair
        //Traverse original map and see if corresponding key exist in reverse Map
        //If it doesn't exist then we found our starting point.
        //After starting point is found, simply trace the complete path from original map.
        HashMap<String, String> reverseMap = new HashMap<>();
        //To fill reverse map, iterate through the given map
        for (Map.Entry<String, String> entry : map.entrySet())
            reverseMap.put(entry.getValue(), entry.getKey());
        //Find the starting point of itinerary
        String from = "";
        //Check if graph is disconnected
        int count = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                count++;
                from = entry.getKey();
                //break;
            }
        }
        if (count > 1) {
            return "null"; // Disconnected graph
        }
        //Trace complete path
        String to = map.get(from);
        while (to != null) {
            result += from + "->" + to + ", ";
            from = to;
            to = map.get(to);
        }
        //System.out.println(result);
        return result;
    }
}
