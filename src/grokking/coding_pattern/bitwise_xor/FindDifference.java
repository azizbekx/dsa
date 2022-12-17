package grokking.coding_pattern.bitwise_xor;

public class FindDifference {
    /*
    Time - O(n)
    Space - O(1)
     */
    public static int extraCharcterIndex(String str1, String str2) {
        int result = 0;

        for (int i = 0; i < str1.length(); i++)
            result ^= str1.charAt(i);

        for (int i = 0; i < str2.length(); i++)
            result ^= str2.charAt(i);

        String maxStr = str1.length() > str2.length() ? str1 : str2;
        return maxStr.indexOf((char) result);
    }

    public static void main(String[] args) {
        // Driver code
        // Example - 1
        String[] string1 = {"wxyz", "cbda", "jlkmn", "courae", "", "xyz", "hello"};
        String[] string2 = {"zwxgy", "abc", "klmn", "couearg", "", "xyz", "helo"};
        for (int i = 0; i < string1.length; i++) {
            System.out.println(i + 1 + ".\tString1 = " + string1[i] + " \n\tString2 = " + string2[i]);
            System.out.println("at index " + extraCharcterIndex(string1[i], string2[i]));
//            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
