class Solution {

    /**
     * Leetcode 443. String Compression
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        if (chars.length == 1)
            return 1;
        int count = 1, prev = 0, index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[prev]) {
                count++;
            } else {
                if (count > 1) {
                    chars[index++] = chars[prev];
                    for (Character character:(""+count).toCharArray()) {
                        chars[index++] = character;
                    }
                } else {
                    chars[index++] = chars[prev];
                }
                prev = i;
                count = 1;
            }
        }

        if (count != 1) {
            chars[index++] = chars[prev];
            for (Character character : ("" + count).toCharArray()) {
                chars[index++] = character;
            }
        } else {
            chars[index++] = chars[prev];
        }

        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 6, Output: " + solution.compress(new char[]{'a','a','b','b','c','c','c'}));

        System.out.println("Expected: 1, Output: " + solution.compress(new char[]{'a'}));

        System.out.println("Expected: 3, Output: " + solution.compress(new char[]{'a','b','c'}));

        System.out.println("Expected: 4, Output: " + solution.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}