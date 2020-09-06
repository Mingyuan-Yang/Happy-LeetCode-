import java.util.*;
public class subsets {
    public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        backtrack(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> list, int index, int[] nums) {
        res.add(new ArrayList<Integer>(list));
        for (int i = index; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backtrack(res, list, i + 1, nums);
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        subsets test = new subsets();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = test.subset(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
