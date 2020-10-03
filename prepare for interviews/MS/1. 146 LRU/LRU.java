import java.util.*;
class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    class DoubleLinkedList {
        private Node dummy = new Node(0, 0);
        private Node tail = dummy;
        public void addToHead(Node node) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        public Node getHead() {
            return dummy.next;
        }
        public void removeNode (Node node) {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
            node.next = null;
            node.prev = null;
        }
        public void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }
    }

    private HashMap<Integer, Node> map = new HashMap<>();
    private int capacity;
    private DoubleLinkedList list = new DoubleLinkedList();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node v = map.get(key);
            int res = v.val;
            list.moveToHead(v);
            return res;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            list.moveToHead(node);
        } else {
            if (map.size() == capacity) {
                Node head = list.getHead();
                map.remove(head.key);
                list.removeNode(head);
            }
            Node node = new Node(key, value);
            list.addToHead(node);
            map.put(key, node);
        }
    }
}
