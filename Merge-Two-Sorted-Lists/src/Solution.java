import java.util.Arrays;

/**
 * Leetcode 21
 */
public class Solution {
    /**
     * Definition for singly-linked list.
     * */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(-1);
        ListNode prev = headNode;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            }
            else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }

        while (l1 != null) {
            prev.next = l1;
            l1 = l1.next;
            prev = prev.next;
        }

        while (l2 != null) {
            prev.next = l2;
            l2 = l2.next;
            prev = prev.next;
        }

        return headNode.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        StringBuilder sb = new StringBuilder();
        ListNode l1, l2, cur;

        l1 = new ListNode(1);
        cur = l1;
        for (int i: Arrays.asList(2,4)) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        l2 = new ListNode(1);
        cur = l2;
        for (int i: Arrays.asList(3,4)) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        cur = sol.mergeTwoLists(l1, l2);
        while (cur != null) {
            sb.append(String.valueOf(cur.val) + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        System.out.println("Expected: 1->1->2->3->4->4->NULL, Output: " + sb.toString());
    }
}