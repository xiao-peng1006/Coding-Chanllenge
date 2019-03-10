import java.util.Arrays;

class Solution {
    /**
     *
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow, fast;
        slow = head;
        fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;

        l2 = reverse(l2);

        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummyHead = null;
        ListNode prev = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        StringBuilder sb = new StringBuilder();
        ListNode testHead, cur;

        testHead = new ListNode(1);
        cur = testHead;
        for (int i: Arrays.asList(2)) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println("Expected: false, Output: " + sol.isPalindrome(testHead));

        testHead = new ListNode(1);
        cur = testHead;
        for (int i: Arrays.asList(2, 2, 1)) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println("Expected: true, Output: " + sol.isPalindrome(testHead));

        testHead = null;
        System.out.println("Expected: true, Output: " + sol.isPalindrome(testHead));

        testHead = new ListNode(1);
        System.out.println("Expected: true, Output: " + sol.isPalindrome(testHead));
    }
}