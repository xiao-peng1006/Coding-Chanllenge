import java.util.HashMap;

class Solution {

    /**
     * Leetcode 1010. Pairs of Songs With Total Durations Divisible by 60
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            int reminder = time[i] % 60;
            res += map.getOrDefault((60 - reminder) % 60, 0);
            map.put(reminder, map.getOrDefault(time[i] % 60, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Expected: 3, Output: " + solution.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));

        System.out.println("Expected: 3, Output: " + solution.numPairsDivisibleBy60(new int[]{60, 60, 60}));

        System.out.println("Expected: 245, Output: " + solution.numPairsDivisibleBy60(new int[]{336, 24, 100, 342, 274, 11, 43, 22, 416, 138, 384, 386, 70, 265, 59, 253, 344, 435, 400, 296, 192, 143, 311, 424, 315, 63, 420, 254, 493, 431, 32, 394, 178, 51, 378, 335, 265, 92, 335, 325, 25, 355, 258, 298, 390, 399, 393, 114, 149, 62, 299, 471, 286, 204, 163, 214, 15, 272, 315, 212, 272, 437, 339, 193, 125, 394, 62, 188, 154, 150, 109, 294, 228, 200, 459, 42, 469, 132, 37, 460, 143, 1, 144, 127, 398, 82, 370, 464, 14, 85, 321, 358, 205, 14, 264, 289, 183, 93, 56, 126, 413, 140, 441, 446, 445, 378, 258, 119, 385, 226, 8, 93, 476, 265, 115, 86, 360, 92, 396, 407, 458, 58, 65, 397, 381, 32, 228, 37, 319, 220, 73, 328, 162, 458, 231, 219, 481, 387, 423, 256, 252, 36, 309, 395, 471, 4, 225, 146, 188, 182, 347, 82, 21, 292, 91, 144, 387, 263, 206, 452, 197, 192, 324, 257, 370, 28, 440, 180, 294}));

        System.out.println();
    }
}