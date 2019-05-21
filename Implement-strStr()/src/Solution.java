class Solution {

    /**
     * Leetcode 28. Implement strStr()
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int[] starts = new int[haystack.length()];
        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                starts[count++] = i;
            }
        }

        if (count == 0) {
            return -1;
        } else {
            for (int i = 0; i < count; i++) {
                int start = starts[i], end = start + needle.length();
                if (end <= haystack.length() && needle.equals(haystack.substring(start, end)))
                    return starts[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "hello", needle = "ll";
        System.out.println("Expected: 2, Output: " + solution.strStr(haystack, needle));

        haystack = "aaaaa"; needle = "bba";
        System.out.println("Expected: -1, Output: " + solution.strStr(haystack, needle));

        haystack = "mississippi"; needle = "issipi";
        System.out.println("Expected: -1, Output: " + solution.strStr(haystack, needle));

        haystack = "aaa"; needle = "aaaa";
        System.out.println("Expected: -1, Output: " + solution.strStr(haystack, needle));
    }
}