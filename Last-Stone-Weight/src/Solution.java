import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int s1 = pq.poll(), s2 = pq.poll();
            int result = Math.abs(s1 - s2);
            if (result != 0) pq.offer(result);
        }

        return pq.size() == 0 ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(solution.lastStoneWeight(stones));
    }
}