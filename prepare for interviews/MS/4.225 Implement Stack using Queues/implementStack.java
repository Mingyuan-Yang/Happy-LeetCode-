import java.util.*;
public class implementStack {
    private Queue<Integer> queue;
    public implementStack() {
        queue = new LinkedList<>();
    }
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
    }
    public int pop() {
        return queue.poll();
    }
    public boolean empty() {
        return queue.isEmpty();
    }
}
