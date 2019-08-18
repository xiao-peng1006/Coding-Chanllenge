import java.util.HashSet;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {
        // 使用int做加法运算可能会溢出, 所以使用long计算总和
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for (int n: nums) {
            sumArray += n;
            set.add((long) n);
        }

        for (Long s:set) {
            sumSet += s;
        }

        return (int) ((3 * sumSet - sumArray) / 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums));
    }
}