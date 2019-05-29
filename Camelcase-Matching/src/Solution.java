import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Leetcode 1023. Camelcase Matching
     * @param queries
     * @param pattern
     * @return
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        String[] patternSegments = toStringArray(pattern);
        for (String query : queries) {
            String[] querySegments = toStringArray(query);
            if (querySegments.length != patternSegments.length) {
                res.add(false);
                continue;
            }

            boolean flag = true;
            System.out.println(query);
            for (int j = 0; j < querySegments.length; j++) {
                int patternCharPosition = 0;
                for (int k = 0; k < querySegments[j].length() && patternCharPosition < patternSegments[j].length(); k++) {
                    if (querySegments[j].charAt(k) == patternSegments[j].charAt(patternCharPosition)) {
                        patternCharPosition++;
                    }
                    System.out.println(patternCharPosition + "?= " + patternSegments[j].length());
                    if (k == querySegments[j].length() - 1 && patternCharPosition < patternSegments[j].length()) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag)
                res.add(false);
            else
                res.add(true);
        }
        return res;
    }

    private String[] toStringArray(String s) {
        List<String> res = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                res.add(s.substring(start, i));
                start = i;
            }
        }
        res.add(s.substring(start, s.length()));
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}