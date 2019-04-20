import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {

    /**
     * Leetcode 973. K Closest Points to Origin
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        int[] distances = new int[points.length];
        for (int i = 0; i < points.length; i++)
            distances[i] = distance(points[i]);

        Arrays.sort(distances);
        int distK = distances[K-1];

        int[][] res = new int[K][2];
        int count = 0;
        for (int[] point : points) {
            if (distance(point) <= distK)
                res[count++] = point;
        }
        return res;
    }

    public int distance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}