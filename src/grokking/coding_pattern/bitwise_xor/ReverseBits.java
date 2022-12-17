package grokking.coding_pattern.bitwise_xor;

public class ReverseBits {
    public static int reverseBits(int n) {
        int res = 0;
        int bit = 0;
        for (int i = 0;i < 32; i++) {
            bit = (n >> i) & 1;
            res = res | (bit << (31- i));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(41));
    }
}
