/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode plusOne(ListNode head) {
        ListNode reversedHead = reverse(head);
        ListNode curNode = reversedHead;
        while (curNode != null && curNode.val == 9) {
            curNode.val = 0;
            curNode = curNode.next;
        }

        if (curNode != null) {
            curNode.val += 1;
            return reverse(reversedHead);
        } else {
            head = reverse(reversedHead);
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode curNode = head;
        ListNode prevNode = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return prevNode;
    }
}