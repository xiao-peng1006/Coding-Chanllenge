class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] *= -1;
        }
        return 0;
    }
}