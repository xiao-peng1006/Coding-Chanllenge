import java.lang.reflect.Array;
import java.util.*;

class Solution {

    /**
     * Leetcode 763. Partition Labels
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();

        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (map.get(c) == null)
                map.put(c, new int[] {i, i});
            else {
                map.put(c, new int[]{map.get(c)[0], i});
            }
        }

        int[] temp = map.get(S.charAt(0));
        for (Character c:S.toCharArray()) {
            int[] temp2 = map.get(c);
            if (temp2[0] > temp[0] && temp2[0] < temp[1]) {
                temp[1] = Math.max(temp[1], temp2[1]);
            } else if (temp2[0] > temp[1]) {
                res.add(temp[1] - temp[0] + 1);
                temp = temp2;
            }
        }
        res.add(temp[1] - temp[0] + 1);

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String S = "ababcbacadefegdehijhklij";
        StringBuilder sb = new StringBuilder();
        Object[] res = sol.partitionLabels(S).toArray();

        sb.append('[');
        for (int i = 0; i < res.length; i++) {
            if (i == res.length -1)
                sb.append(res[i]);
            else
                sb.append(res[i] + ", ");
        }

        sb.append(']');
        System.out.println("Expected: [9, 7, 8], Output: " + sb.toString());
    }
}