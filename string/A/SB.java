import java.util.*;
public class SB {
    public int findLatestStep(int[] arr, int m) {
        StringBuilder sb = new StringBuilder();
        int len = arr.length;
        while (len > 0) {
            sb.append("0");
            len--;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            sb.setCharAt(a-1, '1');
            int level = i + 1;
            map = helper(sb, level, map);
        }
        //System.out.println(map);
        int max = 0;
        System.out.println(map);
        for (Integer key : map.keySet()) {
            if (key == m) {
                return map.get(key);
            }
        }
        return -1;
    }
    private HashMap<Integer, Integer> helper(StringBuilder sb, int index, HashMap<Integer, Integer> map) {
        int count = 0;
        int level = index;
        for (int i = 0; i < sb.length(); i++) {
            while (i < sb.length() && sb.charAt(i++) == '1') {
                count++;
            }
            if (map.containsKey(count)) map.put(count, level);
            if (count != 0) map.put(count, level);
            count = 0;
            i--;
        }
        return map;
    }
    public static void main(String[] args) {
        SB test = new SB();
        int[] arr = new int[]{3,5,1,2,4};
        int m = 1;
        int res = test.findLatestStep(arr, m);
        System.out.print(res);
    }
}

