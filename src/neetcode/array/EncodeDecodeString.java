package neetcode.array;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s.length()).append("#").append(s);
        return sb.toString();
    }
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int j = i;
            while (str.charAt(j) != '#') j++;
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1 + length;
            res.add(str.substring(j + 1, i));
        }
        return res;
    }
}
