package grokking.coding_pattern.modified_binary_search;

public class NextLetter {
    /*
    Time - O(logN)
    Space - O(1)
     */
    public static char searchNextLetter(char[] letters, char key) {
        int n = letters.length;
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int middle = start + (end - start) / 2;
            if (key < letters[middle])
                end = middle - 1;
            else
                // if (key <= letters[mid])
                start = middle + 1;
        }
        // since the loop is running until 'start<=end', so at the end of the while loop, 'start == end + 1'
        return letters[start % n];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
