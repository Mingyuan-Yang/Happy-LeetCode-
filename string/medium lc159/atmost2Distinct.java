import java.util.HashMap;

public class atmost2Distinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (!map.containsKey(c) && count == 2) {
                while (count == 2) {
                    char x = s.charAt(left);
                    map.put(x, map.get(x) - 1);
                    if (map.get(x) == 0) {
                        map.remove(x);
                        count--;
                    }
                    left++;
                }
                map.put(c, 1);
                count++;
            } else {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                    count++;
                }
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
    public static void main(String[] args) {
        atmost2Distinct test = new atmost2Distinct();
        String s = "a";
        int r = test.lengthOfLongestSubstringTwoDistinct(s);
        System.out.print(r);
    }
}
