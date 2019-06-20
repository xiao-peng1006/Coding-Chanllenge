import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0, d = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int s = i + 1;
            int t = n - 1;
            while (s < t) {
                int sum = nums[i] + nums[s] + nums[t];
                if (sum == target) return target;
                int diff = Math.abs(sum - target);
                if (diff < d) {
                    d = diff;
                    ans = sum;
                }
                if (sum > target)
                    t--;
                else
                    s++;
            }
        }
        return ans;
    }
}