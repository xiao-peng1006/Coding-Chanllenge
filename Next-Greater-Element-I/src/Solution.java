class Solution {

    /**
     * Leetcode 496. Next Greater Element I
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            int index = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j])
                    index = j;
            }

            for (int j = index; j < nums2.length; j++){
                if (nums1[i] < nums2[j]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < res.length; i++) {
            if (i == res.length-1)
                sb.append(res[i]);
            else
                sb.append(res[i] + ", ");
        }
        sb.append("]");
        System.out.println("Expected: [3, -1], Output: " + sb.toString());
    }
}