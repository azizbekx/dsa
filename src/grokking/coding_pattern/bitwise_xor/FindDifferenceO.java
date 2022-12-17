package grokking.coding_pattern.bitwise_xor;

public class FindDifferenceO {
    public static String printStringWithMarkers(String strn, int pValue) {
        String out = "";
        for (int i = 0; i < pValue; i++) {
            out += String.valueOf(strn.charAt(i));
        }
        out += "«";
        out += String.valueOf(strn.charAt(pValue)) + "»";
        for (int i = pValue + 1; i < strn.length(); i++) {
            out += String.valueOf(strn.charAt(i));
        }
        return out;
    }

    public static int extraCharcterIndex(String firstString, String secondString) {
        // Initialize the result variable to store the result
        int result = 0;
        int index = 0;
        // Store the length of firstString in firstString_length variable
        int firstStringLength = firstString.length();
        // Store length of secondString in secondString_length variable
        int secondStringLength = secondString.length();
        if (firstStringLength == secondStringLength) return -1;
        // Traverse the string 1 till the end and perform xor with the result
        System.out.println("\n\tTraversing the first string");
        for (int i = 0; i < firstStringLength; i++) {
            System.out.println("\t\t" + printStringWithMarkers(firstString, i));
            System.out.println("\t\tCurrent character: " + firstString.charAt(i));
            System.out.println("\t\tresult: " + result);
            System.out.println("\t\tperforming XOR operation");
            System.out.println("\t\t\tresult XOR ASCII(" + firstString.charAt(i) + ") = " + result + " XOR " + (int) (firstString.charAt(i)));
            // Perform the xor operation with the result
            result ^= firstString.charAt(i);
            System.out.println("\t\tresult: " + result + "\n");
        }
        // Traverse the string 2 till the end and perform xor operation with the result
        System.out.println("\n\tTraversing the Second string");
        for (int i = 0; i < secondStringLength; i++) {
            System.out.println("\t\t" + printStringWithMarkers(secondString, i));
            System.out.println("\t\tCurrent character: " + secondString.charAt(i));
            System.out.println("\t\tresult:" + result);
            System.out.println("\t\tperforming XOR operation");
            System.out.println("\t\t\tresult XOR ASCII(" + secondString.charAt(i) + ") = " + result + " XOR " + (int) (secondString.charAt(i)));
            // Perform the xor operation with the result
            result ^= secondString.charAt(i);
            System.out.println("\t\tresult: " + result + "\n");
        }
        // Returning the result based on the condition
        System.out.println("\tResult is the ASCII value of the extra character");
        System.out.println("\t\tExtra character = char(" + result + ") ⟶ " + (char) (result));
        System.out.println("\n\tString 1's length: " + firstString.length());
        System.out.println("\tString 2's length: " + secondString.length());
        if (firstString.length() > secondString.length()) {
            index = firstString.indexOf((char) (result));
            System.out.println("\tSince String 1's length is greater than string 2's length,\n\tthe extra character is in string 1.");
            System.out.println("\t\t" + printStringWithMarkers(firstString, index));
            System.out.print("\tExtra character is '" + firstString.charAt(index) + "' ");
            return firstString.indexOf((char) (result));
        } else {
            index = secondString.indexOf((char) (result));
            System.out.println("\tSince String 2's length is greater than string 1's length,\n\tthe extra character is in string 2.");
            System.out.println("\t\t" + printStringWithMarkers(secondString, index));
            System.out.print("\tExtra character is '" + secondString.charAt(index) + "' ");
            return secondString.indexOf((char) (result));
        }
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
