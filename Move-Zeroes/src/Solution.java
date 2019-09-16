import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}