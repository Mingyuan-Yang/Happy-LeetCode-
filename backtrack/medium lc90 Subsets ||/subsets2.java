import java.util.*;
public class subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        if (!res.contains(list)) {
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        subsets2 test = new subsets2();
        int[] nums = new int[]{4,4,4,1,4};
        List<List<Integer>> res = test.subsetsWithDup(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
