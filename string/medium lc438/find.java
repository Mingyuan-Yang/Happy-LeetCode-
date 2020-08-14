import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class find {
    public List<Integer> findALlAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }
            while (count == 0) {
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                char q = s.charAt(left);
                if (map.containsKey(q)) {
                    map.put(q, map.get(q) + 1);
                    if (map.get(q) > 0) count++;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        find so = new find();
        String s = "cbaebabacdabc";
        String p = "abc";
        List<Integer> res = new ArrayList<>(so.findALlAnagrams(s, p));
        System.out.print(res);
    }
}
