import java.util.*;
public class wordprocessor {
    public List<String> processor(List<String> lines, int maxLen) {
        List<String> res = new ArrayList<>();
        if (lines == null || lines.size() == 0) return res;
        String s = "";
        for (int i = 0; i < lines.size(); i++) {
            if (i == lines.size() - 1) {
                s += lines.get(i);
                break;
            }
            s += lines.get(i) + " ";
        }
        String[] str = s.split(" ");
        int index = 0;
        while (index < str.length) {
            int len = 0;
            int start = index;
            while (index < str.length) {
                if (len + str[index].length() > maxLen) {
                    break;
                }
                len += str[index].length() + 1;
                index++;
            }
            insert(str, start, index, res , len - 1, maxLen);
        }
        return res;
    }
    private void insert(String[] s, int start, int index, List<String> res, int len, int maxLen) {
        if (start == index - 1) {
            String str = s[start];
            res.add(str);
            return;
        }
        int remain = maxLen - len;
        int round = remain / (index - start - 1);
        int count = remain % (index - start - 1);
        String str = "";
        while (start < index) {
            int i = round;
            int j = count;
            if (start == index - 1) {
                str += s[start];
                break;
            }
            str += s[start] + "-";
            while (i > 0) {
                str += "-";
                i--;
            }
            if (j > 0) {
                str += "-";
                count--;
            }
            start++;
        }
        res.add(str);
    }
    public static void main(String[] args) {
        wordprocessor test = new wordprocessor();
        List<String> lines = new ArrayList<>();
        Collections.addAll(lines, "The day began as still as the",
                "night abruptly lighted with", "brilliant flame" );
        int maxLen = 24;
        List<String> res = test.processor(lines, maxLen);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
