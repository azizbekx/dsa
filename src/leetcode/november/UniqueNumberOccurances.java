package leetcode.november;

class UniqueNumberOccurances {
    public boolean uniqueOccurrences(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int[] frequency1 = new int[max - min + 1];
        int[] frequency2 = new int[arr.length + 1];

        for (int num : arr)
            frequency1[num - min]++;

        for (int num : frequency1){
            if (num > 0){
                if (frequency2[num] > 0) return false;
                frequency2[num]++;
            }
        }
        return true;
    }
    /*
    public boolean uniqueOccurrences(int[] arr) {
      Map<Integer, Integer> map = new HashMap<>();
      Set<Integer> set = new HashSet<>();
      
      for (int i = 0; i < arr.length; i++){
        int freq = map.getOrDefault(arr[i], 0) + 1;
        map.put(arr[i], freq);
      }
      for (Map.Entry<Integer, Integer> entry: map.entrySet()){
        if (set.contains(entry.getValue()))
          return false;
        set.add(entry.getValue());    
      }
      return true;
       
    }
    */
}