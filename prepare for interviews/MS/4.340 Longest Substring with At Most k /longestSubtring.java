import java.util.*;
public class longestSubtring {
    public int engthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) count++;
            while (count > k) {
                char x = s.charAt(left);
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) count--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
