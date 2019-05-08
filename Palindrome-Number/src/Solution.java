class Solution {

    /**
     * Leetcode 9. Palindrome Number
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int y = 0;
        int temp = x;
        while (temp != 0) {
            y = y * 10 + temp % 10;
            temp = temp/10;
        }

        if (x == y)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Expected: true, Output: " + solution.isPalindrome(121));

        System.out.println("Expected: false, Output: " + solution.isPalindrome(-121));

        System.out.println("Expected: false, Output: " + solution.isPalindrome(10));
    }
}