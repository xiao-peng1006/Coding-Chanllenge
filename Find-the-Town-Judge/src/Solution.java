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
        int[][] degree = new int[N+1][2];
        for (int[] t:trust) {
            degree[t[1]][0]++;
            degree[t[0]][1]++;
        }

        for (int i = 1; i <= N; i++) {
            int[] d = degree[i];
            if (d[0] == N-1 && d[1] == 0)
                return i;
        }
        return -1;
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