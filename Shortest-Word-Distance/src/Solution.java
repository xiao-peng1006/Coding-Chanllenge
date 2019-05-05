class Solution {

    /**
     * Leetcode 243. Shortest Word Distance
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int[] word1Index = new int[words.length];
        int[] word2Index = new int[words.length];
        int count1 = 0, count2 = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                word1Index[count1++] = i;
            if (words[i].equals(word2))
                word2Index[count2++] = i;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < count1; i++) {
            for (int j = 0; j < count2; j++) {
                int temp = Math.abs(word1Index[i]-word2Index[j]);
                res = Math.min(res, temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 3, Output: " + solution.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));

        System.out.println("Expected: 1, Output: " + solution.shortestDistance(new String[]{"a", "a", "b", "b"}, "a", "b"));
    }
}