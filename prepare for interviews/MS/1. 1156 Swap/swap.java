import java.util.*;
public class swap {
    public int maxRepOpt1(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = 0;
        int i = 0;
        while (i < text.length()) {
            int j = i;
            char c = text.charAt(i);
            while (j < text.length() && text.charAt(j) == c) {
                j++;
            }
            int k = j + 1;
            while (k < text.length() && text.charAt(k) == c) {
                k++;
            }
            max = Math.max(max, map.get(c) >= k - i ? k - i : k - i - 1);
            i = j;
        }
        return max;
    }
}
