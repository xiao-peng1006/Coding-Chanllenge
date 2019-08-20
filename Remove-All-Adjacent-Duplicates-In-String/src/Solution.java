import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (Character c : S.toCharArray()) {
            if (!stack.empty() && stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }
}