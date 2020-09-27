import java.util.*;
public class queen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        helper(n, new ArrayList<>(), res, 0, set);
        return res;
    }
    private void helper(int n, List<String> list, List<List<String>> res, int row, HashSet<Integer> set) {
        if (row == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) continue;
            String s = set(i, n);
            if (isValid(list, row, i, n)) {
                list.add(s);
                set.add(i);
                helper(n, list, res, row + 1, set);
                list.remove(list.size() - 1);
                set.remove(i);
            }
        }
    }
    private boolean isValid(List<String> list, int row, int column, int n) {
        for (int i = 0; i < row; i++) {
            String str = list.get(i);
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == 'Q') {
                    if (Math.abs(row - i) == Math.abs(column - j)) return false;
                }
            }
        }
        return true;
    }
    private String set(int i, int n) {
        String s = "";
        for (int k = 0; k < n; k++) {
            if (k == i) {
                s += 'Q';
            } else {
                s += '.';
            }
        }
        return s;
    }
    public static void main(String[] args) {
        queen test = new queen();
        List<List<String>> res = test.solveNQueens(6);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(0).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("");
        }
    }
}
