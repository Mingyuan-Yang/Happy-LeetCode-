import java.util.*;
public class wordwrap {
    public List<String> word(String[] word, int maxLen) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length == 0) return res;
        int len = 0;
        int left = 0;
        while (left < word.length) {
            int right = findRight(left, word, maxLen);
            String s = rerange(left, right, word);
            res.add(s);
            left = right + 1;
        }
        return res;
    }
    private String rerange(int left, int right, String[] word) {
        String s = "";
        for (int i = left; i < right; i++) {
            s += word[i] + "-";
        }
        s += word[right];
        return s;
    }
    private int findRight(int left, String[] word, int maxLen) {
        int right = left;
        int len = word[right++].length();
        while (right < word.length && len + 1 + word[right].length() <= maxLen) {
            len += word[right].length() + 1;
            right++;
        }
        return right - 1;
    }
    public static void main(String[] args) {
        wordwrap test = new wordwrap();
        String[] word = new String[]{"1p3acres", "is", "a", "good", "place", "to", "communicate"
                //"leetcode", "is", "a", "website", "yes"
        };
        int maxLen = 12;
        List<String> res = test.word(word, maxLen);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
