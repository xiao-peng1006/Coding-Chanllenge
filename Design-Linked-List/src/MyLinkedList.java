class MyLinkedList {

    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node getNode(int index) {
        Node node = new Node(0, this.head);
        while (index >= 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        return getNode(index).val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        this.head = new Node(val, this.head);
        if (this.size++ == 0) {
            this.tail = this.head;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (this.size++ == 0) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > this.size || index < 0)
            return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == this.size) {
            addAtTail(val);
        } else {
            Node prev = getNode(index - 1);
            prev.next = new Node(val, prev.next);
            this.size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0)
            return;

        Node prev = getNode(index - 1);
        prev.next = prev.next.next;

        if (index == 0) {
            this.head = prev.next;
        } else if (index == size - 1) {
            this.tail = prev;
        }
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println("Expected: 2, Output: " + linkedList.get(1));            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println("Expected: 3, Output: " + linkedList.get(1));           // returns 3
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */