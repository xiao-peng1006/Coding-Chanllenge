import java.util.LinkedList;

/**
 * Leetcode - 206
 */
public class Solution {
    /**
     *  Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

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

        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        cur = sol.reverseList(head);;
        while (cur != null) {
            sb.append(String.valueOf(cur.val) + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        System.out.println("Expected: 5->4->3->2->1->NULL, Output: " + sb.toString());
    }
}
