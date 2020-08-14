import java.util.*;
public class wordbreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Time : O(n^3)
        // Space : O(n)
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        boolean[] M = new boolean[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) { // substring(0,i) exclude i-th element,substring=[ )
            if (set.contains(s.substring(0, i))) {
                M[i] = true;
                continue;
            }
            for (int j = 1; j < i; j++) {
                if (M[j] == true && set.contains(s.substring(j,i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[s.length()];
    }
    public static void main(String[] args) {
        wordbreak test9 = new wordbreak();
        String s = "applepenapple";
        List<String> wordDic = new ArrayList<String>();
        wordDic.add("apple");
        wordDic.add("pen");
        boolean res = test9.wordBreak(s, wordDic);
        System.out.print(res);
    }
}
