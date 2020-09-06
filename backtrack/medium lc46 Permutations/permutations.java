import java.util.*;
public class permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<Integer>());
        return res;
    }
    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(res, nums, list);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        permutations test = new permutations();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = test.permute(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(0).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
