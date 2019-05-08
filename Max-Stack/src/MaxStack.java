import java.util.Stack;

class MaxStack {

    /**
     * Leetcode 716. Max Stack
     */
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while (top() != max) {
            buffer.push(pop());
        }
        // Use push and pop function instead of built-in stack.push/pop
        pop();
        while (!buffer.isEmpty())
            push(buffer.pop());
        return max;
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.top());        // return 5
        System.out.println(stack.popMax());     // return 5
        System.out.println(stack.top());        // return 1
        System.out.println(stack.peekMax());    // return 5
        System.out.println(stack.pop());        // return 1
        System.out.println(stack.top());        // return 5
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */