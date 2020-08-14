import java.util.*;
import java.util.Arrays;

public class binarySearch {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                set.remove(nums2[i]);
                list.add(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        binarySearch s = new binarySearch();
        int[] nums1 = new int[] {4, 9, 5};
        int[] nums2 = new int[] {9, 4, 9, 8, 4};
        int[] result = s.intersection(nums1, nums2);
        System.out.print(Arrays.toString(result));
    }
}
