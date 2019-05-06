import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class Solution {

    /**
     * Leetcode 599. Minimum Index Sum of Two Lists
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length == 0 || list2.length == 0)
            return new String[]{};
        HashMap<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);

        for (int i = 0; i < list2.length; i++) {
            if (map.get(list2[i]) != null) {
                int temp = map.get(list2[i]) + i;
                if (temp < min) {
                    list.clear();
                    list.add(list2[i]);
                    min = temp;
                } else if (temp == min) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        StringBuilder sb = new StringBuilder();

        String[] res = solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
        for (int i = 0; i < res.length; i++) {
            if (res[i] == null)
                break;
            if (i == res.length - 1) {
                sb.append("\"" + res[i] + "\"");
            } else {
                sb.append("\"" + res[i] + "\", ");
            }
        }
        System.out.println("Expected: [\"Shogun\"], Output: [" + sb.toString() + "]");

        res = solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"});
        System.out.println("Expected: [\"Shogun\"], Output: [\"" + res[0] + "\"]");

        res = solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC","Burger King","Tapioca Express","Shogun"});
        System.out.println("Expected: [\"KFC\",\"Burger King\",\"Tapioca Express\",\"Shogun\"], Output: [\"" + res[0] + "\"]");
    }
}