import java.util.*;
public class substringsContainAllCharacters {
    // same questions: 1358 1248 1234 1004 930 904 992 862 209
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        int res = 0;
        int len = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) count++;
            while (count == 3) {
                char x = s.charAt(left);
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) count--;
                left++;
                len++;
            }
            res +=  len;
        }
        return res;
    }
    public static void main(String[] args) {
        substringsContainAllCharacters test2 = new substringsContainAllCharacters();
        String s = "absnc";
        int res = test2.numberOfSubstrings(s);
        System.out.print(res);
    }
}
