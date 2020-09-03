import java.util.*;
public class histogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int partMax = heights[stack.pop()] * (i - stack.peek() - 1);
                max = Math.max(max, partMax);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int partMax = heights[stack.pop()] * (heights.length - stack.peek() - 1);
            max = Math.max(max, partMax);
        }
        return max;
    }
}
