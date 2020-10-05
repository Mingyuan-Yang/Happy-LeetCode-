import java.util.*;
public class MedianFinder {
    PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Comparator.reverseOrder()); // descending
    PriorityQueue<Integer> rightQueue = new PriorityQueue<>(); // ascending
    public MedianFinder() {

    }
    public void addNum(int num) {
        int leftSize = leftQueue.size();
        int rightSize = rightQueue.size();
        if (leftSize == rightSize) {
            if (leftSize == 0) {
                leftQueue.add(num);
            } else if (num <= rightQueue.peek()) {
                leftQueue.add(num);
            } else {
                leftQueue.add(rightQueue.poll());
                rightQueue.add(num);
            }
        } else {
            if (num >= leftQueue.peek()) {
                rightQueue.add(num);
            } else {
                rightQueue.add(leftQueue.poll());
                leftQueue.add(num);
            }
        }
    }
    public double findMedian() {
        if (leftQueue.size() > rightQueue.size()) {
            return leftQueue.peek();
        } else {
            return ((double)leftQueue.peek() + rightQueue.peek()) / 2;
        }
    }
}
