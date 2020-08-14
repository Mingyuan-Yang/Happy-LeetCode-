import java.util.*;
public class groupanagrams {
      //solution1
    // nklogk
//    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String, List<String>> map = new HashMap<>();
//        for (String str : strs) { // nklogk
//            char[] c = str.toCharArray();
//            Arrays.sort(c); // klogk
//            String s = String.valueOf(c);
//            if (!map.containsKey(s)) {
//                List<String> list = new ArrayList<String>();
//                list.add(str);
//                map.put(s, list);
//            } else {
//                map.get(s).add(str);
//            }
//        }
//        return new ArrayList<List<String>>(map.values());

//}

    //solution2
    // O(NK)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        char[] arr = new char[26];
        for (String str : strs) {
            String key = hash(str, arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
    private String hash(String s, char[] arr) {
        Arrays.fill(arr, '0');
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        return Arrays.toString(arr);
    }
    public static void main(String[] args) {
        groupanagrams s = new groupanagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = s.groupAnagrams(strs);
        System.out.print(res);
    }
}
