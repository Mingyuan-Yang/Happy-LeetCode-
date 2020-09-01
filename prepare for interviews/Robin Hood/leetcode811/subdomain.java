import java.util.*;
public class subdomain {
//    public List<String> subdomainVisits(String[] cpdomains) {
//        HashMap<String, Integer> map = new HashMap<>();
//        List<String> res = new ArrayList<>();
//        for (int i = 0; i < cpdomains.length; i++) {
//            String s = cpdomains[i];
//            int[] get = get(s);
//            helper(s, get, map, res, new StringBuilder());
//        }
//        for (String str : map.keySet()) {
//            String s = String.valueOf(map.get(str));
//            s += " " + str;
//            res.add(s);
//        }
//        return res;
//    }
//    private void helper(String s, int[] get, HashMap<String, Integer> map, List<String> res, StringBuilder sb) {
//        int number = get[0];
//        int count = get[1];
//        for (int i = s.length() - 1; i > count; i--) {
//            if (sb.length() != 0) sb.insert(0, '.');
//            while (i > count && s.charAt(i) != '.') {
//                sb.insert(0, s.charAt(i--));
//            }
//            String a = sb.toString();
//            map.put(a, map.getOrDefault(a, 0) + number);
//        }
//    }
//    private int[] get(String s) {
//        int[] res = new int[2];
//        int number = 0;
//        int count = 0;
//        int i = 0;
//        while (s.charAt(i) != ' ') {
//            number = number * 10 + (s.charAt(i++) - '0');
//            count++;
//        }
//        res[0] = number;
//        res[1] = count;
//        return res;
//    }
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String s = cpdomains[i];
            String[] a = s.split(" ");
            int number = Integer.valueOf(a[0]);
            String[] b = a[1].split("\\.");

            String str = "";
            for (int j = b.length - 1; j >= 0; j--) {
                str = b[j] + (str.equals("") ? str : "." + str);
                map.put(str, map.getOrDefault(str, 0) + number);
            }
        }
       for (String key : map.keySet()) {
            String s = map.get(key) + " " + key;
            res.add(s);
        }
        return res;
    }
    public static void main(String[] args) {
        subdomain test = new subdomain();
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> res = test.subdomainVisits(cpdomains);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
