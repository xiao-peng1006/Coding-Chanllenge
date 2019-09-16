class Solution {
    public int removeDuplicates(int[] nums) {
        int end = nums.length;
        for (int i = 2; i < end; i++) {
            if (nums[i] == nums[i - 2]) {
                for (int j = i + 1; j < end; j++) {
                    nums[j - 1] = nums[j];
                }
                end--;
                i--;
            }

        }
        return end;
    }
}