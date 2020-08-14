import java.util.*;
public class groupstring {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            String key = getKey(string);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(string);
        }
        return new ArrayList<List<String>>(map.values());
    }
    private String getKey(String s) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return "a";
        char[] arr = s.toCharArray();
        int offset = 'z' - arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] += offset;
            if (arr[i] >= 'z') {
                arr[i] -= 26;
            }
        }
        return Arrays.toString(arr);
    }
    public static void main(String[] args) {
        groupstring a = new groupstring();
        String[] strs = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> res = a.groupStrings(strs);
        System.out.print(res);
    }
}
