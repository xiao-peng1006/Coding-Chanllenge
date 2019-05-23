import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    /**
     * Leetcode 797. All Paths From Source to Target
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        helper(graph, new int[]{0}, graph[graph.length - 1], new ArrayList<>(), res);
        return res;
    }

    public void helper(int[][] graph, int[] starts, int[] ends, List<Integer> list, List<List<Integer>> res) {
        for (int end:ends) {
            if (list.size() > 0 && list.get(list.size() - 1) == end) {
                res.add(list);
                return;
            }
        }

        for (int num:starts) {
            list.add(num);
            helper(graph, graph[num], ends, new ArrayList<>(list), res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
