import java.util.Arrays;

public class Solution {

    /**
     *
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast.equals(slow))
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        StringBuilder sb = new StringBuilder();
        ListNode testHead, cur, connectingNode;

        // Test case # 1
        testHead = new ListNode(3);
        cur = testHead;
        connectingNode = null;
        for (int i: Arrays.asList(2, 0, 4)) {
            cur.next = new ListNode(i);
            if (i == 2)
                connectingNode = cur.next;
            cur = cur.next;
        }
        cur.next = connectingNode;
        System.out.println("Expected: true, Output: " + sol.hasCycle(testHead));

        // Test case # 2
        testHead = new ListNode(1);
        cur = testHead;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = testHead;
        System.out.println("Expected: true, Output: " + sol.hasCycle(testHead));

        // Test case # 3
        testHead = new ListNode(1);
        System.out.println("Expected: false, Output: " + sol.hasCycle(testHead));
    }
}