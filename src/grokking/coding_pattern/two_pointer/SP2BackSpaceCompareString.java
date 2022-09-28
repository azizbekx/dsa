package grokking.coding_pattern.two_pointer;

public class SP2BackSpaceCompareString {
    public static boolean compare(String str1, String str2) {
        // using two pointer approach to compare the strings
        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while(index1 >= 0 || index2 >= 0){
            int i1 = getNextValidCharacter(str1, index1);
            int i2 = getNextValidCharacter(str2, index2);
            // reached the end of both the string
            if (i1 <0 && i2 <0)
                return true;
            // reached the end of one of the string
            if (i1 < 0 || i2 < 0)
                return false;
            // check if the characters are equal
            if (str1.charAt(i1) != str2.charAt(i2))
                return false;
            index1 = i1 - 1;
            index2 = i2 - 1;
        }
        return true;
    }

    private static int getNextValidCharacter(String str, int index) {
        int backspaceCount = 0;
        while(index >= 0){
            if (str.charAt(index) == '#') // found a backspace character
                backspaceCount++;
            else if (backspaceCount >0) // a non-backspace character
                backspaceCount--;
            else
                break;
            index--; //skip a backspace or a valid character
        }
        return index;
    }
    public static void main(String[] args) {
        System.out.println(compare("xy#z", "xzz#"));
        System.out.println(compare("xy#z", "xyz#"));
        System.out.println(compare("xp#", "xyz##"));
        System.out.println(compare("xywrrmp", "xywrrmu#p"));
    }
}
