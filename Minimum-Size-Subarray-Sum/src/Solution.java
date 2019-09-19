class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int left = 0, right = -1;
        int res = Integer.MAX_VALUE;
        int tempSum = 0;
        while (left < nums.length) {
            if (right + 1 < nums.length && tempSum <= s) {
                tempSum += nums[++right];
            } else {
                tempSum -= nums[left++];
            }

            if (tempSum >= s) {
                res = Math.min(res, right - left + 1);
                System.out.println(res);
            }
        }
        return res > nums.length ? 0 : res;
    }
}