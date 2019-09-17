import java.util.Random;

class Solution {
    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return -1;
        this.nums = nums;
        int size = nums.length;
        return quickSelect(0, size - 1, size - k);
    }

    public int quickSelect(int left, int right, int k) {
        if (left == right) {
            return this.nums[left];
        }

        Random random = new Random();
        int povit_index = left + random.nextInt(right - left);

        povit_index = partition(left, right, povit_index);

        if (povit_index == k) {
            return this.nums[k];
        } else if (povit_index < k) {
            return quickSelect(povit_index + 1, right, k);
        } else {
            return quickSelect(left, povit_index - 1, k);
        }
    }

    public int partition(int left, int right, int pivot_index) {
        int povit = this.nums[pivot_index];

        swap(pivot_index, right);
        int store_index = left;

        for (int i = left; i <= right; i++) {
            if (this.nums[i] < povit) {
                swap(store_index, i);
                store_index++;
            }
        }

        swap(store_index, right);
        return store_index;
    }

    public void swap(int a, int b) {
        int temp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = temp;
    }
}