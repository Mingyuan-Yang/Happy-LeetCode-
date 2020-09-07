import java.util.*;
public class permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }
    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] used) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(" ");
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i -1]) continue;
            list.add(nums[i]);
            used[i] = true;
            backtrack(res, nums, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        permutations2 test = new permutations2();
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> res = test.permuteUnique(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(0).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
