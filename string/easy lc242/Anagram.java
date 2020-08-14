import java.util.*;
public class Anagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) return false;
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }
            }
        }
        return count == 0 ? true : false;
    }

    public static void main(String[] args) {
        Anagram test = new Anagram();
        String s = "anagram";
        String t = "nagaram";
        boolean res = test.isAnagram(s, t);
        System.out.print(res);
    }
}
