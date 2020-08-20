import java.util.*;
public class next2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] copy = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
            copy[i + nums.length] = nums[i];
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int[] res = new int[nums.length];
        int[] copy2 = new int[copy.length];
        for (int i = 0; i < copy.length; i++) {
            while (!stack.isEmpty() && copy[stack.peek()] < copy[i]) {
                copy2[stack.pop()] = copy[i];
                index++;
            }
            stack.push(i);
            copy2[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < res.length; i++) {
            if (copy2[i] != Integer.MAX_VALUE) res[i] = copy2[i];
            else res[i] = -1;
        }
        return res;
    }
    public static void main(String[] args) {
        next2 test = new next2();
        int[] nums = new int[]{4,3,2,5,2};
        int[] res = test.nextGreaterElements(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
