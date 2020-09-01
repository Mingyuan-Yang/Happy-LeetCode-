import java.util.*;
public class continuous {
    public List<String> find (List<String> l1, List<String> l2) {
        List<String> res = new ArrayList<>();
        if (l1 == null || l2 == null  || l1.size() == 0 || l2.size() == 0) return res;
        int len1 = l1.size();
        int len2 = l2.size();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = 0;
        int row = 0;
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (l1.get(i-1).equals(l2.get(j-1))) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > max) {
                        row = i - 1;
                        max = dp[i][j];
                    }
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
        while (max != 0) {
            res.add(0, l1.get(row));
            row--;
            max--;
        }
        return res;
    }
    public static void main (String[] args) {
        continuous test = new continuous();
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        Collections.addAll(l1, "3234.html", "xys.html", "7hsaa.html", "abc2");
        Collections.addAll(l2, "3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html", "abc2");
        List<String> res = test.find(l1, l2);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
