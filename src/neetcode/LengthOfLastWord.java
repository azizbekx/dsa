package neetcode;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
            int length = 0;
        for(int i = s.length() - 1; i>= 0; i++){
            if(s.charAt(i) != ' ')
                length++;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("ab"));
    }
}
