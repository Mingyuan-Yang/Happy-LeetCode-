import java.util.Arrays;
import java.util.*;

public class twoSum {
    public static int[] find(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        twoSum s = new twoSum();
        int[] numbers = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] result = s.find(numbers, target);
        System.out.println(Arrays.toString(result));
    }
}
