import java.util.*;
public class ancestor {
    // problem1
    public List<Integer> parent(int[][] input) {
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (int[] edge : input) {
            int parent = edge[0];
            int child = edge[1];
            indegree.put(parent, indegree.getOrDefault(parent, 0));
            indegree.put(child, indegree.getOrDefault(child, 0) + 1);

        }
        List<Integer> res = new ArrayList<>();
        for (Integer key : indegree.keySet()) {
            if (indegree.get(key) == 0 || indegree.get(key) == 1) {
                res.add(key);
            }
        }
        return res;
    }

    //problem2
    public boolean hasCommonAncestor(int[][] input, int x, int y) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : input) {
            int parent = edge[0];
            int child = edge[1];
            if (!map.containsKey(child)) {
                map.put(child, new ArrayList<>());
            }
            map.get(child).add(parent);
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        findAncestor(x, map, set1);
        findAncestor(y, map, set2);
//        System.out.print(set1 + " ");
//        System.out.println(" ");
//        System.out.print(set2 + " ");
        for (Integer i : set1) {
            if (set2.contains(i)) {
                return true;
            }
        }
        return false;
    }
    private void findAncestor(int a, HashMap<Integer, List<Integer>> map, HashSet<Integer> set) {
        //set.add(a); // discuss whether itself can be seen as a ancestor with interviewer
        List<Integer> list = map.get(a);
        if (list == null || list.size() == 0) return;
        for (Integer i : list) {
            set.add(i);
            findAncestor(i, map, set);
        }
    }

    //problem3
    public int findFarestAncestor(int[][] input, int x) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : input) {
            int parent = edge[0];
            int child = edge[1];
            if (!map.containsKey(child)) {
                map.put(child, new ArrayList<>());
            }
            map.get(child).add(parent);
        }
        List<int[]> ancestor = new ArrayList<>();
        ancestor.add(new int[]{x,0});
        dfs(map, x, 1, ancestor);
//        for (int i = 0; i < ancestor.size(); i++) {
//            System.out.println(ancestor.get(i)[0] + "," + ancestor.get(i)[1]);
//        }
        int max = ancestor.get(0)[1];
        int index = x;
        for (int i = 1; i < ancestor.size(); i++) {
            if (ancestor.get(i)[1] > max) {
                index = ancestor.get(i)[0];
                max = ancestor.get(i)[1];
            }
        }
        return index;
    }
    private void dfs(HashMap<Integer, List<Integer>> map, int x, int count, List<int[]> ancestor) {
        List<Integer> list = map.get(x);
        if (list == null || list.size() == 0) return;
        for (Integer i : list) {
            ancestor.add(new int[]{i, count});
            dfs(map, i, count + 1, ancestor);
        }
    }
    public static void main(String[] args) {
        ancestor test = new ancestor();
        int[][] input = new int[][]{{1,4}, {1,5}, {2,5}, {2,3},{3,6}, {6,7}, {9,7}, {10,9}};
        List<Integer> res1 = test.parent(input);
        for (int i = 0; i < res1.size(); i++) {
            //System.out.println(res1.get(i));
        }

        boolean flag = test.hasCommonAncestor(input, 7, 3);
        //System.out.println(flag);

        int res3 = test.findFarestAncestor(input, 7);
        System.out.print(res3);
    }
}
