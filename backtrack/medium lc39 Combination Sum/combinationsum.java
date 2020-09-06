import java.util.*;
public class combinationsum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), target, 0, candidates, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> list, int target, int sum, int[] candidates, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum > target) break;
            list.add(candidates[i]);
            backtrack(res, list, target, sum + candidates[i], candidates, i);
            list.remove(list.size() - 1);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        combinationsum test = new combinationsum();
        int[] nums = new int[]{7,6,3,2};
        int target = 7;
        List<List<Integer>> res = test.combinationSum(nums, target);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
