import java.util.*;
public class stringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> map = new HashMap<>();
        int global_max = 0;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s.length() == 1) {
                map.put(s, 1);
                continue;
            }
            int max = 0;
            for (int j = 0; j < s.length(); j++) {
                String str = "";
                str += s.substring(0,j);
                str += s.substring(j+1, s.length());
                //System.out.println(str);
                if (map.containsKey(str)) {
                    max = Math.max(max, map.get(str));
                }
            }
            map.put(s, max + 1);
            System.out.println(map);
            global_max = Math.max(global_max, max + 1);
        }
        return global_max;
    }
    public static void main(String[] args) {
        stringChain test = new stringChain();
        String[] words = new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        int res = test.longestStrChain(words);
        System.out.println(res);
    }
}
