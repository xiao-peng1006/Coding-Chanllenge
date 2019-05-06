import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    /**
     * Leetcode 997. Find the Town Judge
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        if (trust == null || trust.length == 0) {
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int[] t : trust) {
            map.put(t[1], map.getOrDefault(t[1], 0) + 1);
            if (map.get(t[1]) == (N-1)) {
                list.add(t[1]);
            }
        }

        for (int[] t:trust) {
            if (list.contains(t[0]))
                list.remove((Object) t[0]);
        }

        if (list.size() == 0)
            return -1;
        else
            return list.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 2, Output: " + solution.findJudge(2, new int[][]{{1, 2}}));

        System.out.println("Expected: 3, Output: " + solution.findJudge(3, new int[][]{{1, 3}, {2, 3}}));

        System.out.println("Expected: -1, Output: " + solution.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));

        System.out.println("Expected: -1, Output: " + solution.findJudge(3, new int[][]{{1, 2}, {2, 3}}));

        System.out.println("Expected: 3, Output: " + solution.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }
}