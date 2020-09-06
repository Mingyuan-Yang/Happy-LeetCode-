import java.util.*;
public class phonenumber {
    public List<String> phone(String s) {
        List<String> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        backtrack(map, res, new StringBuilder(), s, 0);
        return res;
    }
    private void backtrack(HashMap<String, List<String>> map, List<String> res, StringBuilder sb, String s, int index) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        String str = s.substring(index, index + 1);
        if (map.containsKey(str)) {
            for (String ss : map.get(str)) {
                sb.append(ss);
                backtrack(map, res, sb, s, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public static void main(String[] args) {
        phonenumber test = new phonenumber();
        String s = "90";
        List<String> res = test.phone(s);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
