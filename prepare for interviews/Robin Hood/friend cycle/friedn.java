import java.util.*;
public class friedn {
    public List<String> find(String[] employees, String[] friendships) {
        List<String> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < friendships.length; i++) {
            String[] s = friendships[i].split(",");
            if (!map.containsKey(s[0])) {
                map.put(s[0], new ArrayList<>());
            }
            map.get(s[0]).add(s[1]);
            if (!map.containsKey(s[1])) {
                map.put(s[1], new ArrayList<>());
            }
            map.get(s[1]).add(s[0]);
        }
        for (int i = 0; i < employees.length; i++) {
            String str = employees[i];
            String s = str.split(",")[0];
            String r = "";
            if (map.containsKey(s)) {
                r = s + ":" + map.get(s);
            } else {
                r = s + ":" + "None";
            }
            res.add(r);
        }
        return res;
    }
    public static void main(String[] args) {
        friedn test = new friedn();
        String[] employees = new String[]{"1, Bill, Engineer", "2, Joe, HR", "3, Sally, Engineer",
                "4, Richard, Business", "6, Tom, Engineer"};
        String[] friendships = new String[]{"1,2", "1,3", "3,4"};
        List<String> res = test.find(employees, friendships);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
