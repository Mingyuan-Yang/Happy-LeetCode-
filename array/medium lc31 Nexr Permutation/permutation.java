import java.util.*;
public class permutation {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        int min = index;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
            if (nums[i] > nums[min]) min = i;
        }
        if (index == nums.length - 1) {
            Arrays.sort(nums);
        }
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index] && nums[i] <= nums[min]) {
                min = i;
            }
        }
        swap(nums, index, min);
        quicksort(nums, index + 1, nums.length - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
    private void quicksort(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        if (i - 1 > left) quicksort(nums, left, i - 1);
        if (i + 1 < right) quicksort(nums, i + 1, right);
    }
    public static void main(String[] args) {
        permutation test = new permutation();
        int[] n = new int[] {1,5,1};
        test.nextPermutation(n);
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }
    }
}
