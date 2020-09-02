import java.util.*;
public class wordwrap {
    public List<String> word(String[] word, int maxLen) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length == 0) return res;
        int len = 0;
        int i = 0;
        while (i < word.length) {
            if (len + word[i].length() > maxLen) {
                break;
            }
            len += word[i].length() + 1;
            i++;
        }
        for (int j = 0; j < i; j++) {
            if (j == i - 1) {
                res.add(word[j]);
                break;
            }
            res.add(word[j] + "-");
        }
        return res;
    }
    public static void main(String[] args) {
        wordwrap test = new wordwrap();
        String[] word = new String[]{"leetcode", "is", "a", "website", "yes"};
        int maxLen = 100;
        List<String> res = test.word(word, maxLen);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
    }
}
