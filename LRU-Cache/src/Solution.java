import java.util.HashMap;

class LRUCache {

    // use double linked list for O(1) time complexity on put method
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "(" + key + "," + value + ")";
        }
    }

    // use HashMap for O(1) time complexity on get method
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    /**
     * Leetcode 146. LRU Cache
     * Could you do both operations (get and put) in O(1) time complexity?
     * @param capacity
     */


    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        // return the value and put (key, value) in the most recent position wiht O(1) time complexity
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            if (head == node && tail != node) {
                head = head.next;
                node.prev = tail;
                node.next = null;
                if (head == tail)
                    tail.prev = null;
                tail.next = node;
                tail = node;
            } else if (tail != node) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = node.next;
                next.prev = node.prev;

                node.prev = tail;
                node.next = null;
                tail.next = node;
                tail = node;
            }
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            /*
                When there is already an entry in the cache with the same key, update the value and put it to the most recent position
             */
            node.value = value;
            map.put(key, node);
            get(key);
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                /*
                    The cache is full:
                    remove the least recent entry(head) from the double linked list
                 */
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }

            if (head == null && tail == null) {
                /*
                    The cache is empty:
                    add new entry to the tail
                 */
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

        LRUCache cache2 = new LRUCache( 1 /* capacity */ );
        cache2.put(2, 1);
        cache2.get(2);
        cache2.put(3, 2);
        cache2.get(2);
        cache2.get(3);

        LRUCache cache3 = new LRUCache( 2 /* capacity */ );
        cache3.put(2, 1);
        cache3.put(2, 2);
        cache3.get(2);
        cache3.put(1, 1);
        cache3.put(4, 1);
        cache3.get(2);
    }
}

