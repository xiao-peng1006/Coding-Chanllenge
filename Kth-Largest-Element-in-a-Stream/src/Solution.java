import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class KthLargest {

    /**
     * Leetcode 703. Kth Largest Element in a Stream
     * @param k
     * @param nums
     */
    List<Integer> nums;
    int k;
    public KthLargest(int k, int[] nums) {
        this.nums = new ArrayList<>();
        for (int num:nums) {
            this.nums.add(num);
        }
        this.k = k;
    }

    public int add(int val) {
        nums.add(val);
        Collections.sort(nums);
        return nums.get(nums.size() - k);
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */