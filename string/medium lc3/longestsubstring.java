import java.util.*;
public class longestsubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) == 1) {
                while (s.charAt(left) != c) {
                    map.put(s.charAt(left), 0);
                    left++;
                }
                left++;
            } else {
                map.put(c, 1);
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
    public static void main(String[] args) {
        longestsubstring a = new longestsubstring();
        String s = "pwwkew";
        int res = a.lengthOfLongestSubstring(s);
        System.out.print(res);
    }
}
