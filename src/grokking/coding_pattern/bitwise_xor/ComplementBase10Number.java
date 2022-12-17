package grokking.coding_pattern.bitwise_xor;

public class ComplementBase10Number {
    /*
    m - is length of binary value the base 10 number.
    Time - O(m)
     */
    public static int findBitwiseComplement(int num) {
        String binaryForm = Integer.toString(num, 2);
        char[] chars = binaryForm.toCharArray();
        for (int i = 0; i < chars.length; i++){
            chars[i] = chars[i] == '0' ? '1' : '0';
        }
        String binaryFormInverted = new String(chars);
        return Integer.parseInt(binaryFormInverted, 10);
    }

    /*
    Time - O(1)
    Space - O(1)
     */
    public static int findBitWiseComplementO(int num) {
        // if the value of num is 0, return 1
        if (num == 0)
            return 1;
        // converting the value in to its binary representation
        // counting the number of bits required by this number
        int bitCount = (int) Math.floor((int) (Math.log(num) / Math.log(2))) + 1;

        // computing the all bits set of the number
        int allBitsSet = (int) Math.pow(2, bitCount) - 1;

        // flipping all bits of number by taking xor with cell bits set
        return num ^ allBitsSet;
    }
    public static void main(String[] args) {
        System.out.println(findBitWiseComplementO(42));
    }
}
