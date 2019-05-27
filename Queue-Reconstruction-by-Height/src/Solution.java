import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * Leetcode 406. Queue Reconstruction by Height
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people == null || people[0].length != 2) {
            return people;
        }
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            else
                return b[0] - a[0];
        });

        List<int[]> res = new ArrayList<>();

        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[people.length][]);
    }
}