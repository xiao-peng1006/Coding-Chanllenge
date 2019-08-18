import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDistance {
    Map<String, List<Integer>> locations;

    public WordDistance(String[] words) {
        locations = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> locs = this.locations.getOrDefault(words[i], new ArrayList<>());
            locs.add(i);
            locations.put(words[i], locs);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> locs1, locs2;
        locs1 = this.locations.get(word1);
        locs2 = this.locations.get(word2);

        int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
        while (l1 < locs1.size() && l2 < locs2.size()) {
            minDiff = Math.min(minDiff, Math.abs(locs1.get(l1) - locs2.get(l2)));
            if (locs1.get(l1) < locs2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding", word2 = "practice";
        WordDistance obj = new WordDistance(words);
        int param_1 = obj.shortest(word1,word2);
        System.out.println(param_1);

        word1 = "coding"; word2 = "makes";
        int param_2 = obj.shortest(word1,word2);
        System.out.println(param_2);
    }
}
