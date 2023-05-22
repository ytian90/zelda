package core.design;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 146. LRU Cache
 */
public class LRUCache {
    // define node and internal variables
    // addToEnd: empty, non-empty
    // remove: head, tail, middle
    // moveToEnd: node is tail, do nothing, otherwise remove + addToEnd
    // get: not exist, return, otherwise moveToEnd, return value
    // put: if exists, update value, moveToEnd, not exist, check size/remove oldest, addToEnd

    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // internal variables
    private int capacity;
    private Map<Integer, Node> map; // <key, node>
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    private void addToEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    private void remove(Node node) {
        if (node == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (node == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private void moveToEnd(Node node) {
        if (node == tail) return;
        remove(node);
        addToEnd(node);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        moveToEnd(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToEnd(node);
        } else {
            if (map.size() == capacity) {
                map.remove(head.key);
                remove(head);
            }
            Node node = new Node(key, value);
            addToEnd(node);
            map.put(key, node);
        }
    }
    // T: O(1)
    // S: O(Capacity)
}
