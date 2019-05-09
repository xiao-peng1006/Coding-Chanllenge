import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 225. Implement Stack using Queues
 */
class MyStack {

    /**
     * Initialize your data structure here.
     */
    Queue<Integer> queue;
    Queue<Integer> queue2;
    public MyStack() {
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue.isEmpty()) {
            queue.add(x);
        } else if (queue2.isEmpty()) {
            queue2.add(x);
        }
        else {
            if (queue.size() == 1 && queue2.size() == 1) {
                queue2.add(queue.remove());
                queue.add(x);
            } else if (queue.size() == 1) {
                while (!queue2.isEmpty()) {
                    queue.add(queue2.remove());
                }
                queue2.add(x);
            } else {
                while (!queue.isEmpty()) {
                    queue2.add(queue.remove());
                }
                queue.add(x);
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue2.size() == 1 || queue.isEmpty()) {
            return queue2.remove();
        } else {
            return queue.remove();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue2.size() == 1 || queue.isEmpty()) {
            return queue2.peek();
        } else {
            return queue.peek();
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println("top(): " + obj.top());          // return 3
        System.out.println("pop(): " + obj.pop());          // return 3
        System.out.println("pop(): " + obj.pop());          // return 2
        System.out.println("pop(): " + obj.pop());          // return 1
        System.out.println("empty(): " + obj.empty());        // return true
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */