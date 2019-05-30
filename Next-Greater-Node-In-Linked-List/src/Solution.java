import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public int[] nextLargerNodes(ListNode head) {
        Stack<int[]> stack = new Stack<>();
        ListNode node = head;
        int[] res = new int[getLen(head)];
        int count = 0;
        while (node != null) {
            while (!stack.isEmpty() && stack.peek()[1] < node.val) {
                    res[stack.peek()[0]] = node.val;
                    stack.pop();
            }
            stack.push(new int[]{count, node.val});
            count++;
            node = node.next;
        }

        while (!stack.isEmpty()) {
            res[stack.pop()[0]] = 0;
        }

        return res;
     }

     private int getLen(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
     }
}