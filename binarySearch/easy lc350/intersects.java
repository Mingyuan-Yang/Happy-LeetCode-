import java.util.*;

public class intersects {
    public static int[] solution(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{0, 0};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            int y = nums2[i];
            if(map.containsKey(y) && map.get(y) > 0) {
                list.add(y);
                map.put(y, map.get(y) - 1);
                if(map.get(y) == 0) {
                    map.remove(y);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        intersects s = new intersects();
        int[] nums1 = new int[] {1, 2, 2, 3, 4, 5};
        int[] nums2 = new int[] {2, 2, 4, 6, 8};
        int[] result = s.solution(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
