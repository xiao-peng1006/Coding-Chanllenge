import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    /**
     * Leetcode 451. Sort Characters By Frequency
     * @param s
     * @return
     */

    public String frequencySort(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(map.size(), (Character a, Character b) -> {
            return map.get(b) - map.get(a);
        });

        for (Character c:map.keySet()) {
            pq.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            for (int i = 0; i < map.get(c); i++)
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: \"eert\", Output: \"" + solution.frequencySort("tree") + "\"");

        System.out.println("Expected: \"cccaaa\", Output: \"" + solution.frequencySort("cccaaa") + "\"");

        System.out.println("Expected: \"bbAa\", Output: \"" + solution.frequencySort("Aabb") + "\"");

        System.out.println("Expected: \"\", Output: \"" + solution.frequencySort("") + "\"");
    }
}