import java.util.*;

class KthLargest {

    /**
     * Leetcode 703. Kth Largest Element in a Stream
     * @param k
     * @param nums
     */
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int size;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        for (int num:nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < size)
            minHeap.offer(val);
        else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
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