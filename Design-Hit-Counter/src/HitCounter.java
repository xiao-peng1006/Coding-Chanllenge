import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class HitCounter {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    int count;
    public HitCounter() {
        queue = new LinkedList<>();
        count = 0;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
        if (timestamp >= 300) {
            while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
                queue.poll();
                count--;
            }
        }
        count++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (timestamp >= 300) {
            while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
                queue.poll();
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        System.out.println("Expected: 3, Output: " + counter.getHits(4));

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        System.out.println("Expected: 4, Output: " + counter.getHits(300));

        // get hits at timestamp 301, should return 3.
        System.out.println("Expected: 3, Output: " + counter.getHits(301));
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */