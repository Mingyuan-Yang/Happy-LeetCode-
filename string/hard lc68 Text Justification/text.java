import java.util.*;
public class text {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int left = 0;
        while (left < words.length) {
            int right = findRight(words, left, maxWidth);
            String s = rerange(words, left, right, maxWidth);
            res.add(s);
            left = right + 1;
        }
        return res;
    }
    private String rerange(String[] words, int left, int right, int maxWidth) {
        if (left == right) {
            return one(words[left], maxWidth);
        }
        int len = words[left].length();
        for (int i = left + 1; i <= right; i++) {
            len += words[i].length();
        }
        boolean isLastLine = right == words.length - 1 ? true : false;
        int numberGap = right - left;
        int numberSpace = maxWidth - len;
        int numberSpaceBetween = isLastLine ? 1 : numberSpace / numberGap;
        int remain = isLastLine ? 0 : numberSpace % numberGap;
        String s = "";
        for (int i = left; i < right; i++) {
            s += words[i];
            s = emptySpace(s, numberSpaceBetween);
            if (remain-- > 0) s += " ";
        }
        s += words[right];
        if (isLastLine) return one(s, maxWidth);
        else return s;
    }
    private String emptySpace(String s, int distance) {
        for (int i = 0; i < distance; i++) {
            s += " ";
        }
        return s;
    }
    private String one(String s, int maxWidth) {
        return emptySpace(s, maxWidth - s.length());
    }
    private int findRight(String[] words, int left, int maxWidth) {
        int right = left;
        int len = words[right++].length();
        while (right < words.length && len + 1 + words[right].length() <= maxWidth) {
            len += words[right].length() + 1;
            right++;
        }
        return right - 1;
    }
    public static void main(String[] args) {
        text test = new text();
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        int width = 20;
        List<String> res = test.fullJustify(words, width);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
