import java.util.*;
public class HIRE {
    public int find (int num, List<Integer> skills, int minAssociates, int minLevel, int maxLevel) {
        List<Integer> team = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < skills.size(); i++) {
            int skill = skills.get(i);
            if (skill >= minLevel && skill <= maxLevel) {
                team.add(skill);
            }
        }
        System.out.println(team.size());
        int[] max = new int[]{0};
        helper(res, team, max, 0, new ArrayList<>(), minAssociates);
        return max[0];
    }
    private void helper(List<List<Integer>> res, List<Integer> team, int[] max, int index, List<Integer> possible, int minAssociates) {
        if (!res.contains(possible) && possible.size() >= minAssociates) {
            max[0]++;
            res.add(new ArrayList<Integer>(possible));
            System.out.println(possible);
        }
        for (int i = index; i < team.size(); i++) {
            possible.add(team.get(i));
            helper(res, team, max, i + 1, possible, minAssociates);
            possible.remove(possible.size() - 1);
        }
    }
    public static void main(String[] args) {
        HIRE test = new HIRE();
        int num = 8;
        List<Integer> skills = new ArrayList<>(Arrays.asList(12,5,7,9,2,4,8,11));
        int minAssociates = 3;
        int minLevel = 3;
        int maxLevel = 8;
        int res = test.find(num, skills, minAssociates, minLevel, maxLevel);
        System.out.print(res);
    }
}
