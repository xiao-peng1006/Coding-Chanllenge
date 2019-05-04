class Solution {

    /**
     * Leetcode 509. Fibonacci Number
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fib(N-1)+fib(N-2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Expected: 1, Output: " + sol.fib(2));

        System.out.println("Expected: 2, Output: " + sol.fib(3));

        System.out.println("Expected: 3, Output: " + sol.fib(4));
    }
}