import java.util.*;
public class wordprocessor {
    //Solution1
//    public List<String> processor(List<String> lines, int maxLen) {
//        List<String> res = new ArrayList<>();
//        if (lines == null || lines.size() == 0) return res;
//        String s = "";
//        for (int i = 0; i < lines.size(); i++) {
//            if (i == lines.size() - 1) {
//                s += lines.get(i);
//                break;
//            }
//            s += lines.get(i) + " ";
//        }
//        String[] str = s.split(" ");
//        int index = 0;
//        while (index < str.length) {
//            int len = 0;
//            int start = index;
//            while (index < str.length) {
//                if (len + str[index].length() > maxLen) {
//                    break;
//                }
//                len += str[index].length() + 1;
//                index++;
//            }
//            insert(str, start, index, res , len - 1, maxLen);
//        }
//        return res;
//    }
//    private void insert(String[] s, int start, int index, List<String> res, int len, int maxLen) {
//        if (start == index - 1) {
//            String str = s[start];
//            res.add(str);
//            return;
//        }
//        int remain = maxLen - len;
//        int round = remain / (index - start - 1);
//        int count = remain % (index - start - 1);
//        String str = "";
//        while (start < index) {
//            int i = round;
//            int j = count;
//            if (start == index - 1) {
//                str += s[start];
//                break;
//            }
//            str += s[start] + "-";
//            while (i > 0) {
//                str += "-";
//                i--;
//            }
//            if (j > 0) {
//                str += "-";
//                count--;
//            }
//            start++;
//        }
//        res.add(str);
//    }
    public List<String> processor(List<String> lines, int maxLen) {
        List<String> res = new ArrayList<>();
        String s = "";
        for (int i = 0; i < lines.size() - 1; i++) {
            s += lines.get(i) + " ";
        }
        s += lines.get(lines.size() - 1);
        String[] words = s.split(" ");
        int left = 0;
        while (left < words.length) {
            int right = findRight(left, words, maxLen);
            String str = rerange(left, right, words, maxLen);
            res.add(str);
            left = right + 1;
        }
        return res;
    }
    private String rerange(int left, int right, String[] words, int maxLen) {
        if (left == right) {
            String s = words[left];
            return s;
        }
        int len = words[left].length();
        for (int i = left + 1; i <= right; i++) {
            len += words[i].length();
        }
        int gap = right - left;
        int space = maxLen - len;
        int round = space / gap;
        int remain = space % gap;

        String s = "";
        for (int i = left; i < right; i++) { // O(n^2)
            s += words[i];
            s = insertEmpty(s, round);
            if (remain-- > 0) s += "-";
        }
        s += words[right];
        return s;
    }
    private String insertEmpty(String s, int round) {
        for (int i = 0; i < round; i++) {
            s += "-";
        }
        return s;
    }
    private int findRight(int left, String[] words, int maxLen) {
        int right = left;
        int len = words[right++].length();
        while (right < words.length && len + 1 + words[right].length() <= maxLen) {
            len += 1 + words[right].length();
            right++;
        }
        return right - 1;
    }
    public static void main(String[] args) {
        wordprocessor test = new wordprocessor();
        List<String> lines = new ArrayList<>();
        Collections.addAll(lines, "The day began as still as the",
                "night abruptly lighted with", "brilliant flame" );
        int maxLen = 20;
        List<String> res = test.processor(lines, maxLen);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
