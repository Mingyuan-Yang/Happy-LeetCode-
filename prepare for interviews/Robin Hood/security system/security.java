import java.util.*;
public class security {
    //problem1
    public List<List<String>> enter_exit(String[][] list) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] s : list) {
            String name = s[0];
            String action = s[1];
            if (action == "exit") {
                map.put(name, map.getOrDefault(name, 0) - 1);
            } else {
                map.put(name, map.getOrDefault(name, 0) + 1);
            }
        }
        int i = 0;
        int j = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                res.get(0).add(key);
            } else if (map.get(key) < 0) {
                res.get(1).add(key);
            }
        }
        return res;
    }
    //problem2
    public List<List<String>> enter_exit2(String[][] list) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String[] s : list) {
            String name = s[0];
            String time = s[1];
            if (!map.containsKey(name)) {
                List<String> l = new ArrayList<>();
                map.put(name, l);
            }
            map.get(name).add(time);
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() < 3) continue;
            helper(res, key, map);
        }
        return res;
    }
    private void helper(List<List<String>> res, String key, HashMap<String, List<String>> map) {

        List<String> list = map.get(key);
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list2.add(Integer.valueOf(list.get(i)));
        }
        Collections.sort(list2);
        int flag = 0;
        int i = 0;
        int count = 2;
        for (; i < list2.size(); i++) {
            while (i + count < list2.size() && (list2.get(i+count) - list2.get(i) <= 100)) {
                count++;
                flag = 1;
            }
            if (flag == 1) break;
        }
        if (flag == 0) return;
        List<String> l = new ArrayList<>();
        Collections.addAll(l, key + ":");
        while (i < count) {
            l.add(String.valueOf(list2.get(i++)));
        }
        res.add(l);
    }



    //problem3





    
    public static void main(String[] args) {
        //problem1
        security test = new security();
        String[][] list = new String[][]{{"a","enter"},{"b","enter"},{"c","enter"},{"b","exit"},{"b","exit"}};

                /*
                {"Martha","exit"}, {"Paul","enter"}, {"Martha","enter"}, {"Martha","exit"},
                {"Jennifer","enter"}, {"Paul","enter"}, {"Curtis","enter"},
                {"Paul","exit"}, {"Martha","enter"}, {"Martha","exit"}, {"Jennifer","exit"}};
                 */

       List<List<String>> res = test.enter_exit((list));
        for (int i = 0; i < 2; i++) {
            //System.out.println(res.get(i));
        }


        //problem2
        String[][] list2 = new String[][]{{"Paul", "1355"}, {"Jennifer", "1910"}, {"John", "830"}, {"Paul", "1315"},
                {"John", "835"},{"Paul", "1405"},{"Paul", "1630"},{"John", "855"},{"John", "915"},{"John", "930"},
                {"Jennifer", "1335"},{"Jennifer", "730"},{"John", "1630"}};
        List<List<String>> res2 = test.enter_exit2(list2);
        for (int j = 0; j < res2.size(); j++) {
            System.out.println(res2.get(j));
        }
    }
}
