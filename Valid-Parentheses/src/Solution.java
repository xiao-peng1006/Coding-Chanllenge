import java.util.*;

/**
 *  Leetcode - 20
 *
 *  Thoughts: Add the second half of the parentheses into the stack in order if encountered the first half.
 *  If the character is not the first half of parentheses, changes if it matches with the element at the top of the stack.
 *  Return false if not match, or if the stack is empty at the moment.
 *  If the stack is not empty after going over the whole string, return false.
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        String testCase = "()";
        System.out.println("Expected: true, Output: " + sol.isValid(testCase));

        testCase = "()[]{}";
        System.out.println("Expected: true, Output: " + sol.isValid(testCase));

        testCase = "(]";
        System.out.println("Expected: false, Output: " + sol.isValid(testCase));

        testCase = "([)]";
        System.out.println("Expected: false, Output: " + sol.isValid(testCase));

        testCase = "{[]}";
        System.out.println("Expected: true, Output: " + sol.isValid(testCase));

        testCase = "]";
        System.out.println("Expected: false, Output: " + sol.isValid(testCase));
    }

}