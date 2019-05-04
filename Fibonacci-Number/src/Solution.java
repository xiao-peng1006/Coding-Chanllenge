class Solution {

    /**
     * Leetcode 509. Fibonacci Number
     * @param N
     * @return
     */
    public int fib(int N) {
        int n0 = 0, n1 = 1;
        if (N == 0) return n0;
        if (N == 1) return n1;
        int count = 1;
        int curr = 0;
        while (N > count) {
            curr = n0 + n1;
            n0 = n1;
            n1 = curr;
            count++;
        }
        return curr;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Expected: 1, Output: " + sol.fib(2));

        System.out.println("Expected: 2, Output: " + sol.fib(3));

        System.out.println("Expected: 3, Output: " + sol.fib(4));
    }
}