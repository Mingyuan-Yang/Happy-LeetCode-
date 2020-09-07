import java.util.*;
public class combinationsum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int sum, int index) {
        if (sum == target && !res.contains(list)) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum > target) break;
            list.add(candidates[i]);
            backtrack(res, list, candidates, target, sum + candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        combinationsum2 test = new combinationsum2();
        int[] nums = new int[]{2,5,2,1,2};
        int target = 5;
        List<List<Integer>> res = test.combinationSum2(nums, target);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
