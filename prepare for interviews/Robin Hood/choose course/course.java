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
                if(s.charAt(s.length() - 1) == ',') s = s.substring(0, s.length() - 1);
                s += "]";
                res.add(s);
            }
        }
        return res;
    }

    //problem2
//    Students may decide to take different "tracks" or sequences of courses in the Computer Science curriculum.
//    There may be more than one track that includes the same course, but each student follows a single linear track
//    from a "root" node to a "leaf" node. In the graph below, their path always moves left to right.
//
//    Write a function that takes a list of (source, destination) pairs, and returns the name of all of the courses that
//    the students could be taking when they are halfway through their track of courses.
    public List<String> courses2(List<List<String>> pair) {
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        HashSet<String> possibleRoot = new HashSet<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (List<String> p : pair) {
            if (!map.containsKey(p.get(0))) {
                map.put(p.get(0), new ArrayList<String>());
            }
            map.get(p.get(0)).add(p.get(1));
            possibleRoot.add(p.get(1));
        }
        //System.out.println(map);
        List<String> root = new ArrayList<>();
        for (String key : map.keySet()) {
            if (!possibleRoot.contains(key)) {
                root.add(key);
            }
        }
        for (int i = 0; i < root.size(); i++) {
            String s = root.get(i);
            dfs(s, map, set, new ArrayList<>());
        }
        //System.out.println(set);
        for (String s : set) {
            res.add(s);
        }
        return res;
    }
    private void dfs(String s, HashMap<String, List<String>> map, HashSet<String> set, List<String> list) {
        list.add(s);
        if (!map.containsKey(s)) {
            if (list.size() % 2 == 0) {
                set.add(list.get(list.size() / 2 - 1));
            } else {
                set.add(list.get(list.size() / 2));
            }
//            for (int i = 0; i < list.size(); i++) {
//                //System.out.print(list.get(i) + ",");
//            }
//            //System.out.println(" ");
            return;
        }
        for (String str : map.get(s)) {
            dfs(str, map, set, list);
            list.remove(list.size() - 1);
        }
        //list.remove(list.size() - 1);
    }
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
            //System.out.println(res.get(i));
        }

        List<List<String>> pair2 = new ArrayList<>();
        List<String> ll1 = new ArrayList<>(Arrays.asList("Logic", "COBOL"));
        List<String> ll2 = new ArrayList<>(Arrays.asList("Data Structures", "Algorithms"));
        List<String> ll3 = new ArrayList<>(Arrays.asList("Creative Writing", "Data Structures"));
        List<String> ll4 = new ArrayList<>(Arrays.asList("Algorithms", "COBOL"));
        List<String> ll5 = new ArrayList<>(Arrays.asList("Intro to Computer Science", "Data Structures"));
        List<String> ll6 = new ArrayList<>(Arrays.asList("Logic", "Compilers"));
        List<String> ll7 = new ArrayList<>(Arrays.asList("Data Structures", "Logic"));
        List<String> ll8 = new ArrayList<>(Arrays.asList("Creative Writing", "System Administration"));
        List<String> ll9 = new ArrayList<>(Arrays.asList("Databases", "System Administration"));
        List<String> ll10 = new ArrayList<>(Arrays.asList("Creative Writing", "Databases"));
        List<String> ll11 = new ArrayList<>(Arrays.asList("Intro to Computer Science", "Graphics"));
        Collections.addAll(pair2, ll1,ll2,ll3,ll4,ll5,ll6,ll7,ll8,ll9,ll10,ll11);
        List<String> res2 = test.courses2(pair2);
        for (int i = 0; i < res2.size(); i++) {
            System.out.println(res2.get(i));
        }
    }
}
