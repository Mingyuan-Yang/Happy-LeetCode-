import java.util.*;
public class generate {
    public List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        dfs("", res, n, 0, 0);
        return res;
    }
    private void dfs(String s, List<String> res, int n, int left, int right) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }
        if (left < n) {
            dfs(s + "(", res, n, left + 1, right);
        }
        if (right < left) {
            dfs(s + ")", res, n, left, right + 1);
        }
    }
    public static void main(String[] args) {
        generate test = new generate();
        int n = 3;
        List<String> res = test.generateParentheses(n);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
