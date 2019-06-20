import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> cadidates = new ArrayList<>(count.keySet());
        Collections.sort(cadidates, (w1, w2) -> {
            if (count.get(w1) == count.get(w2)) {
                return w1.compareTo(w2);
            } else {
                return count.get(w2) - count.get(w1);
            }
        });
        return cadidates.subList(0, k);
    }
}