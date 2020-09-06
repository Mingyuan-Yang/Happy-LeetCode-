import java.util.*;
public class partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<String>(), 0, s);
        return res;
    }
    private void backtrack(List<List<String>> res, List<String> list, int index, String s) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                backtrack(res, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        partitioning test = new partitioning();
        String s = "aab";
        List<List<String>> res = test.partition(s);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
