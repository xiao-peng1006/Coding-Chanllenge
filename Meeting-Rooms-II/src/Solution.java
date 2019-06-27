import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        int res = 0;
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        PriorityQueue<Integer> rooms = new PriorityQueue<Integer>(intervals.length, (a, b) -> {
            return a - b;});
        rooms.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= rooms.peek()) {
                rooms.remove();
            }
            rooms.add(intervals[i][1]);
        }
        return rooms.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: 2, Output: " + solution.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println("Expected: 1, Output: " + solution.minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
        System.out.println("Expected: 3, Output: " + solution.minMeetingRooms(new int[][]{{9, 16}, {6, 16}, {1, 9}, {3, 15}}));
    }
}