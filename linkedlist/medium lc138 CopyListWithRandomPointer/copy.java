import java.util.*;
public class copy {
    public class Node {
        int val;
        Node random;
        Node next;
        Node (int val) {
            this.val = val;
        }
        Node (int val, Node random, Node next) {
            this.val = val;
            this.random = random;
            this.next = next;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node n = new Node(temp.val);
            map.put(temp, n);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.next != null) {
                map.get(temp).next = map.get(temp.next);
            }
            if (temp.random != null) {
                map.get(temp).random = map.get(temp.random);
            }
            temp = temp.next;
        }
        return map.get(head);
    }
}
