package neetcode.two_pointer;

public class ValidPalindrome {
    public boolean isPalindromeO(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))){
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(r))){
                r--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l++) != str.charAt(r--))
                return false;
        }
        return true;
    }
}
