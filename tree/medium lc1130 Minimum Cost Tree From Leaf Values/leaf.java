import java.util.*;
public class leaf {
    public int mctFromLeafValue(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            while (!stack.isEmpty() && stack.peek() < a) {
                int mid = stack.pop();
                sum += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            sum += stack.pop() * stack.peek();
        }
        return sum;
    }
}
