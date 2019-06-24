import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        int len = s.length();
        if (len == 0) return "";
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stringStack.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                int num = numberStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for (int j = 0; j < num; j++) {
                    temp.append(res);
                }
                res = temp;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                numberStack.push(num);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected: \"aaabcbc\", Output: \"" + solution.decodeString("3[a]2[bc]") + "\"");
    }
}