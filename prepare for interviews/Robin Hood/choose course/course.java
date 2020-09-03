import java.util.*;
public class course {
    // problem1
    public List<String> courses(List<List<String>> pair) {
        List<String> res = new ArrayList<>();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        List<String> student = new ArrayList<>();
        for (List<String> list : pair) {
            if (!map.containsKey(list.get(0))) {
                map.put(list.get(0), new HashSet<String>());
                student.add(list.get(0));
            }
            map.get(list.get(0)).add(list.get(1));

        }
        for (int i = 0; i < student.size() - 1; i++) {
            for (int j = i + 1; j < student.size(); j++) {
                String a = student.get(i);
                String b = student.get(j);
                String s = "[" + a + "," + b + "]:[";
                for (String str : map.get(a)) {
                    if (map.get(b).contains(str)) {
                        s += str + ",";
                    }
                }
                s += "]";
                res.add(s);
            }
        }
        return res;
    }

    //problem2
    //public
    public static void main(String[] args) {
        course test = new course();
        List<List<String>> pair = new ArrayList<>();
        List<String> l1 = new ArrayList<String>(Arrays.asList("58", "Software Design"));
        List<String> l2 = new ArrayList<String>(Arrays.asList("58", "Linear Algebra"));
        List<String> l3 = new ArrayList<String>(Arrays.asList("94", "Art History"));
        List<String> l4 = new ArrayList<String>(Arrays.asList("94", "Operating Systems"));
        List<String> l5 = new ArrayList<String>(Arrays.asList("17", "Software Design"));
        List<String> l6 = new ArrayList<String>(Arrays.asList("58", "Mechanics"));
        List<String> l7 = new ArrayList<String>(Arrays.asList("58", "Economics"));
        List<String> l8 = new ArrayList<String>(Arrays.asList("17", "Linear Algebra"));
        List<String> l9 = new ArrayList<String>(Arrays.asList("17", "Political Science"));
        List<String> l10 = new ArrayList<String>(Arrays.asList("94", "Economics"));
        List<String> l11 = new ArrayList<String>(Arrays.asList("25", "Economics"));
        Collections.addAll(pair, l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11);
        List<String> res = test.courses(pair);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
