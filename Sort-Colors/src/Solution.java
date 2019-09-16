class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i <= two; i++) {
            if (nums[i] == 2) {
                swap(nums, i, two);
                i--; two--;
            } else if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}