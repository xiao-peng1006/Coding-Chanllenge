import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    /**
     * Leetcode 937. Reorder Log Files
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigital1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigital2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigital1 && !isDigital2){
                int cmp = split1[1].compareTo(split2[1]);
                System.out.println("g1".compareTo("a8"));
                if (cmp != 0)
                    return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigital1 ? ( isDigital2 ? 0 : 1 ) : -1;
        });
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        Solution sol = new Solution();
        StringBuilder sb = new StringBuilder();
        String[] reorderedLogs = sol.reorderLogFiles(logs);
        sb.append("[");
        for (int i = 0; i < reorderedLogs.length; i++) {
            if (i == reorderedLogs.length-1)
                sb.append('\"' + reorderedLogs[i] + '\"');
            else
                sb.append('\"' + reorderedLogs[i] + "\", ");
        }
        sb.append("]");
        System.out.println("Expected: [\"g1 act car\",\"a8 act zoo\",\"ab1 off key dog\",\"a1 9 2 3 1\",\"zo4 4 7\"], Output: " + sb.toString());
    }
}