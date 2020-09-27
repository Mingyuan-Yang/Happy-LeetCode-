import java.util.*;
public class AVERAGE {
    public static class Node {
        int val;
        List<Node> children;
        Node (int val) {
            this.val = val;
        }
        Node (int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
        Node (List<Node> children) {
            this.children = children;
        }
    }
    public Node max (Node root) {
        double[] max = new double[]{0};
        Node[] node = new Node[]{root};
        if (root == null) return root;
        helper(root, max, node);
        return node[0];
    }
    public double[] helper(Node root, double[] max, Node[] node) {
        if (root == null) {
            return new double[]{0, 0};
        }
        double number = 1;
        double sum = root.val;
        if (root.children != null) {
            for (Node child : root.children) {
                double[] curr = helper(child, max, node);
                number += curr[0];
                sum += curr[1];
            }
        }
        double average = sum / number;
        if (number > 1 && average > max[0]) {
            max[0] = average;
            node[0] = root;
        }
        return new double[]{number, sum};
    }
    public static void main(String[] args) {
        AVERAGE test = new AVERAGE();
        Node left = new Node(12);
        left.children = new ArrayList<Node>(Arrays.asList(new Node(11), new Node(2), new Node(3)));
        Node right = new Node(18);
        right.children = new ArrayList<Node>(Arrays.asList(new Node(15), new Node(8)));
        Node root = new Node(20);
        root.children = new ArrayList<Node>(Arrays.asList(left, right));
        Node res = test.max(root);
        System.out.print(res.val);

    }
}
