import java.util.*;
public class phoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        HashMap<Character, List<String>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        backtrack(res, digits, "", 0, map);
        return res;
    }
    private void backtrack(List<String> res, String digits, String s, int index, HashMap<Character, List<String>> map) {
        if (s.length() == digits.length()) {
            res.add(s);
        }
        for (int i = index; i < digits.length(); i++) {
            for (String c : map.get(digits.charAt(i))) {
                backtrack(res, digits, s + c, i + 1, map);
            }
        }
    }
}
