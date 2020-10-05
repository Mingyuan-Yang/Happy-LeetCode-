import java.util.*;
public class group {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = helper(str);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
    private String helper(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return Arrays.toString(c);
    }
}
