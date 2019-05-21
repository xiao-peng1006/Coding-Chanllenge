public class Solution {

    /**
     * Leetcode 190. Reverse Bits
     * @param n
     * @return
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0, i = 0;
        while (i < 32) {
            int temp = n & 0x01;
            n = n >> 1;
            res = res << 1 | temp;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Expected: 964176192, Output: " + solution.reverseBits(43261596));

        System.out.println("Expected: -1073741825, Output: " + solution.reverseBits(-3));
    }
}